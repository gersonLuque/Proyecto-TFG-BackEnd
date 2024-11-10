package com.proyect.CodeShareSpace.persistence.model;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "solutions")
@NoArgsConstructor
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

    @Column(name = "file_path")
    private String filePath;

    private boolean star;
    private boolean anonymous;

}
