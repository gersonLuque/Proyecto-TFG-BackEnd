package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import com.proyect.CodeShareSpace.dto.task.CreateTaskDto;
import com.proyect.CodeShareSpace.dto.task.TaskDto;
import com.proyect.CodeShareSpace.dto.task.UpdateTaskDto;
import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import com.proyect.CodeShareSpace.service.interfaces.ISolutionService;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    @Autowired
    private ITaskService iTaskService;

    @Autowired
    private ISolutionService iSolutionService;

    @Autowired
    private IS3Service is3Service;


    @Operation(
            summary = "Obtener tarea por ID",
            description = "Obtiene los detalles de una tarea según el ID proporcionado **Roles requeridos: TEACHER,STUDENT",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping("{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId){
        return new ResponseEntity<>(iTaskService.findById(taskId), HttpStatus.OK);
    }

    @Operation(
            summary = "Obtener soluciones por ID de tarea",
            description = "Obtiene todas las soluciones asociadas a una tarea mediante el ID de la tarea proporcionado. **Roles requeridos: TEACHER,STUDENT**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping("{taskId}/solutions")
    public ResponseEntity<List<SolutionDto>> getSolutionsByTaskId(@PathVariable Long taskId){
        return new ResponseEntity<>(iSolutionService.getSolutionsByTaskId(taskId),HttpStatus.OK);
    }

    @Operation(
            summary = "Obtener solución por tarea y usuario",
            description = "Obtiene la solución asociada a una tarea y un usuario específicos mediante sus IDs. **Roles requeridos: TEACHER, STUDENT. El profesor puede acceder a cualquier tarea, pero el estudiante solo puede acceder a su propia solución.**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PreAuthorize("#userId == principal.userId or hasRole('TEACHER')")
    @GetMapping("{taskId}/solutions/{userId}")
    public ResponseEntity<SolutionDto> getSolutionByUserAndTask(@PathVariable Long taskId, @PathVariable Long userId){
        return ResponseEntity.ok(iSolutionService.getSolutionByUserAndTask(taskId,userId));
    }

    @Operation(
            summary = "Crear una nueva tarea",
            description = "Crea una nueva tarea utilizando los datos proporcionados en el objeto **CreateTaskDto**. **Roles requeridos: TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@ModelAttribute CreateTaskDto createTaskDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iTaskService.createTask(createTaskDto));
    }

    @Operation(
            summary = "Actualizar una tarea existente",
            description = "Actualiza los detalles de una tarea existente utilizando los datos proporcionados en el objeto **UpdateTaskDto**. **Roles requeridos: TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PutMapping
    public ResponseEntity<TaskDto> updateTask(@ModelAttribute UpdateTaskDto updateTaskDto){
        return ResponseEntity.ok(iTaskService.updateTask(updateTaskDto));
    }

    @Operation(
            summary = "Eliminar una tarea por ID",
            description = "Elimina una tarea específica identificada por su **ID**. **Roles requeridos: TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @DeleteMapping("{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId){
        iTaskService.deleteById(taskId);
        return ResponseEntity.noContent().build();
    }
}
