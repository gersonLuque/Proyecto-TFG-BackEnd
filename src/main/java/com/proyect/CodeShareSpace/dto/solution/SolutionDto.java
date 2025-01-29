package com.proyect.CodeShareSpace.dto.solution;

import com.proyect.CodeShareSpace.dto.user.UserBasicDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SolutionDto {
    private Long solutionId;
    private Long taskId;
    private UserBasicDto userBasicDto;
    private String filePath;
    private boolean star;
    private boolean anonymous;
}
