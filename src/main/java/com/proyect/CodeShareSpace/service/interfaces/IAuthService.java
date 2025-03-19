package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.LoginRequest;
import com.proyect.CodeShareSpace.dto.LoginResponse;
import com.proyect.CodeShareSpace.model.Rol;

public interface IAuthService {
    LoginResponse singIn(LoginRequest loginRequest);
    void singOut(String jwt);

    Rol getAuthenticatedRol();
}
