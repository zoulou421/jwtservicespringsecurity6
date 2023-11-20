package com.formationkilo.jwtservicespringsecurity6.config.security.service;

import com.formationkilo.jwtservicespringsecurity6.config.security.entities.AppRole;
import com.formationkilo.jwtservicespringsecurity6.config.security.entities.AppUser;
import com.formationkilo.jwtservicespringsecurity6.config.security.repository.IAppRoleRepository;
import com.formationkilo.jwtservicespringsecurity6.config.security.repository.IAppUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService{

    private IAppUserRepository appUserRepository;
    private IAppRoleRepository appRoleRepository;

    public AccountServiceImpl(IAppUserRepository appUserRepository, IAppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }
    @Override
    public AppUser addNewUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
      AppUser appUser =appUserRepository.findByUsername(username);
      AppRole appRole=appRoleRepository.findByRoleName(roleName);
      appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}
