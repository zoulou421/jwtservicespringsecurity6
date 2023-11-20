package com.formationkilo.jwtservicespringsecurity6.config.security.repository;

import com.formationkilo.jwtservicespringsecurity6.config.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
