package com.formationkilo.jwtservicespringsecurity6.config.security.web;

import com.formationkilo.jwtservicespringsecurity6.config.security.entities.AppRole;
import com.formationkilo.jwtservicespringsecurity6.config.security.entities.AppUser;
import com.formationkilo.jwtservicespringsecurity6.config.security.service.IAccountService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountRestController {
    private IAccountService accountService;

    public AccountRestController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/listUsers")
    public List<AppUser>listUser(){
        return accountService.listUsers();
    }

    @PostMapping (path = "/users")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }

    @PostMapping (path = "/roles")
    public AppRole saveRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }

    @PostMapping (path = "/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
      accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRoleName());
    }
}

@Data
class RoleUserForm{
    private String username;
    private String roleName;
}