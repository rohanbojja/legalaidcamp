package org.legalaidcamp.server.controllers;

import org.legalaidcamp.server.models.Lawyer;
import org.legalaidcamp.server.repositories.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//TODO: Impl auth
@RestController
@RequestMapping("/api")
public class LawyerController {

    @Autowired
    LawyerRepository lawyerRepository;

    /*
    TODO:
    1. Create Lawyer object and map it to UID retrieved from the auth_token
    2. Impl auth
    Description:
    1. Create a Lawyer entry if it doesn't already exist for the uid passed
     */
    @PostMapping("/lawyers")
    public Lawyer createLawyer(@RequestBody final Lawyer lawyer) {
        Lawyer createdLawyer = lawyerRepository.saveAndFlush(lawyer);
        return createdLawyer;
    }

    @GetMapping("/lawyers")
    public Iterable<Lawyer> lawyers() {
        //TODO: Check custom claim and allow only if admin
        return lawyerRepository.findAll();
    }

}
