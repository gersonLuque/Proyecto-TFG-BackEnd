package com.proyect.CodeShareSpace.persistence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name")
    private String name;

    // Relación de muchos a muchos con usuarios (alumnos o profesores)
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "users_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")

    )

    @JsonBackReference // evita la recursion infita en el json
    private Set<User> users = new HashSet<>();
}
