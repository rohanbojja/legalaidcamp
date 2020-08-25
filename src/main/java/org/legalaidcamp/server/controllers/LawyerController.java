package org.legalaidcamp.server.controllers;

import com.google.firebase.auth.FirebaseAuthException;
import org.legalaidcamp.server.models.Lawyer;
import org.legalaidcamp.server.models.LawyerData;
import org.legalaidcamp.server.repositories.LawyerRepository;
import org.legalaidcamp.server.services.AuthenticationService;
import org.legalaidcamp.server.services.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO: Impl auth
@RestController
@RequestMapping("/api")
public class LawyerController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    LawyerRepository lawyerRepository;

    @Autowired
    LawyerService lawyerService;

    /*
    TODO:
    1. Create Lawyer object and map it to UID retrieved from the auth_token
    2. Impl auth
    Description:
    1. Create a Lawyer entry if it doesn't already exist for the uid passed
     */
    @PostMapping("/lawyers")
    public ResponseEntity<Lawyer> createLawyer(@RequestHeader("idToken") String idToken, @RequestBody final LawyerData lawyerData) throws FirebaseAuthException {

        try {
            String uid = authenticationService.getUid(idToken);
            return lawyerService.createLawyer(uid, lawyerData).map(
                    value -> ResponseEntity.ok().body(value)
            ).orElse(ResponseEntity.badRequest().build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/lawyers")
    public Iterable<Lawyer> lawyers() {
        //TODO: Check custom claim and allow only if admin
        return lawyerRepository.findAll();
    }

    @GetMapping("/lawyers/{id}")
    public ResponseEntity<Lawyer> getLawyerProfile(@PathVariable final String uid) {
        /*
        Public page for lawyers
         */
        return lawyerRepository.findById(uid).map(
                value -> ResponseEntity.ok().body(value)
        ).orElse(ResponseEntity.notFound().build());
    }

}
