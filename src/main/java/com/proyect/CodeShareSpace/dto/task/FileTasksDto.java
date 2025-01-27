package com.proyect.CodeShareSpace.dto.task;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FileTasksDto {
    private Long fileId;
    private String fileName;
    private String prefix;
    private String type;
    private Double KBytes;
    private Long taskId;
}
