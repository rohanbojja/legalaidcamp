package org.legalaidcamp.server.controllers;

import com.google.type.DateTime;
import org.legalaidcamp.server.models.UserData;
import org.legalaidcamp.server.models.User;
import org.legalaidcamp.server.repositories.UserRepository;
import org.legalaidcamp.server.services.AuthenticationService;
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

    /*
    Todo: Implement auth
     */
    @GetMapping("/users")
    public Iterable<User> listAllUsers(){
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
    @PostMapping(value = "/users", consumes = MediaType.ALL_VALUE )
    public ResponseEntity<User> createUser(@RequestHeader("idToken") String idToken, @RequestBody final UserData userdata){
        String uid = authenticationService.getUid(idToken);
        if(uid.length()>0){
            User user = new User();
            //Validation

            if(userdata.getDisplayName().length()>0 && userdata.getDisplayName().length()<50){
                user.setDisplayName(userdata.getDisplayName());
                user.setEmailAddress(userdata.getEmailAddress());
                user.setPhoneNumber(userdata.getPhoneNumber());
                user.setPhotoUrl(userdata.getPhotoUrl());
                user.setUid(uid);
                user = userRepository.saveAndFlush(user);
                return ResponseEntity.accepted().body(user);
            }
            else{
                return ResponseEntity.unprocessableEntity().build();
            }
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
