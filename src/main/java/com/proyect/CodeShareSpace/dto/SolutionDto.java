package com.proyect.CodeShareSpace.dto;

import com.proyect.CodeShareSpace.persistence.model.Task;
import com.proyect.CodeShareSpace.persistence.model.User;
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
    private Long studentId;
    private String filePath;
    private boolean star;
    private boolean anonymous;
}
