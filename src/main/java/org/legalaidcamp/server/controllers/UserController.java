package org.legalaidcamp.server.controllers;

import com.google.firebase.auth.FirebaseAuthException;
import org.legalaidcamp.server.models.User;
import org.legalaidcamp.server.models.UserData;
import org.legalaidcamp.server.repositories.UserRepository;
import org.legalaidcamp.server.services.AuthenticationService;
import org.legalaidcamp.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    /*
    Todo: Implement auth
     */
    @GetMapping("/users")
    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }

    /*
    Todo:
    1. Implement auth
    2. Implement validation for strings
    3. Auditing stuff

    Description:
    1. JWT token -> Firebase uid.
    2. Create a user if new uid received
     */
    @PostMapping(value = "/users", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<User> createUser(@RequestHeader("idToken") String idToken, @RequestBody final UserData userdata) {
        try {
            String uid = authenticationService.getUid(idToken);
            User user = userService.createUser(uid, userdata);
            return ResponseEntity.ok().body(user);
        } catch (FirebaseAuthException | IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
