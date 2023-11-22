package com.formationkilo.jwtservicespringsecurity6.config.security.auth;

import com.formationkilo.jwtservicespringsecurity6.config.security.entities.AppUser;
import com.formationkilo.jwtservicespringsecurity6.config.security.service.IAccountService;
import com.formationkilo.jwtservicespringsecurity6.config.security.service.IUserDetailService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.Collection;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {


    private IUserDetailService userDetailService;

    //protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{

    //}
   // @Bean
 //   protected void configure(HttpSecurity httpSecurity)throws Exception{
       // httpSecurity.csrf().disable();
    //   httpSecurity.csrf(csrf -> csrf.disable());
        //httpSecurity.authorizeRequests().anyRequest().permitAll();
    //   httpSecurity.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
   /* private IAccountService accountService;
    public SecurityConfig(IAccountService accountService) {
        this.accountService = accountService;
    }*/

    //  }
/*
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
       authenticationManagerBuilder.userDetailsService(new UserDetailsService() {
           @Override
           public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
               AppUser appUser =accountService.loadUserByUsername(username);
               Collection<GrantedAuthority>authorities=new ArrayList<>();
               appUser.getAppRoles().forEach(r->{
                   authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
               });
               return new User(appUser.getUsername(), appUser.getPassword(),authorities);
           }
       });
    }
*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())

                .headers((headers) ->
                        headers
                                .frameOptions((frameOptions) -> frameOptions.disable())
                )

                .authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                        //.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll(
                        //.requestMatchers(AntPathRequestMatcher.antMatcher("/**")).permitAll()
                        //.requestMatchers(AntPathRequestMatcher.antMatcher("/listUsers/**")).hasRole("USER")
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/**")).authenticated()

                );
               httpSecurity.formLogin(withDefaults());
               httpSecurity.userDetailsService(userDetailService);
        return httpSecurity.build();
    }

}
