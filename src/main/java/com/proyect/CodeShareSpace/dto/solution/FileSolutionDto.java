package com.proyect.CodeShareSpace.dto.solution;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FileSolutionDto {
    private Long fileId;
    private String fileName;
    private String prefix;
    private String type;
    private Long KBytes;
    private Long solutionId;
    private String content;
}
