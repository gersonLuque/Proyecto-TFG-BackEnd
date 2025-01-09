package com.proyect.CodeShareSpace.dto.user;

import com.proyect.CodeShareSpace.persistence.model.Rol;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserBasicDto {
    private Long userId;
    private String username;
    private String completeName;
    private Rol rol;
}
