package com.cursos.api.springsecuritycourse.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {
    @Autowired
    private AuthenticationProvider daoAuthenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(csrfConfig->csrfConfig.disable())
                .sessionManagement(sessionConfig -> sessionConfig.
                        //stateless porque es con token y no con sessions
                        sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(daoAuthenticationProvider)
                .authorizeHttpRequests(authReqConfig ->{
                    //urls publicas en el metodo post
                   authReqConfig.requestMatchers(HttpMethod.POST,"/customers").permitAll();
                   authReqConfig.requestMatchers(HttpMethod.POST,"/auth/**")
                            .permitAll();
                   //el resto de endpoints necesitna ser autenticados
                   authReqConfig.anyRequest().authenticated();
                })
                .build();
    }
}
