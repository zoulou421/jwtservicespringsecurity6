package com.formationkilo.jwtservicespringsecurity6.config.security.auth;

import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{

    //}
   // @Bean
 //   protected void configure(HttpSecurity httpSecurity)throws Exception{
       // httpSecurity.csrf().disable();
    //   httpSecurity.csrf(csrf -> csrf.disable());
        //httpSecurity.authorizeRequests().anyRequest().permitAll();
    //   httpSecurity.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());


 //  }

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
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/**")).permitAll()
                        //.requestMatchers(AntPathRequestMatcher.antMatcher("/listUsers/**")).hasRole("USER")

                );

        return httpSecurity.build();
    }

}
