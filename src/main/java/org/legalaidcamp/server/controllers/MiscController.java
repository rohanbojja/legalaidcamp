package org.legalaidcamp.server.controllers;

import org.legalaidcamp.server.models.FormData;
import org.legalaidcamp.server.repositories.AreaOfLawRepository;
import org.legalaidcamp.server.repositories.BarCouncilRepository;
import org.legalaidcamp.server.repositories.LanguageRepository;
import org.legalaidcamp.server.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
    Data required for the signup forms.
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MiscController {
    @Autowired
    AreaOfLawRepository areaOfLawRepository;

    @Autowired
    BarCouncilRepository barCouncilRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    LanguageRepository languageRepository;

    @GetMapping("/formdata")
    public FormData sendFormData() {
        FormData formData = new FormData();
        try {
            formData.setAreaOfLaws(areaOfLawRepository.findAll());
            formData.setBarCouncils(barCouncilRepository.findAll());
            formData.setLanguages(languageRepository.findAll());
            formData.setStates(stateRepository.findAll());
            return formData;
        } catch (Exception e) {
            throw e;
        }
    }
}
