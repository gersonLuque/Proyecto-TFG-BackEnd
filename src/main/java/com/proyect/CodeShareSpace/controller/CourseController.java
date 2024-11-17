package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @GetMapping("{courseId}/users")
    public ResponseEntity<List<UserDto>> getUsersByCourse(Long id){
        return new ResponseEntity<>()
    }
}
