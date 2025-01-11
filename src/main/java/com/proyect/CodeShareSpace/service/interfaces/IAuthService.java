package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.user.LoginRequest;
import com.proyect.CodeShareSpace.dto.user.LoginResponse;

public interface IAuthService {
    LoginResponse singIn(LoginRequest loginRequest);
    LoginResponse singOut(String jwt);
}
