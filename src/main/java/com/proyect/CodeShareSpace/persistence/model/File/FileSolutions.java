package com.proyect.CodeShareSpace.persistence.model.File;

import com.proyect.CodeShareSpace.persistence.model.Solution;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "files_solutions")
public class FileSolutions extends FileBase {

    @ManyToOne
    @JoinColumn(name = "solution_id")
    private Solution solution;
}
