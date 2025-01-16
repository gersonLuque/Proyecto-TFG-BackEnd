package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        return new ResponseEntity<>(iUserService.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> findById(@PathVariable Long userId){
        return new ResponseEntity<>(iUserService.findById(userId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> crear(){
        return ResponseEntity.ok("estoy creando un usuario");
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        return null;
    }




}
