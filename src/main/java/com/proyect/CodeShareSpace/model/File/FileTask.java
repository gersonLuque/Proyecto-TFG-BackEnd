package com.proyect.CodeShareSpace.model.File;

import com.proyect.CodeShareSpace.model.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "files_tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileTask extends FileBase {

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public FileTask(MultipartFile file){
        setFileName(file.getOriginalFilename());
        setType(extractExtension(file.getOriginalFilename()));
        setKBytes(file.getSize());
    }

}
