package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.solution.CreateSolutionDto;
import com.proyect.CodeShareSpace.dto.solution.SolutionDto;

import java.util.List;

public interface ISolutionService {
    SolutionDto findById(Long id);
    List<SolutionDto> getSolutionsByTaskId(Long taskId);

    List<SolutionDto> createSolution(CreateSolutionDto createSolutionDto);
}
