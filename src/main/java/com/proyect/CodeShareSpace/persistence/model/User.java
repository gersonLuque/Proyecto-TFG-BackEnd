package com.proyect.CodeShareSpace.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String username;
    private String password;
    @Column(name = "complete_name")
    private String completeName;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @ManyToMany(mappedBy = "users")
    private Set<Course> courses = new HashSet<>(); // Cursos asociados al usuario


    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        User user = (User) object;
        return Objects.equals(userId, user.userId) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(completeName, user.completeName) && rol == user.rol && Objects.equals(courses, user.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, completeName, rol, courses);
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username='" + username + '\'' + ", password='" + password + '\'' + ", completeName='" + completeName + '\'' + ", rol=" + rol + ", courses=" + courses + '}';
    }
}
