package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.TaskDto;
import com.proyect.CodeShareSpace.persistence.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITaskMapper {

    @Mapping(source = "course.name",target = "courseName")
    @Mapping(source = "teacher.completeName", target = "nameTeacher")
    TaskDto taskToTaskDto(Task task);

    Task taskDtoToTask(TaskDto taskDto);

    List<TaskDto> tasksToTasksDto(List<Task> tasks);
}
