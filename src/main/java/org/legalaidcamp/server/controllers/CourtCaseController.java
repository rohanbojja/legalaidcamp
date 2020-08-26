package org.legalaidcamp.server.controllers;

import org.legalaidcamp.server.models.CourtCase;
import org.legalaidcamp.server.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CourtCaseController {
    @Autowired
    CourtCaseRepository courtCaseRepository;

    @GetMapping
    public ResponseEntity<Iterable<CourtCase>> findAllCourtCases(){
        /*
        TODO: ADMIN ONLY!
         */
        return ResponseEntity.ok().body(courtCaseRepository.findAll());
    }
}
