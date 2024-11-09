package com.proyect.CodeShareSpace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String password;
    @Column(name = "name_complete")
    private String nameComplete;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @ManyToMany(mappedBy = "users")
    private Set<Course> courses = new HashSet<>(); // Cursos asociados al usuario
}
