package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.solution.CreateSolutionDto;
import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import com.proyect.CodeShareSpace.persistence.model.Solution;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {ITaskMapper.class, IUserMapper.class, IFileMapper.class})
public interface ISolutionMapper {

    @Mapping(source = "solution.solutionId", target = "solutionId")
    @Mapping(source = "task.taskId", target = "taskId")
    @Mapping(source = "student", target = "userBasicDto")  // Usa el UserMapper para mapear User -> UserBasicDto
    SolutionDto solutionToSolutionDto(Solution solution);
    Solution solutionDtoToSolution(SolutionDto solutionDto);
    Solution mapToSolution(CreateSolutionDto createSolutionDto);
}
