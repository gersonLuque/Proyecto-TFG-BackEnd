package com.proyect.CodeShareSpace.persistence.model;

import com.proyect.CodeShareSpace.persistence.model.File.FileTasks;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    private String title;

    private String description;
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private boolean visible;

    @Column(name = "file_path")
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @OneToMany(mappedBy = "task")
    private List<Solution> solutions;

    @OneToMany(mappedBy = "task")
    private List<FileTasks> fileTasks;
}
