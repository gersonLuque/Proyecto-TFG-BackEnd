package com.proyect.CodeShareSpace.mappers;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.SolutionDto;
import com.proyect.CodeShareSpace.mapper.ISolutionMapper;
import com.proyect.CodeShareSpace.persistence.model.Solution;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionMapperTest {

    private ISolutionMapper iSolutionMapper = Mappers.getMapper(ISolutionMapper.class);

    @Test
    public void testSolutionToSolutionDto(){
        // Given
        Solution solution = DataProvider.newSolutionMock();

        // When - se mapea  Solution -> SolutionDto
        SolutionDto solutionDto = iSolutionMapper.solutionToSolutionDto(solution);

        // Then
        assertNotNull(solutionDto);
        assertEquals(solutionDto.getSolutionId(), solution.getSolutionId());
        assertEquals(solutionDto.getTaskId(), solution.getTask());
        assertEquals(solutionDto.isAnonymous(), solution.isAnonymous());
    }

    @Test
    public void testSolucionDtoToSolution(){
        // Given
        SolutionDto solutionDto = DataProvider.newSolutionDtoMock();

        // When - se mapea SolutionDto -> Solution
        Solution solution = iSolutionMapper.solutionDtoToSolution(solutionDto);

        // Then
        assertNotNull(solution);
        assertEquals(solution.getSolutionId(), solutionDto.getSolutionId());
        assertEquals(solution.getTask().getTaskId(), solutionDto.getTaskId());
    }

}
