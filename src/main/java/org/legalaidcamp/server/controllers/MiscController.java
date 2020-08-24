package org.legalaidcamp.server.controllers;

import org.legalaidcamp.server.models.AreaOfLaw;
import org.legalaidcamp.server.models.BarCouncil;
import org.legalaidcamp.server.models.Language;
import org.legalaidcamp.server.models.State;
import org.legalaidcamp.server.repositories.AreaOfLawRepository;
import org.legalaidcamp.server.repositories.BarCouncilRepository;
import org.legalaidcamp.server.repositories.LanguageRepository;
import org.legalaidcamp.server.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Formdata,etc
//Auth not required
@RestController
@RequestMapping("/api")
public class MiscController {
    @Autowired
    AreaOfLawRepository areaOfLawRepository;

    @Autowired
    BarCouncilRepository barCouncilRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    LanguageRepository languageRepository;

//    @GetMapping("/formdata")
//    public Iterable<AreaOfLaw> listAreasOfLaw() {
//        return areaOfLawRepository.findAll();
//    }

    @GetMapping("/areasOfLaw")
    public Iterable<AreaOfLaw> listAreasOfLaw() {
        return areaOfLawRepository.findAll();
    }

    @GetMapping("/barCouncils")
    public Iterable<BarCouncil> listBarCouncils() {
        return barCouncilRepository.findAll();
    }

    @GetMapping("/states")
    public Iterable<State> listStates() {
        return stateRepository.findAll();
    }

    @GetMapping("/languages")
    public Iterable<Language> listLanguages() {
        return languageRepository.findAll();
    }
}
