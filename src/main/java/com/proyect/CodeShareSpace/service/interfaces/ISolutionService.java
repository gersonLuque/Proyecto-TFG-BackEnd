package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.SolutionDto;

import java.util.List;

public interface ISolutionService {
    SolutionDto findById(Long id);
    List<SolutionDto> getSolutionsByTaskId(Long taskId);
}
