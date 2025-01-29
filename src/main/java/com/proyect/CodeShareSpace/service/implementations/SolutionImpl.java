package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.solution.CreateSolutionDto;
import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import com.proyect.CodeShareSpace.mapper.ISolutionMapper;
import com.proyect.CodeShareSpace.persistence.model.Solution;
import com.proyect.CodeShareSpace.repository.SolutionRepository;
import com.proyect.CodeShareSpace.service.interfaces.ISolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolutionImpl implements ISolutionService {
    @Autowired
    private SolutionRepository solutionRepository;

    @Autowired
    private ISolutionMapper iSolutionMapper;

    @Override
    public List<SolutionDto> getSolutionsByTaskId(Long taskId){
        List<Solution> solutions =  solutionRepository.findByTask_TaskId(taskId);
        return solutions.stream()
                .map(iSolutionMapper::solutionToSolutionDto)
                .collect(Collectors.toList());
    }

    @Override
    public SolutionDto findById(Long id) {
        return null;
    }
    @Override
    public List<SolutionDto> createSolution(CreateSolutionDto createSolutionDto){
        
    }
}
