package tech.nisum.user_managment.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Schema(description = "Entidad que describe la información que conforma a un teléfono. Cada usuario puede tener un listado de teléfonos")
@Data
public class Phone {

    @NonNull
    @Schema(description = "Número del teléfono", example = "3136548764")
    private String number;

    @Schema(description = "Código de la ciudad", example = "04")
    @NonNull
    private String citycode;

    @Schema(description = "Código del país", example = "57")
    @NonNull
    private String contrycode;
}
