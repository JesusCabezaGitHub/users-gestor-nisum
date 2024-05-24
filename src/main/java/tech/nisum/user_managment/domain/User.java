package tech.nisum.user_managment.domain;

import lombok.NonNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
public class User {

    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private List<Phone> phones;
}
