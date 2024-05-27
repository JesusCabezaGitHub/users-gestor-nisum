package tech.nisum.user_managment.services;

import org.springframework.stereotype.Service;
import tech.nisum.user_managment.domain.User;
import tech.nisum.user_managment.exceptions.EmailAlreadyExistException;
import tech.nisum.user_managment.mappers.UserMapper;
import tech.nisum.user_managment.persistence.entity.UserEntity;
import tech.nisum.user_managment.persistence.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Optional<User> getUserByEmail(String email) {
        return this.userRepository.findByEmail(email).map(userEntity -> {
            return userMapper.mapUser(userEntity);
        });
    }

    public List<User> getAllUser(){
        return this.userRepository.findAll().stream().map( userEntity -> {
            return userMapper.mapUser(userEntity);
        }).collect(Collectors.toList()) ;
    }

    public void create(User user) {
        this.getUserByEmail(user.getEmail()).map( userEntity -> {
            throw new EmailAlreadyExistException();
        });
        UserEntity userEntity = userMapper.mapUsuario(user);
        userRepository.save(userEntity);
    }

}
