package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.solution.CreateSolutionDto;
import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import com.proyect.CodeShareSpace.service.interfaces.ISolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/solutions")
public class SolutionController {

    @Autowired
    private ISolutionService iSolutionService;

    @PostMapping
    public ResponseEntity<SolutionDto> createSolution(@ModelAttribute CreateSolutionDto createSolutionDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iSolutionService.createSolution(createSolutionDto));
    }
}
