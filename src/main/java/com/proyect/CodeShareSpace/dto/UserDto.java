package com.proyect.CodeShareSpace.dto;

import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String username;
    private String password;
    private String completeName;
    private Rol rol;
    private Set<Course> courses;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        UserDto userDto = (UserDto) object;
        return Objects.equals(userId, userDto.userId) && Objects.equals(username, userDto.username) && Objects.equals(password, userDto.password) && Objects.equals(completeName, userDto.completeName) && rol == userDto.rol && Objects.equals(courses, userDto.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, completeName, rol, courses);
    }

    @Override
    public String toString() {
        return "UserDto{" + "userId=" + userId + ", username='" + username + '\'' + ", password='" + password + '\'' + ", completeName='" + completeName + '\'' + ", rol=" + rol + ", courses=" + courses + '}';
    }
}
