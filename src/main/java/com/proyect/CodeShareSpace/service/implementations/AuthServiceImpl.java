package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.LoginRequest;
import com.proyect.CodeShareSpace.dto.LoginResponse;
import com.proyect.CodeShareSpace.model.Rol;
import com.proyect.CodeShareSpace.model.User;
import com.proyect.CodeShareSpace.security.JwtService;
import com.proyect.CodeShareSpace.service.interfaces.IAuthService;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {


    @Autowired
    private IUserService iUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;


    @Override
    public LoginResponse singIn(LoginRequest loginRequest) {
        Optional<User> user = iUserService.findUserByUsername(loginRequest.getUsername());

        if (!user.isPresent())
            throw new UsernameNotFoundException("El usuario no existe");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

        return new LoginResponse(jwtService.createToken(user.get()));
    }

    @Override
    public void singOut(String jwt) {
        jwtService.tokenLogOut(jwt);
    }
    
    @Override
    public Rol getAuthenticatedRol(){
        var listaRoles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for ( var userAuthenticadedRole :listaRoles){
            for (Rol rol : Rol.values()){
                if (String.valueOf(userAuthenticadedRole).equals("ROLE_"+rol))
                    return rol;
            }
        }
        return null;
    }

    @Override
    public User getUserAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof User userDetails) {
            return userDetails;
        }
        return null;
    }
}
