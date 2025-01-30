package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.solution.CreateSolutionDto;
import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import com.proyect.CodeShareSpace.dto.solution.UpdateSolutionDto;
import com.proyect.CodeShareSpace.service.interfaces.ISolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping
    public ResponseEntity<SolutionDto> updateSolution(@ModelAttribute UpdateSolutionDto updateSolutionDto){
        return ResponseEntity.ok(iSolutionService.updateSolution(updateSolutionDto));
    }
}
