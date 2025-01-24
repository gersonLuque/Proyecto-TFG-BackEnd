package com.proyect.CodeShareSpace.persistence.model.File;

import com.proyect.CodeShareSpace.persistence.model.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "files_tasks")
public class FileTasks extends FileBase {

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
