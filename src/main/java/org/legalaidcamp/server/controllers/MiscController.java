package org.legalaidcamp.server.controllers;

import org.legalaidcamp.server.models.*;
import org.legalaidcamp.server.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.Normalizer;

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

    @Autowired
    LawyerRepository lawyerRepository;

    @Autowired
    UserRepository userRepository;

//    @GetMapping("/formdata")
//    public Iterable<AreaOfLaw> listAreasOfLaw() {
//        return areaOfLawRepository.findAll();
//    }

    @GetMapping("/clean")
    public void deleteAllRepos(){
        userRepository.deleteAll();
        lawyerRepository.deleteAll();
    }

    @GetMapping("/formdata")
    public FormData sendFormData(){
        FormData formData = new FormData();
        try{
            formData.setAreaOfLaws(areaOfLawRepository.findAll());
            formData.setBarCouncils(barCouncilRepository.findAll());
            formData.setLanguages(languageRepository.findAll());
            formData.setStates(stateRepository.findAll());
            return formData;
        }catch (Exception e){
            throw e;
        }
    }

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
