package com.proyect.CodeShareSpace.model;

import com.proyect.CodeShareSpace.model.File.FileTask;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User teacher;

    @OneToMany(mappedBy = "task")
    private List<Solution> solutions;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<FileTask> fileTasks;

    public void setFiletasks(List<FileTask> fileTasks){
        this.fileTasks = fileTasks;
        fileTasks.forEach(taskfile -> taskfile.setTask(this));
    }
}
