package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.task.CreateTaskDto;
import com.proyect.CodeShareSpace.dto.task.TaskDto;
import com.proyect.CodeShareSpace.dto.task.UpdateTaskDto;
import com.proyect.CodeShareSpace.exception.CourseNotFoundException;
import com.proyect.CodeShareSpace.exception.TaskNotFoundException;
import com.proyect.CodeShareSpace.exception.UserNotFoundException;
import com.proyect.CodeShareSpace.mapper.ITaskMapper;
import com.proyect.CodeShareSpace.model.Course;
import com.proyect.CodeShareSpace.model.File.FileBase;
import com.proyect.CodeShareSpace.model.File.FileTask;
import com.proyect.CodeShareSpace.model.Task;
import com.proyect.CodeShareSpace.model.User;
import com.proyect.CodeShareSpace.repository.CourseRepository;
import com.proyect.CodeShareSpace.repository.SolutionRepository;
import com.proyect.CodeShareSpace.repository.TaskRepository;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.IStorageService;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ITaskMapper taskMapper;
    @Autowired
    private IStorageService iStorageService;
    @Autowired
    private SolutionRepository solutionRepository;

    @Override
    public List<TaskDto> findTasksByCourseId(Long courseId,Long userId) {
        List<Task> tasks = taskRepository.findByCourse_CourseId(courseId);
        List<TaskDto> taskDtos = taskMapper.tasksToTasksDto(tasks);

        for(TaskDto taskDto : taskDtos){
            taskDto.setHasSolution(hasSolution(userId,taskDto.getTaskId()));
        }
        return taskDtos;
    }
    private boolean hasSolution(Long userId,Long taskId){
        return solutionRepository.existsSolutionByTask_TaskIdAndStudent_UserId(userId,taskId);
    }

    @Override
    public TaskDto findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return taskMapper.taskToTaskDto(task.get());
    }

    @Override
    public TaskDto createTask(CreateTaskDto createTaskDto) {
        Task task = taskMapper.mapToTask(createTaskDto);
        task.setStartDate(LocalDate.now());

        User teacher = userRepository.findById(createTaskDto.getTeacherId())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        Course course = courseRepository.findById(createTaskDto.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException("Curso no encontrado"));

        List<FileTask> filesTask =  iStorageService.upload(createTaskDto.getFiles(),FileTask::new);
        task.setFiletasks(filesTask);

        task.setCourse(course);
        task.setTeacher(teacher);

        return taskMapper.taskToTaskDto(taskRepository.save(task));
    }

    // dado que hay varias operaciones en la bd todas se manejaran bajo el mismo contexto para evitar inconsistencias
    @Transactional
    @Override
    public TaskDto updateTask(UpdateTaskDto updateTaskDto) {
        Task task = taskRepository.findById(updateTaskDto.getTaskId())
                .orElseThrow(() -> new TaskNotFoundException("La tarea no existe"));


        if (updateTaskDto.isFilesHasChanged()){
            List<FileTask> fileTasks = iStorageService
                    .update(updateTaskDto.getFiles(),task.getFileTasks(),FileTask::new);
            task.setFiletasks(fileTasks);
        }
        task.setTitle(updateTaskDto.getTitle());
        task.setDescription(updateTaskDto.getDescription());
        task.setVisible(updateTaskDto.isVisible());
        task.setEndDate(updateTaskDto.getEndDate());
        task.setEndTime(updateTaskDto.getEndTime());
        return taskMapper.taskToTaskDto(taskRepository.save(task));
    }

    @Override
    public void deleteById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Tarea no encontrada"));

        iStorageService.delete(getFilesFromTask(task));
        taskRepository.delete(task);
    }

    @Override
    public List<FileBase> getFilesFromTask(Task task){

        List<FileBase> result = new ArrayList<>();
        result.addAll(task.getFileTasks());

        result.addAll(task.getSolutions().stream()
                .flatMap(solution -> solution.getFileSolutions().stream())
                .collect(Collectors.toList()));
        return result;
    }
}
