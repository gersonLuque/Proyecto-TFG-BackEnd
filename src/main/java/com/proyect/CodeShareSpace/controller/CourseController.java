package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.course.CourseCreateDto;
import com.proyect.CodeShareSpace.dto.course.CourseDto;
import com.proyect.CodeShareSpace.dto.task.TaskDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.service.interfaces.ICourseService;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @Autowired
    private ITaskService iTaskService;

    @Operation(
            summary = "Obtener todos los cursos",
            description = "Devuelve una lista de todos los cursos disponibles **Roles Requeridos: TEACHER",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        return new ResponseEntity<>(iCourseService.findAll(),HttpStatus.OK);
    }

    @Operation(
            summary = "Obtener usuarios por curso Id",
            description = "Devuelve una lista de usuarios asociados a un curso específico ** Roles requeridos : TEACHER",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping("{courseId}/users")
    public ResponseEntity<List<UserDto>> getUsersByCourse(@PathVariable Long courseId){
        List<UserDto> users = iCourseService.findUsersByCourseId(courseId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
            summary = "Obtener un curso por Id",
            description = "Devuelve los detalles de un curso en especifico ** Roles requeridos : TEACHER,STUDENT",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping("{courseId}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long courseId){
        return new ResponseEntity<>(iCourseService.findById(courseId),HttpStatus.OK);
    }

    @Operation(
            summary = "Obtener una lista de cursos por userId",
            description = "Devuelve los cursos relacionados con el usuario pasado como parametro ** Roles requeridos : TEACHER,STUDENT",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping("user/{userId}")
    public ResponseEntity<List<CourseDto>> getCoursesByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(iCourseService.findByUserId(userId),HttpStatus.OK);
    }

    @Operation(
            summary = "Obtener una lista de tareas por Id de un curso",
            description = "Devuelve las tareas relacionados con el curso pasado como parametro ** Roles requeridos : TEACHER,STUDENT",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping("{courseId}/tasks")
    public ResponseEntity<List<TaskDto>> getTaskByCourseId(@PathVariable Long courseId,@RequestParam Long userId){
        return new ResponseEntity<>(iTaskService.findTasksByCourseId(courseId,userId),HttpStatus.OK);
    }

    @Operation(
            summary = "Crear un curso",
            description = "Crea un curso con los datos pasados como parametro del objeto ** couresCreateDto Roles requeridos : TEACHER,STUDENT",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseCreateDto courseCreateDto,@RequestParam Long userId){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(iCourseService.createCourse(courseCreateDto,userId));
    }

    @Operation(
            summary = "Actualiza un curso",
            description = "Actualizar un curso con los datos pasados como parametro del objeto como parametro ** CourseDto Roles requeridos : TEACHER,STUDENT",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PutMapping
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(iCourseService.updateCourse(courseDto));
    }

    @Operation(
            summary = "Eliminar una curso por ID",
            description = "Elimina un curso especifico identificado por su **ID**. **Roles requeridos: TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @DeleteMapping("{courseId}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long courseId){
        iCourseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }
}
