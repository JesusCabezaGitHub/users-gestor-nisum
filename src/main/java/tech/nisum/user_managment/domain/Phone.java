package tech.nisum.user_managment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
public class Phone {

    @NonNull
    private String number;
    @NonNull
    private String citycode;
    @NonNull
    private String contrycode;
}
