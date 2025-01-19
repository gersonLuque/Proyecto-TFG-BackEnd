package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.CourseCreateDto;
import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.dto.TaskDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.service.interfaces.ICourseService;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @Autowired
    private ITaskService iTaskService;

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        return new ResponseEntity<>(iCourseService.findAll(),HttpStatus.OK);
    }

    @GetMapping("{courseId}/users")
    public ResponseEntity<List<UserDto>> getUsersByCourse(@PathVariable Long courseId){
        List<UserDto> users = iCourseService.findUsersByCourseId(courseId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("{courseId}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long courseId){
        return new ResponseEntity<>(iCourseService.findById(courseId),HttpStatus.OK);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<CourseDto>> getCoursesByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(iCourseService.findByUserId(userId),HttpStatus.OK);
    }

    @GetMapping("{courseId}/tasks")
    public ResponseEntity<List<TaskDto>> getTaskByCourseId(@PathVariable Long courseId){
        return new ResponseEntity<>(iTaskService.findTasksByCourseId(courseId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseCreateDto courseCreateDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(iCourseService.createCourse(courseCreateDto));
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long courseId){
        return new ResponseEntity<>(iCourseService.deleteCourseById(courseId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
