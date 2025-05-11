package com.proyect.CodeShareSpace.model;

import com.proyect.CodeShareSpace.model.File.FileTask;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @Column(name = "end_time")
    private LocalTime endTime;

    private boolean visible;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User teacher;

    @OneToMany(mappedBy = "task",cascade = CascadeType.REMOVE)
    private List<Solution> solutions;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<FileTask> fileTasks;

    public void setFiletasks(List<FileTask> fileTasks){
        this.fileTasks = fileTasks;
        fileTasks.forEach(taskfile -> taskfile.setTask(this));
    }

    public boolean isTaskEnded() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate currentDate = now.toLocalDate();
        LocalTime currentTime = now.toLocalTime();

        if (endDate.isBefore(currentDate)) {
            return true;
        }
        if (endDate.isEqual(currentDate) && (endTime.isBefore(currentTime) || endTime.equals(currentTime))) {
            return true;
        }
        return false;
    }


}
