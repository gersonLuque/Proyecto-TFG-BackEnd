package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.task.CreateTaskDto;
import com.proyect.CodeShareSpace.dto.task.TaskDto;
import com.proyect.CodeShareSpace.dto.task.UpdateTaskDto;
import com.proyect.CodeShareSpace.model.File.FileBase;
import com.proyect.CodeShareSpace.model.Task;

import java.util.List;

public interface ITaskService {
    List<TaskDto> findTasksByCourseId(Long courseId,Long userId);
    TaskDto findById(Long taskId);
    TaskDto createTask(CreateTaskDto createTaskDto);
    TaskDto updateTask(UpdateTaskDto updateTaskDto);
    void deleteById(Long taskId);

    List<FileBase> getFilesFromTask(Task task);
}
