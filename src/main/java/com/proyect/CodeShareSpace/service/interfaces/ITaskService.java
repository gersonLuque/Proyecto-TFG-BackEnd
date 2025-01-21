package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.task.TaskDto;

import java.util.List;

public interface ITaskService {
    List<TaskDto> findTasksByCourseId(Long courseId);
    TaskDto findById(Long taskId);
}
