package com.proyect.CodeShareSpace.persistence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name")
    private String name;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    @JsonBackReference // evita la recursion infita en el json
    private List<User> users;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    private List<Task> tasks;

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", name='" + name + '\'' + '}';
    }
}
