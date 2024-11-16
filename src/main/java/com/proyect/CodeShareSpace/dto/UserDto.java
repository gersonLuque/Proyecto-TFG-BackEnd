package com.proyect.CodeShareSpace.dto;

import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long userId;
    private String username;
    private String password;
    private String completeName;
    private Rol rol;
    private Set<Course> courses;

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
