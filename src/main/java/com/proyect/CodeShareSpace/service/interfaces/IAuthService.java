package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.ChangePasswordRequest;
import com.proyect.CodeShareSpace.dto.LoginRequest;
import com.proyect.CodeShareSpace.dto.LoginResponse;
import com.proyect.CodeShareSpace.model.Rol;
import com.proyect.CodeShareSpace.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IAuthService {
    LoginResponse singIn(LoginRequest loginRequest);
    void singOut(String jwt);
    Rol getAuthenticatedRol();
    User getUserAuthenticated();
    void resetPassword(ChangePasswordRequest changePasswordRequest);
}
