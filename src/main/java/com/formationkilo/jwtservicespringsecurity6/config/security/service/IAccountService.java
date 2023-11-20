package com.formationkilo.jwtservicespringsecurity6.config.security.service;

import com.formationkilo.jwtservicespringsecurity6.config.security.entities.AppRole;
import com.formationkilo.jwtservicespringsecurity6.config.security.entities.AppUser;

import java.util.List;

public interface IAccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();

}
