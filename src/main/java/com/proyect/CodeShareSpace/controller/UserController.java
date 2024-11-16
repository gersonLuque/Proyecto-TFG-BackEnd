package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(iUserService.findById(id), HttpStatus.OK);
    }
}
