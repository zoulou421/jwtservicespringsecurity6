package com.formationkilo.jwtservicespringsecurity6.config.security.repository;

import com.formationkilo.jwtservicespringsecurity6.config.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
