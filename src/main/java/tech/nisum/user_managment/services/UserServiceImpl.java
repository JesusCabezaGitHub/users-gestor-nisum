package tech.nisum.user_managment.services;

import org.springframework.stereotype.Service;
import tech.nisum.user_managment.domain.Phone;
import tech.nisum.user_managment.domain.User;
import tech.nisum.user_managment.persistence.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //Banco de datos temporal
    ArrayList<Phone> phonesJesus = new ArrayList<>(
            List.of( new Phone("3137619016", "4", "57"), new Phone("3137612411", "4", "57"))
    );
    ArrayList<Phone> phonesMarcial = new ArrayList<>(
            List.of( new Phone("3141122333", "5", "57"), new Phone("3157610804", "5", "57"))
    );

    ArrayList<User> users = new ArrayList<>(
            List.of(new User("Jesus", "jesus@gmail.com", "123", phonesJesus) ,
                    new User("Marcial", "marcial@gmail.com", "123", phonesMarcial),
                    new User("Damelis", "damelis@gmail.com", "123", phonesJesus),
                    new User("Monica", "monica@gmail.com", "123", phonesJesus),
                    new User("Teresita", "teresita@gmail.com", "123", phonesMarcial))
    );
    //Banco de datos temporal

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return this.users;
        //return this.userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return null;
    }

}
