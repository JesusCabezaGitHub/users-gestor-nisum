package tech.nisum.user_managment.services;

import tech.nisum.user_managment.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAllUser();
    public void create(User user);
    public Optional<User> getUserByEmail(String email);

}
