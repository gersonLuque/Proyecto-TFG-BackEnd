package com.proyect.CodeShareSpace.dto.solution;

import com.proyect.CodeShareSpace.dto.user.UserBasicDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SolutionDto {
    private Long solutionId;
    private Long taskId;
    private UserBasicDto userBasicDto;
    private boolean star;
    private boolean anonymous;
    private List<FileSolutionDto> fileSolutions;
}
