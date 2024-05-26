package tech.nisum.user_managment.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "phone")
public class PhoneEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String number;

    @NotNull
    private String citycode;

    @NotNull
    private String contrycode;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity userEntity;

}
