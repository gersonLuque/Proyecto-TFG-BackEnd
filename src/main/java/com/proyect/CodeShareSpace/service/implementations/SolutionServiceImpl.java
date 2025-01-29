package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.solution.CreateSolutionDto;
import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import com.proyect.CodeShareSpace.exception.TaskNotFoundException;
import com.proyect.CodeShareSpace.exception.UserNotFoundException;
import com.proyect.CodeShareSpace.mapper.ISolutionMapper;
import com.proyect.CodeShareSpace.persistence.model.File.FileSolution;
import com.proyect.CodeShareSpace.persistence.model.Solution;
import com.proyect.CodeShareSpace.persistence.model.Task;
import com.proyect.CodeShareSpace.persistence.model.User;
import com.proyect.CodeShareSpace.repository.SolutionRepository;
import com.proyect.CodeShareSpace.repository.TaskRepository;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.ISolutionService;
import com.proyect.CodeShareSpace.service.interfaces.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SolutionServiceImpl implements ISolutionService {
    @Autowired
    private SolutionRepository solutionRepository;

    @Autowired
    private ISolutionMapper iSolutionMapper;

    @Autowired
    private IStorageService iStorageService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

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
    public SolutionDto createSolution(CreateSolutionDto createSolutionDto){
        Solution solution = iSolutionMapper.mapToSolution(createSolutionDto);
        Task task = taskRepository.findById(createSolutionDto.getTaskId())
                .orElseThrow(() -> new TaskNotFoundException("Tarea no encontrada"));

        User user = userRepository.findById(createSolutionDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        String prefix = UUID.randomUUID().toString();

        List<FileSolution> fileSolutions = iStorageService.upload(prefix,createSolutionDto.getFiles(),FileSolution::new);

        solution.setTask(task);
        solution.setStudent(user);
        solution.setFileSolutions(fileSolutions);

        return iSolutionMapper.solutionToSolutionDto(solutionRepository.save(solution));
    }
}
