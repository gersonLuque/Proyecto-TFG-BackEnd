package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.ChangePasswordRequest;
import com.proyect.CodeShareSpace.dto.LoginRequest;
import com.proyect.CodeShareSpace.dto.LoginResponse;
import com.proyect.CodeShareSpace.security.JwtService;
import com.proyect.CodeShareSpace.service.interfaces.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private IAuthService iAuthService;

    @Autowired
    private JwtService jwtService;

    @Operation(
            summary = "Iniciar sesión",
            description = "Permite a un usuario iniciar sesión proporcionando sus credenciales en el objeto **LoginRequest**. Si las credenciales son correctas, se retorna un **LoginResponse** con el token JWT. **Roles requeridos: NINGUNO**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PostMapping("login")
    public ResponseEntity<LoginResponse> singIn(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(iAuthService.singIn(loginRequest));
    }

    @Operation(
            summary = "Cerrar sesión",
            description = "Permite a un usuario cerrar sesión invalidando su token JWT. El token se extrae del encabezado de la solicitud. **Roles requeridos: NINGUNO**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping("logout")
    public ResponseEntity<Void> singOut(HttpServletRequest request){
        iAuthService.singOut(jwtService.getTokenFromRequest(request));
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Cambiar password",
            description = "Permite a un usuario cambiar su propia password. **Roles requeridos: NINGUNO**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PostMapping("change-password")
    public ResponseEntity<Void> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
        iAuthService.resetPassword(changePasswordRequest);
        return ResponseEntity.noContent().build();
    }
}
