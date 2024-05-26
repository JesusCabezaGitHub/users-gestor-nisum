package tech.nisum.user_managment.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import tech.nisum.user_managment.persistence.entity.Usuario;

import java.util.UUID;

public interface UserRepository extends CrudRepository<Usuario, UUID> {
}
