package tech.nisum.user_managment.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.nisum.user_managment.domain.User;
import tech.nisum.user_managment.services.UserService;
import tech.nisum.user_managment.services.UserServiceImpl;

import java.util.List;
import java.net.URI;
import java.util.Optional;

@Tag(name="Api users", description = "Api for users managment")
@RestController
@RequestMapping("/users")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @ApiResponse(responseCode = "200", description = "Success operation")
    @ApiResponse(responseCode = "400", description = "Error in request")
    @ApiResponse(responseCode = "404", description = "Resource not found")
    @Operation(summary = "Get user for email", description = "Get user for valid email. If email don't exist so response with NotFound state")
    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = this.userService.getUserByEmail(email);
        user.map(ResponseEntity::ok);
        return ResponseEntity.notFound().build();
    }

    @ApiResponse(responseCode = "200", description = "Success operation")
    @ApiResponse(responseCode = "400", description = "Error in request")
    @Operation(summary = "Get all user", description = "Get all list user.")
    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = this.userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @ApiResponse(responseCode = "201", description = "Success operation")
    @ApiResponse(responseCode = "400", description = "Error in request")
    @Operation(summary = "Create a user", description = "Create a user through JSON send from client.")
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        this.userService.create(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(user.getEmail())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ApiResponse(responseCode = "200", description = "Success operation")
    @ApiResponse(responseCode = "400", description = "Error in request")
    @ApiResponse(responseCode = "404", description = "Resource not found")
    @Operation(summary = "Update a user", description = "Update a user through JSON send from client.")
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User userBody) {
        for (User user : this.userService.getAllUser()) {
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
