package com.proyect.CodeShareSpace.persistence.model;


import com.proyect.CodeShareSpace.persistence.model.File.FileSolutions;
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

    @Column(name = "file_path")
    private String filePath;

    private boolean star;
    private boolean anonymous;

    @OneToMany(mappedBy = "solution")
    private List<FileSolutions> fileSolutions;

}



