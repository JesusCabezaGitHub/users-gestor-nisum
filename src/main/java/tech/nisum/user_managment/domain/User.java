package tech.nisum.user_managment.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Schema(description = "Entidad principal que contiene la información básica de un usuario")
@Data
public class User {

    @Schema(description = "Nombre del usuario", example = "Jesús")
    @NonNull
    private String name;

    @Schema(description = "Email del usuario. Es el identificador único de cada usuario", example = "jesus@gmail.com")
    @NonNull
    private String email;

    @Schema(description = "Contraseña del usuario", example = "123456****")
    @NonNull
    private String password;

    @Schema(description = "Listado de teléfonos del usuario.", example = "[{'number': '3141122333','citycode': '5','contrycode': '57'}]")
    @NonNull
    private List<Phone> phones;
}