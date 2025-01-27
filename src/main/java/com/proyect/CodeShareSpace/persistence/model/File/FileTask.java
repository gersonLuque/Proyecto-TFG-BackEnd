package com.proyect.CodeShareSpace.persistence.model.File;

import com.proyect.CodeShareSpace.persistence.model.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "files_tasks")
@Getter
@Setter
public class FileTask extends FileBase {

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
