package com.proyect.CodeShareSpace.dto.task;

import com.proyect.CodeShareSpace.persistence.model.File.FileTasks;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class TaskDto {
    private Long taskId;
    private String description;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean visible;
    private String courseName;
    private String nameTeacher;
    private List<FileTasksDto> fileTasks;
}
