package com.proyect.CodeShareSpace.model.File;

import com.proyect.CodeShareSpace.model.Solution;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "files_solutions")
public class FileSolution extends FileBase {

    @ManyToOne
    @JoinColumn(name = "solution_id")
    private Solution solution;

    public FileSolution(MultipartFile file){
        setFileName(file.getOriginalFilename());
        setType(extractExtension(file.getOriginalFilename()));
        setKBytes(file.getSize());
    }
}

