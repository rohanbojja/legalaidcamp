package org.legalaidcamp.server.controllers;

import org.legalaidcamp.server.models.CourtCase;
import org.legalaidcamp.server.models.Lawyer;
import org.legalaidcamp.server.models.User;
import org.legalaidcamp.server.repositories.CourtCaseRepository;
import org.legalaidcamp.server.repositories.LawyerRepository;
import org.legalaidcamp.server.repositories.UserRepository;
import org.legalaidcamp.server.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

 /*
        TODO:
        -> Enable paging!
        -> Remove mock auth and claims
*/

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    CourtCaseRepository courtCaseRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    LawyerRepository lawyerRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/cases")
    ResponseEntity<Iterable<CourtCase>> listCourtCases(@RequestHeader("idToken") String idToken) {

        if (authenticationService.isAdmin(idToken)) {
            return ResponseEntity.ok().body(courtCaseRepository.findAll());
        } else {
            return ResponseEntity.status(501).build();
        }
    }

    @GetMapping("/lawyers")
    ResponseEntity<Iterable<Lawyer>> listLawyers(@RequestHeader("idToken") String idToken) {
        if (authenticationService.isAdmin(idToken)) {
            return ResponseEntity.ok().body(lawyerRepository.findAll());
        } else {
            return ResponseEntity.status(501).build();
        }
    }

    /*
    TODO: WIP
     */
    @GetMapping("/lawyer/{lUID}")
    ResponseEntity<Lawyer> getLawyerProfile(@RequestHeader("idToken") String idToken, @PathVariable final String lUID) {
        if (authenticationService.isAdmin(idToken)) {
            return ResponseEntity.ok().body(lawyerRepository.findById(lUID).orElseThrow());
        } else {
            return ResponseEntity.status(501).build();
        }
    }

    /*TODO:
    -> Too much power?
     */
    @PostMapping("/lawyer/{lUID}/verify")
    ResponseEntity verifyLawyer(@RequestHeader("idToken") String idToken, @PathVariable final String lUID) {
        if (authenticationService.isAdmin(idToken)) {
            return lawyerRepository.findById(lUID).map(
                    value -> {
                        value.setVerified(true);
                        lawyerRepository.saveAndFlush(value);
                        return ResponseEntity.ok().body("Verified");
                    }).orElse(ResponseEntity.notFound().build());

        } else {
            return ResponseEntity.status(501).build();
        }
    }

    @PostMapping("/lawyer/{lUID}/suspend")
    ResponseEntity suspendLawyer(@RequestHeader("idToken") String idToken, @PathVariable final String lUID) {
        if (authenticationService.isAdmin(idToken)) {
            return lawyerRepository.findById(lUID).map(
                    value -> {
                        value.setVerified(false);
                        lawyerRepository.saveAndFlush(value);
                        return ResponseEntity.ok().body("Suspended");
                    }).orElse(ResponseEntity.notFound().build());
        } else {
            return ResponseEntity.status(501).build();
        }
    }

    @GetMapping("/users")
    ResponseEntity<Iterable<User>> listUsers(@RequestHeader("idToken") String idToken) {
        if (authenticationService.isAdmin(idToken)) {
            return ResponseEntity.ok().body(userRepository.findAll());
        } else {
            return ResponseEntity.status(501).build();
        }
    }
}
