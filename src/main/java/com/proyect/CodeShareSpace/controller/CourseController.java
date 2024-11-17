package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.service.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @GetMapping("{courseId}/users")
    public ResponseEntity<List<UserDto>> getUsersByCourse(@PathVariable Long courseId){
        List<UserDto> users = iCourseService.findUsersByCourseId(courseId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
