package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.user.UserCreateDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.dto.user.UserUpdateDto;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @Operation(
            summary = "Obtener todos los usuarios",
            description = "Obtiene una lista de todos los usuarios registrados en el sistema. **Roles requeridos: TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        return new ResponseEntity<>(iUserService.findAll(),HttpStatus.OK);
    }

    @Operation(
            summary = "Obtener un usuario por ID",
            description = "Obtiene los detalles de un usuario según su ID. **Roles requeridos: TEACHER,STUDENT**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping("{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable Long userId){
        return new ResponseEntity<>(iUserService.findById(userId), HttpStatus.OK);
    }

    @Operation(
            summary = "Crear un nuevo usuario",
            description = "Crea un nuevo usuario utilizando los datos proporcionados en el objeto **UserCreateDto**. **Roles requeridos: TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserCreateDto userCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iUserService.createUser(userCreateDto));
    }

    @Operation(
            summary = "Actualizar un usuario por Id",
            description = "Actualiza un usuario utilizando los datos del objeto ** UserDto . Roles requeridos: TEACHER, STUDENT**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserUpdateDto userDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(iUserService.updateUser(userDto));
    }

    @Operation(
            summary = "Eliminar una usuario por ID",
            description = "Elimina un usuario especifico identificado por su **ID**. **Roles requeridos: TEACHER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId){
        iUserService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }
}
