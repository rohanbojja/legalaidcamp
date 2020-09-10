package org.legalaidcamp.server.controllers;

import com.google.firebase.auth.FirebaseAuthException;
import org.legalaidcamp.server.models.CourtCase;
import org.legalaidcamp.server.models.CourtCaseData;
import org.legalaidcamp.server.models.User;
import org.legalaidcamp.server.models.UserData;
import org.legalaidcamp.server.repositories.UserRepository;
import org.legalaidcamp.server.services.AuthenticationService;
import org.legalaidcamp.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
Todo:
1. Implement auth
2. Implement validation for strings
3. Auditing stuff

Description:
1. JWT token -> Firebase uid.
2. Create a user if new uid received
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/users")
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

    /*
    TODO WIP
     */
    @PostMapping(value = "/cases")
    public ResponseEntity<CourtCase> createCase(@RequestHeader("idToken") String idToken, @RequestBody final CourtCaseData courtCaseData) {
        try {
            String uid = authenticationService.getUid(idToken);
            CourtCase courtCase = userService.createCase(uid, courtCaseData);
            return ResponseEntity.ok().body(courtCase);
        } catch (FirebaseAuthException | IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
