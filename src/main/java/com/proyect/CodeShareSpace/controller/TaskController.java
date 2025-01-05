package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.TaskDto;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tasks")
@CrossOrigin("*")
public class TaskController {


    @Autowired
    private ITaskService iTaskService;
    @GetMapping("{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId){
        return new ResponseEntity<>(iTaskService.findById(taskId), HttpStatus.OK);
    }
}
