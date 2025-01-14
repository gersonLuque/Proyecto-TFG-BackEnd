package com.proyect.CodeShareSpace.mappers;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.SolutionDto;
import com.proyect.CodeShareSpace.mapper.ISolutionMapper;
import com.proyect.CodeShareSpace.persistence.model.Solution;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionMapperTest {

    private final ISolutionMapper iSolutionMapper = Mappers.getMapper(ISolutionMapper.class);

    @Test
    public void testSolutionToSolutionDto(){
        // TODO
    }

    @Test
    public void testSolucionDtoToSolution(){
        // TODO
    }

}
