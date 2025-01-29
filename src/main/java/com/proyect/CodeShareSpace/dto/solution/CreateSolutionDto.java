package com.proyect.CodeShareSpace.dto.solution;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateSolutionDto {
    private Long taskId;
    private Long userId;
    private boolean anonymous;
    private List<MultipartFile> files;
}
