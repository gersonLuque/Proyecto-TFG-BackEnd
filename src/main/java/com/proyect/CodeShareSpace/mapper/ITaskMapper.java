package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.TaskDto;
import com.proyect.CodeShareSpace.persistence.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITaskMapper {
    TaskDto taskToTaskDto(Task task);
    Task taskDtoToTask(TaskDto taskDto);
    List<TaskDto> tasksToTasksDto(List<Task> tasks);
}
