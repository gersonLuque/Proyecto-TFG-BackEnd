package com.proyect.CodeShareSpace.config;

import com.proyect.CodeShareSpace.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtFilter jwtFilter;

    // METODO PARA HABILITAR LA AUTENTICACION CON TOKEN
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(crsf -> crsf.disable())
//                .authorizeHttpRequests(authorizedRequests ->
//                        authorizedRequests.requestMatchers(HttpMethod.POST,"/api/users").hasRole("TEACHER")
//                                .requestMatchers("api/auth/login").permitAll()
//                                .anyRequest().authenticated())
//                .sessionManagement( sesion -> sesion.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }

    // METODO PARA DESHABILITAR LA AUTENTICACION CON TOKEN
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests()
                .anyRequest().permitAll()  // Permitir todas las solicitudes
                .and()
                .build();
    }
}
