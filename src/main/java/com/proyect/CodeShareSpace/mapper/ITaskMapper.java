package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.TaskDto;
import com.proyect.CodeShareSpace.persistence.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITaskMapper {

    TaskDto taskToTaskDto(Task task);

    // Optional: add explicit mappings for the nested entities (Course and User)
    Task taskDtoToTask(TaskDto taskDto);



    List<TaskDto> tasksToTasksDto(List<Task> tasks);
}
