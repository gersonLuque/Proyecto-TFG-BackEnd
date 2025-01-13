package com.proyect.CodeShareSpace;

import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.dto.SolutionDto;
import com.proyect.CodeShareSpace.dto.TaskDto;
import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import com.proyect.CodeShareSpace.persistence.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataProvider {
    // Crea un Curso como plantilla
    public static Course newCourseMock(){
        Course course = new Course();
        course.setCourseId(1L);
        course.setName("Programación");
        course.setUsers(new HashSet<>());
        return course;
    }
    // Crea un CursoDTO como plantilla
    public static CourseDto newCourseDTOMock(){
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(8L);
        courseDto.setName("Matemáticas");
        return courseDto;
    }
    // Crea un Usuario como plantilla
    public static User newUserMock(){
        User user = new User();
        user.setUserId(2L);
        user.setUsername("kobeLAbryant");
        user.setPassword("mamba");
        user.setCompleteName("Kobe Bryant");
        user.setRol(Rol.TEACHER);
        user.setCourses(new HashSet<>());
        return user;
    }
    // Crea un UsuarioDTO como plantilla
    public static UserDto newUserDtoMock(){
        UserDto userDto = new UserDto();
        userDto.setUserId(5L);
        userDto.setUsername("antonioMayorista");
        userDto.setPassword("noLimpioPescado");
        userDto.setCompleteName("Antonio Recio");
        userDto.setRol(Rol.STUDENT);
        userDto.setCourses(new HashSet<>());
        return userDto;
    }
    // Crea una lista de UsuariosDTO como plantilla
    public static List<UserDto> newUsersDtoListMock(){
        UserDto user1 = new UserDto();
        user1.setUsername("alfredoRomeroma12");
        UserDto user2 = new UserDto();
        user2.setUsername("carlomagno");
        UserDto user3 = new UserDto();
        user3.setUsername("pokerStars");
        UserDto user4 = new UserDto();
        user4.setUsername("conchitaVelazquez");
        UserDto user5 = new UserDto();
        user5.setUsername("kity");
        user5.setUserId(7L);
        return List.of(user1, user2, user3, user4, user5);
    }
    // Crea una lista de UsuariosDTO como plantilla
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
    // Crea una lista de UsuariosDTO buscados por un ID de Curso como plantilla
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

    // Crea una lista de CursosDTO como plantilla
    public static List<CourseDto> newCoursesDTOListMock() {
        CourseDto courseDto1 = new CourseDto(); courseDto1.setCourseId(1L); courseDto1.setName("Programación");
        CourseDto courseDto2 = new CourseDto(); courseDto2.setCourseId(2L); courseDto2.setName("Procesos y Servicios");
        CourseDto courseDto3 = new CourseDto(); courseDto3.setCourseId(3L); courseDto3.setName("Inglés");
        return List.of(courseDto1, courseDto2, courseDto3);
    }
    // Crea una lista de Cursos como plantilla
    private static Set<Course> newCoursesSet(){
        Course course1 = new Course(); course1.setName("SSII");
        Course course2 = new Course(); course2.setName("Programación");
        Course course3 = new Course(); course3.setName("Acceso a Datos");
        Course course4 = new Course(); course4.setName("Inglés");
        Course course5 = new Course(); course5.setName("Servicios y Procesos");
        return Set.of(course1, course2, course3, course4, course5);
    }

    public static List<TaskDto> newTaskDtoListMock() {
        TaskDto task1 = new TaskDto(); task1.setTaskId(1L); task1.setDescription("Conditionals exam");
        TaskDto task2 = new TaskDto(); task2.setTaskId(2L); task2.setDescription("Complete the course syllabus");
        TaskDto task3 = new TaskDto(); task3.setTaskId(3L); task3.setDescription("Fix bugs in user interface");
        TaskDto task4 = new TaskDto(); task4.setTaskId(4L); task4.setDescription("Write unit tests for methods");
        return List.of(task1, task2, task3, task4);
    }

    public static TaskDto newTaskDtoMock(){
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(5L);
        taskDto.setDescription("File handling and JDBC");
        taskDto.setCourseName("Data Access");
        taskDto.setNameTeacher("Jose Sala Gutierrez");
        return taskDto;
    }

    public static List<SolutionDto> newSolutionDtoListMock(){
        SolutionDto solutionDto1 = new SolutionDto(); solutionDto1.setSolutionId(1L); solutionDto1.setAnonymous(true);
        SolutionDto solutionDto2 = new SolutionDto(); solutionDto2.setSolutionId(2L); solutionDto2.setAnonymous(false);
        SolutionDto solutionDto3 = new SolutionDto(); solutionDto3.setSolutionId(3L); solutionDto3.setAnonymous(false);
        return List.of(solutionDto1, solutionDto2, solutionDto3);
    }

}