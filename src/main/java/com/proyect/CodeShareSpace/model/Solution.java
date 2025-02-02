package com.proyect.CodeShareSpace.model;


import com.proyect.CodeShareSpace.model.File.FileSolution;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "solutions")
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solution_id")
    private Long solutionId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    private boolean star;
    private boolean anonymous;

    @OneToMany(mappedBy = "solution",cascade = CascadeType.ALL)
    private List<FileSolution> fileSolutions;

    public void setFileSolutions(List<FileSolution> fileSolutions) {
        this.fileSolutions = fileSolutions;
        fileSolutions.forEach(file -> file.setSolution(this));
    }
}



