package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.solution.CreateSolutionDto;
import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import com.proyect.CodeShareSpace.dto.solution.UpdateSolutionDto;

import java.util.List;

public interface ISolutionService {
    SolutionDto findById(Long id);
    List<SolutionDto> getSolutionsByTaskId(Long taskId);
    SolutionDto createSolution(CreateSolutionDto createSolutionDto);
    SolutionDto updateSolution(UpdateSolutionDto updateSolutionDto);
}
