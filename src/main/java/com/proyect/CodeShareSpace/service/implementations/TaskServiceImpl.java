package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.TaskDto;
import com.proyect.CodeShareSpace.mapper.ITaskMapper;
import com.proyect.CodeShareSpace.persistence.model.Task;
import com.proyect.CodeShareSpace.repository.CourseRepository;
import com.proyect.CodeShareSpace.repository.TaskRepository;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ITaskMapper taskMapper;
    @Override
    public List<TaskDto> findAll() {
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.tasksToTasksDto(tasks);
    }
    @Override
    public TaskDto findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return taskMapper.taskToTaskDto(task.get());
    }
}
