package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.TaskDto;
import com.proyect.CodeShareSpace.dto.UserDto;

import java.util.List;

public interface ITaskService {
    List<TaskDto> findAll();
    TaskDto findById(Long id);
}
