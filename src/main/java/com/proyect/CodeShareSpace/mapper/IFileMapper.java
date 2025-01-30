package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.solution.FileSolutionDto;
import com.proyect.CodeShareSpace.dto.task.FileTasksDto;
import com.proyect.CodeShareSpace.model.File.FileSolution;
import com.proyect.CodeShareSpace.model.File.FileTask;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IFileMapper {
    @Mapping(source = "task.taskId", target = "taskId")
    FileTasksDto mapToFileTaskDto(FileTask fileTask);

    @Mapping(source = "solution.solutionId",target = "solutionId")
    FileSolutionDto mapToFileSolutionDto(FileSolution fileSolution);
}
