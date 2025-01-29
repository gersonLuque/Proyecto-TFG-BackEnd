package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.solution.CreateSolutionDto;
import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/solutions")
public class SolutionController {

    @PostMapping
    public ResponseEntity<SolutionDto> createSolution(@ModelAttribute CreateSolutionDto createSolutionDto){

        return null;
    }
}
