package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.user.LoginRequest;
import com.proyect.CodeShareSpace.dto.user.LoginResponse;
import com.proyect.CodeShareSpace.service.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private IAuthService iAuthService;

    @PostMapping("login")
    public ResponseEntity<LoginResponse> singIn(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(iAuthService.singIn(loginRequest));
    }
}
