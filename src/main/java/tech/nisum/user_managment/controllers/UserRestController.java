package tech.nisum.user_managment.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.nisum.user_managment.domain.Phone;
import tech.nisum.user_managment.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserRestController {

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

    public User getUserByEmail(String email) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(this.users);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        this.users.add(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(user.getEmail())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User userBody) {
        for (User user : this.users) {
            if(user.getEmail().equals(userBody.getEmail())) {
                user.setName(userBody.getName());
                user.setPassword(userBody.getPassword());
                user.setPhones(userBody.getPhones());
                return ResponseEntity.ok(user);
            }
        }
        return  ResponseEntity.notFound().build();
    }
}
