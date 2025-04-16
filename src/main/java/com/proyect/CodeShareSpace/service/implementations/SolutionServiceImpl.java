package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.solution.CreateSolutionDto;
import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import com.proyect.CodeShareSpace.dto.solution.UpdateSolutionDto;
import com.proyect.CodeShareSpace.exception.*;
import com.proyect.CodeShareSpace.mapper.ISolutionMapper;
import com.proyect.CodeShareSpace.model.File.FileSolution;
import com.proyect.CodeShareSpace.model.Rol;
import com.proyect.CodeShareSpace.model.Solution;
import com.proyect.CodeShareSpace.model.Task;
import com.proyect.CodeShareSpace.model.User;
import com.proyect.CodeShareSpace.repository.SolutionRepository;
import com.proyect.CodeShareSpace.repository.TaskRepository;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.IAuthService;
import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import com.proyect.CodeShareSpace.service.interfaces.ISolutionService;
import com.proyect.CodeShareSpace.service.interfaces.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;
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

    @Autowired
    private IS3Service is3Service;

    @Autowired
    private IAuthService iAuthService;

    @Override
    public List<SolutionDto> getSolutionsByTaskId(Long taskId){

        Rol rol = iAuthService.getAuthenticatedRol();
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Tarea no encontrada"));

        if (Rol.STUDENT == rol && !task.isTaskEnded())
            throw new UnauthorizedException("El estudiante aun no puede ver las soluciones");

        List<Solution> solutions =  solutionRepository.findByTask_TaskId(taskId);
        return solutions.stream()
                .map(iSolutionMapper::solutionToSolutionDto)
                .collect(Collectors.toList());
    }

    @Override
    public SolutionDto getContentS3Solution(Long solutionId) {
        Solution solution = solutionRepository.findById(solutionId)
                .orElseThrow(() -> new SolutionNotFoundException("Solucion no encontrada"));


        Rol rol = iAuthService.getAuthenticatedRol();
        if (Rol.STUDENT == rol){
            Long userIdAuthenticated = iAuthService.getUserAuthenticated().getUserId();
            if (!solution.getTask().isTaskEnded() && userIdAuthenticated != solution.getStudent().getUserId() ){
                throw new UnauthorizedException("El estudiante aun no puede ver soluciones ajenas");
            }
        }

        SolutionDto solutionDto = iSolutionMapper.solutionToSolutionDto(solution);
        is3Service.setContentS3(solutionDto.getFileSolutions());
        return solutionDto;
    }
    @Override
    public SolutionDto createSolution(CreateSolutionDto createSolutionDto){
        Solution solution = iSolutionMapper.mapToSolution(createSolutionDto);
        Task task = taskRepository.findById(createSolutionDto.getTaskId())
                .orElseThrow(() -> new TaskNotFoundException("Tarea no encontrada"));


        User user = userRepository.findById(createSolutionDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        boolean taskHasSolution =
                solutionRepository.existsSolutionByTask_TaskIdAndStudent_UserId(task.getTaskId(),user.getUserId());

        if (taskHasSolution)
            throw new SolutionExistException("Ya has creado una solución para esta tarea");

        List<FileSolution> fileSolutions = iStorageService.upload(createSolutionDto.getFiles(),FileSolution::new);

        solution.setTask(task);
        solution.setStudent(user);
        solution.setFileSolutions(fileSolutions);

        return iSolutionMapper.solutionToSolutionDto(solutionRepository.save(solution));
    }

    @Transactional
    @Override
    public SolutionDto updateSolution(UpdateSolutionDto updateSolutionDto) {
        Solution solution = solutionRepository.findById(updateSolutionDto.getSolutionId())
                .orElseThrow(() -> new SolutionNotFoundException("Solucion no encontrada"));

        if(updateSolutionDto.isFilesHasChanged()){
            List<FileSolution> fileSolutions =
                    iStorageService.update(updateSolutionDto.getFiles(),solution.getFileSolutions(),FileSolution::new);
            solution.setFileSolutions(fileSolutions);
        }
        solution.setAnonymous(updateSolutionDto.isAnonymous());
        return iSolutionMapper.solutionToSolutionDto(solutionRepository.save(solution));
    }

    @Override
    public SolutionDto getSolutionByUserAndTask(Long taskId, Long userId) {
        Optional<Solution> solution =
                solutionRepository.findByTask_TaskIdAndStudent_UserId(taskId,userId);

        if (!solution.isPresent())
          throw new SolutionNotFoundException("Solucion no encontrada");

        return iSolutionMapper.solutionToSolutionDto(solution.get());
    }

    @Override
    public void deleteSolution(Long solutionId) {
        Solution solution = solutionRepository.findById(solutionId)
                .orElseThrow(() -> new SolutionNotFoundException("Solucion no encontrada"));
        iStorageService.delete(solution.getFileSolutions());
        solutionRepository.delete(solution);
    }

    @Override
    public SolutionDto getSolutionById(Long solutionId) {
        Solution solution = solutionRepository.findById(solutionId)
                .orElseThrow(() -> new SolutionNotFoundException("Solucion no encontrada"));
        return iSolutionMapper.solutionToSolutionDto(solution);
    }

    @Override
    public Long getUserIdFromSolution(Long solutionId) {
        Solution solution = solutionRepository.findById(solutionId)
                .orElseThrow(() -> new SolutionNotFoundException("Solucion no encontrada"));

        return solution.getStudent().getUserId();
    }
    @Override
    public SolutionDto updateStarSolution(Long solutionId, Boolean star) {

        // 1. Validar que el ID de la solución existe
        Solution solution = solutionRepository.findById(solutionId)
                .orElseThrow(() -> new SolutionNotFoundException("Solucion no encontrada"));

        // 2. Si el parámetro "star" no es null, actualizar el campo "starred"
        if(star != null)
            solution.setStar(star);

        return iSolutionMapper.solutionToSolutionDto(solutionRepository.save(solution));
    }
}
