package tech.nisum.user_managment.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.nisum.user_managment.domain.User;
import tech.nisum.user_managment.persistence.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "phones", source = "userEntity.phonesEntity")
    public User mapUser(UserEntity userEntity);

    @Mapping(target = "phonesEntity", source = "user.phones")
    public UserEntity mapUsuario(User user);
}
