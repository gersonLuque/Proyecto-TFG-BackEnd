package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.LoginRequest;
import com.proyect.CodeShareSpace.dto.LoginResponse;

public interface IAuthService {
    LoginResponse singIn(LoginRequest loginRequest);
    void singOut(String jwt);
}
