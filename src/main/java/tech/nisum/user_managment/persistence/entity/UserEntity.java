package tech.nisum.user_managment.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "usuario")
public class UserEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    @NotNull
    private List<PhoneEntity> phonesEntity;
}