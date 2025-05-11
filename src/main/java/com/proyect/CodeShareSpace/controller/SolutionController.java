package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.solution.CreateSolutionDto;
import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import com.proyect.CodeShareSpace.dto.solution.UpdateSolutionDto;
import com.proyect.CodeShareSpace.model.Rol;
import com.proyect.CodeShareSpace.service.interfaces.ISolutionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/solutions")
@RequiredArgsConstructor
public class SolutionController {

    private final ISolutionService iSolutionService;


    @GetMapping("{solutionId}")
    public ResponseEntity<SolutionDto> getSolutionById(@PathVariable Long solutionId){
        return ResponseEntity.ok(iSolutionService.getSolutionById(solutionId));
    }

    @Operation(
            summary = "Consigue la información de una solución con el contenido de sus ficheros",
            description = "Información de una solución pasando como parametro un id, los estudiantes no podran ver soluciones ajenas si la tarea aun no ha terminado. **Roles requeridos: STUDENT, TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping("{solutionId}/content")
    public ResponseEntity<SolutionDto>getContentSolution(@PathVariable Long solutionId){
        return ResponseEntity.ok(iSolutionService.getContentS3Solution(solutionId));
    }
    
    @Operation(
            summary = "Crear una nueva solución",
            description = "Crea una nueva solución si el usuario pasado como parametro es el mismo que el usuario autenticado. **Roles requeridos: STUDENT, TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PreAuthorize("#createSolutionDto.userId == principal.userId")
    @PostMapping
    public ResponseEntity<SolutionDto> createSolution(@ModelAttribute CreateSolutionDto createSolutionDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iSolutionService.createSolution(createSolutionDto));
    }


    @Operation(
            summary = "Actualizar una solución existente",
            description = "Actualiza los detalles de una solución existente si esta pertenece al usuario autenticado. **Roles requeridos: STUDENT, TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PreAuthorize("@solutionServiceImpl.getUserIdFromSolution(#updateSolutionDto.solutionId) == principal.userId")
    @PutMapping
    public ResponseEntity<SolutionDto> updateSolution(@ModelAttribute UpdateSolutionDto updateSolutionDto){
        return ResponseEntity.ok(iSolutionService.updateSolution(updateSolutionDto));
    }

    @Operation(
            summary = "Actualizar una solucion agregando una estrella",
            description = "Agrega una estrella a una solucion si tiene el rol adecuado . **Roles requeridos:  TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PreAuthorize("hasRole('TEACHER')")
    @PutMapping("/{solutionId}")
    public ResponseEntity<SolutionDto> updateSolution(@PathVariable Long solutionId, @RequestParam(required = false) Boolean star) {
        return ResponseEntity.ok(iSolutionService.updateStarSolution(solutionId, star));
    }

    @Operation(
            summary = "Eliminar una solución existente",
            description = "Elimina una solución específica identificada por su **ID** siempre y cuando la solucion le pertenezca al usuario autenticado. **Roles requeridos: STUDENT,TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PreAuthorize("@solutionServiceImpl.getUserIdFromSolution(#updateSolutionDto.solutionId) == principal.userId")
    @DeleteMapping("{solutionId}")
    public ResponseEntity<Void> deleteSolution(@PathVariable Long solutionId){
        iSolutionService.deleteSolution(solutionId);
        return ResponseEntity.noContent().build();
    }

}
