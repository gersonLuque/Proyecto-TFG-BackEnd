package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "coursesName", source = "courses")
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    List<UserDto> usersToUsersDto(List<User> users);

    // Método adicional para convertir lista de Course a lista de String (nombres de curso)
    // Método personalizado para convertir Set<Course> a Set<String> (nombres de cursos)
    default Set<String> mapCoursesToNames(Set<Course> courses) {
        if (courses == null) {
            return null;
        }
        return courses.stream().map(Course::getName)  // Extrae el nombre de cada curso
                .collect(Collectors.toSet());
    }

    // Método personalizado para convertir Set<String> a Set<Course> (de vuelta a objetos Course)
    default Set<Course> mapNamesToCourses(Set<String> courseNames) {
        if (courseNames == null) {
            return null;
        }
        return courseNames.stream().map(name -> {
            Course course = new Course();
            course.setName(name);
            return course;
        }).collect(Collectors.toSet());
    }
}
