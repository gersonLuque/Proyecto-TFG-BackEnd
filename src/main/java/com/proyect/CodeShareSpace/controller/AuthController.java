package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.LoginRequest;
import com.proyect.CodeShareSpace.dto.LoginResponse;
import com.proyect.CodeShareSpace.security.JwtService;
import com.proyect.CodeShareSpace.service.interfaces.IAuthService;
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

    @PostMapping("login")
    public ResponseEntity<LoginResponse> singIn(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(iAuthService.singIn(loginRequest));
    }
    @GetMapping("logout")
    public ResponseEntity<Void> singOut(HttpServletRequest request){
        iAuthService.singOut(jwtService.getTokenFromRequest(request));
        return ResponseEntity.ok().build();
    }
}
