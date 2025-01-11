package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.user.LoginRequest;
import com.proyect.CodeShareSpace.dto.user.LoginResponse;
import com.proyect.CodeShareSpace.persistence.model.User;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.IAuthService;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public LoginResponse singIn(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public LoginResponse singOut(String jwt) {
        return null;
    }
}
