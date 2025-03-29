package com.proyect.CodeShareSpace;

import com.proyect.CodeShareSpace.dto.course.CourseDto;
import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import com.proyect.CodeShareSpace.dto.task.CreateTaskDto;
import com.proyect.CodeShareSpace.dto.task.TaskDto;
import com.proyect.CodeShareSpace.dto.user.UserCreateDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.model.*;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    // Crea un Curso como plantilla
    public static Course newCourseMock(){
        Course course = new Course();
        course.setCourseId(1L);
        course.setName("Programación");
        course.setUsers(new ArrayList<>());
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
        user.setCourses(newCoursesSet());
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
        userDto.setCourses(new ArrayList<>());
        return userDto;
    }
    public static List<User> newUsersListMock(){
        User user1 = new User();
        user1.setUsername("casilla");
        User user2 = new User();
        user2.setUsername("ramos");
        User user3 = new User();
        user3.setUsername("dexter");
        User user4 = new User();
        user4.setUsername("marioBros");
        User user5 = new User();
        user5.setUsername("sonic");
        return List.of(user1, user2, user3, user4, user5);
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
    public static Task newTaskMock(){
        Task task = new Task();
        task.setTaskId(3L);
        task.setDescription("Conditional exam");
        task.setVisible(false);

        User teacher = new User();
        teacher.setCompleteName("Antonio Flores");
        task.setTeacher(teacher);

        Course course = new Course();
        course.setName("Física");
        task.setCourse(course);

        return task;
    }
    // Crea un TaskDto como plantilla
    public static TaskDto newTaskDtoMock(){
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(5L);
        taskDto.setDescription("File handling and JDBC");
        taskDto.setCourseName("Data Access");
        taskDto.setNameTeacher("Jose Sala Gutierrez");
        return taskDto;
    }
    // Crea una lista de TaskDto como plantilla
    public static List<TaskDto> newTaskDtoListMock() {
        TaskDto task1 = new TaskDto(); task1.setTaskId(1L); task1.setDescription("Conditionals exam");
        TaskDto task2 = new TaskDto(); task2.setTaskId(2L); task2.setDescription("Complete the course syllabus");
        TaskDto task3 = new TaskDto(); task3.setTaskId(3L); task3.setDescription("Fix bugs in user interface");
        TaskDto task4 = new TaskDto(); task4.setTaskId(4L); task4.setDescription("Write unit tests for methods");
        return List.of(task1, task2, task3, task4);
    }

    public static List<Course> newCoursesListMock(){
        Course course1 = new Course(); course1.setName("SSII");
        Course course2 = new Course(); course2.setName("Programación");
        Course course3 = new Course(); course3.setName("Acceso a Datos");
        Course course4 = new Course(); course4.setName("Inglés");
        Course course5 = new Course(); course5.setName("Servicios y Procesos");
        return List.of(course1, course2, course3, course4, course5);
    }

    public static List<SolutionDto> newSolutionDtoListMock(){
        SolutionDto solutionDto1 = new SolutionDto(); solutionDto1.setSolutionId(1L); solutionDto1.setAnonymous(true);
        SolutionDto solutionDto2 = new SolutionDto(); solutionDto2.setSolutionId(2L); solutionDto2.setAnonymous(false);
        SolutionDto solutionDto3 = new SolutionDto(); solutionDto3.setSolutionId(3L); solutionDto3.setAnonymous(false);
        return List.of(solutionDto1, solutionDto2, solutionDto3);
    }
    // Crea una Solution como plantilla
    public static Solution newSolutionMock(){
        Solution solution = new Solution();
        solution.setSolutionId(2L);
        solution.setAnonymous(false);
        Task task = new Task(); task.setDescription("Write unit tests for methods");
        solution.setTask(task);
        return solution;
    }
    public static SolutionDto newSolutionDtoMock(){
        SolutionDto solutionDto = new SolutionDto();
        solutionDto.setSolutionId(5L);
        solutionDto.setAnonymous(true);
        solutionDto.setTaskId(1L);
        return solutionDto;
    }
    // Crea una lista de Cursos como plantilla
    private static List<Course> newCoursesSet(){
        Course course1 = new Course(); course1.setName("SSII");
        Course course2 = new Course(); course2.setName("Programación");
        Course course3 = new Course(); course3.setName("Acceso a Datos");
        Course course4 = new Course(); course4.setName("Inglés");
        Course course5 = new Course(); course5.setName("Servicios y Procesos");
        return List.of(course1, course2, course3, course4, course5);
    }

    public static UserCreateDto newUserCreateDtoMock() {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setUsername("testUser");
        userCreateDto.setPassword("testPassword");
        userCreateDto.setRol(Rol.STUDENT);
        return userCreateDto;
    }

    public static CreateTaskDto newCreateTaskDto() {
        CreateTaskDto createTaskDto = new CreateTaskDto();
        createTaskDto.setDescription("Example description of create task dto");
        Course course = new Course();
        course.setCourseId(3L);
        createTaskDto.setCourseId(course.getCourseId());
        User teacher = new User();
        teacher.setUserId(14L);
        createTaskDto.setTeacherId(teacher.getUserId());
        return createTaskDto;
    }

    public static List<Task> newTaskListMock() {
        Task task1 = new Task(); task1.setTaskId(1L); task1.setDescription("Simplify code"); task1.setCourse(new Course());
        Task task2 = new Task(); task2.setTaskId(2L); task2.setDescription("Activate coverage");
        Course course = new Course(); course.setName("2ºDAM");
        task2.setCourse(course);
        Task task3 = new Task(); task3.setTaskId(3L); task3.setDescription("Send email");
        return List.of(task1, task2, task3);
    }
}