package com.proyect.CodeShareSpace;

import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import com.proyect.CodeShareSpace.persistence.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataProvider {

    //Método para crear un curso de prueba
    public static Course newCourseMock(){
        Course course = new Course();
        course.setCourseId(3L);
        course.setName("Programación");
        return course;
    }

    public static CourseDto newCourseDTOMock(){
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(1L);
        courseDto.setName("Matemáticas");
        return courseDto;
    }

    public static User newUserMock(){
        User user = new User();
        user.setUserId(1L);
        user.setUsername("anaFrank08");
        user.setPassword("cacahuete");
        user.setCompleteName("Ana Cisneros");
        user.setRol(Rol.TEACHER);
        user.setCourses(new HashSet<>());
        return user;
    }

    public static UserDto newUserDtoMock(){
        UserDto userDto = new UserDto();
        userDto.setUserId(1L);
        userDto.setUsername("anaFrank08");
        userDto.setPassword("cacahuete");
        userDto.setCompleteName("Ana Cisneros");
        userDto.setRol(Rol.TEACHER);
        userDto.setCourses(new HashSet<>());
        return userDto;
    }

    public static List<UserDto> newUsersDtoListMock(){
        UserDto user1 = new UserDto();
        user1.setUsername("alfredoRomeroma12");
        UserDto user2 = new UserDto();
        user2.setUsername("carlomagno");
        UserDto user3 = new UserDto();
        user3.setUsername("asd12");
        UserDto user4 = new UserDto();
        user4.setUsername("ffff");
        UserDto user5 = new UserDto();
        user5.setUsername("endend");
        return List.of(user1, user2, user3, user4, user5);
    }

    public static List<UserDto> usersToSearchMock(){

        UserDto UserDto1 = new UserDto();
        UserDto1.setUserId(1L);
        UserDto1.setUsername("cristianoRonaldo7");
        UserDto1.setPassword("bicho007");
        UserDto1.setRol(Rol.STUDENT);

        UserDto UserDto2 = new UserDto();
        UserDto2.setUserId(2L);
        UserDto2.setUsername("frankSinatra");
        UserDto2.setPassword("borabora");
        UserDto2.setRol(Rol.TEACHER);

        return List.of(UserDto1, UserDto2);
    }

    public static List<UserDto> usersToSearchMockByCourseId(Long id){

        UserDto UserDto1 = new UserDto();
        UserDto1.setUserId(1L);
        UserDto1.setUsername("cristianoRonaldo7");
        UserDto1.setPassword("bicho007");
        UserDto1.setRol(Rol.STUDENT);

        UserDto UserDto2 = new UserDto();
        UserDto2.setUserId(2L);
        UserDto2.setUsername("frankSinatra");
        UserDto2.setPassword("borabora");
        UserDto2.setRol(Rol.TEACHER);

        return List.of(UserDto1, UserDto2);
    }

    private static Set<Course> newCoursesSet(){
        Course course1 = new Course(); course1.setName("SSII");
        Course course2 = new Course(); course2.setName("Programación");
        Course course3 = new Course(); course3.setName("Acceso a Datos");
        Course course4 = new Course(); course4.setName("Inglés");
        Course course5 = new Course(); course5.setName("Servicios y Procesos");
        return Set.of(course1, course2, course3, course4, course5);
    }
}