package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.TaskDto;
import com.proyect.CodeShareSpace.mapper.ITaskMapper;
import com.proyect.CodeShareSpace.persistence.model.Task;
import com.proyect.CodeShareSpace.repository.TaskRepository;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ITaskMapper taskMapper;
    @Override
    public List<TaskDto> findTasksByCourseId(Long courseId) {
        List<Task> tasks = taskRepository.findByCourse_CourseId(courseId);
        return taskMapper.tasksToTasksDto(tasks);
    }
    @Override
    public TaskDto findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return taskMapper.taskToTaskDto(task.get());
    }
}
