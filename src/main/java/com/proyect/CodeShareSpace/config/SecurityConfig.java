package com.proyect.CodeShareSpace.config;

import com.proyect.CodeShareSpace.model.Rol;
import com.proyect.CodeShareSpace.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtFilter jwtFilter;

    private static final String ROL_TEACHER = Rol.TEACHER.name();
    private static final String ROL_STUDENT = Rol.STUDENT.name();
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(crsf -> crsf.disable())
                .authorizeHttpRequests(authorizedRequests ->
                        authorizedRequests
                                // endpoints usuarios
                                .requestMatchers("/api/users/**").hasRole(ROL_TEACHER)

                                // endpoints cursos

                                // endpoints tasks
                                .requestMatchers(HttpMethod.GET, "/api/tasks/{taskId}").hasAnyRole(ROL_STUDENT, ROL_TEACHER)
                                .requestMatchers(HttpMethod.DELETE,"/api/tasks/**").hasRole(ROL_TEACHER)
                                .requestMatchers(HttpMethod.POST,"/api/tasks/**").hasRole(ROL_TEACHER)
                                .requestMatchers(HttpMethod.PUT,"/api/tasks/**").hasRole(ROL_TEACHER)

                                .requestMatchers("api/auth/login").permitAll()
                                .anyRequest().authenticated())
                .sessionManagement( sesion -> sesion.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    // METODO PARA DESHABILITAR LA AUTENTICACION CON TOKEN
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable())
//                .authorizeRequests()
//                .anyRequest().permitAll()  // Permitir todas las solicitudes
//                .and()
//                .build();
//    }
}
