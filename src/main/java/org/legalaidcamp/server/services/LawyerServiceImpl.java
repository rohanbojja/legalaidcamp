package org.legalaidcamp.server.services;

import org.legalaidcamp.server.models.*;
import org.legalaidcamp.server.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LawyerServiceImpl implements LawyerService{

    @Autowired
    LawyerRepository lawyerRepository;

    @Autowired
    AreaOfLawRepository areaOfLawRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    BarCouncilRepository barCouncilRepository;

    @Autowired
    StateRepository stateRepository;


    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<Lawyer> createLawyer(String uid, LawyerData lawyerData) {
        /*
        TODO:
        - Validation
         */
        return Optional.ofNullable(userRepository.findById(uid).map(
                value -> {
                    try {

                        Set<AreaOfLaw> areaOfLaws = new HashSet<>(areaOfLawRepository.findAllById(lawyerData.getAreasOfLaw()));
                        Set<Language> languages = new HashSet<>(languageRepository.findAllById(lawyerData.getLanguages()));
                        State state = stateRepository.findById(lawyerData.getStateOfPractice()).orElse(null);
                        BarCouncil barCouncil = barCouncilRepository.findById(lawyerData.getBarCouncil()).orElse(null);
                        Lawyer createdLawyer = new Lawyer(uid, languages, state, lawyerData.getCity(), barCouncil, areaOfLaws,
                                lawyerData.getGender(), lawyerData.getOfficeAddress(), lawyerData.getOfficePincode(), lawyerData.getAllowCalls(),
                                lawyerData.getAllowVisits(), true, false);
                        return lawyerRepository.saveAndFlush(createdLawyer);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }
                }
        ).orElseThrow());
    }

    @Override
    public Lawyer deleteLawyer(String uid) {
        return null;
    }

    @Override
    public List<CourtCase> assignedCases(String uid) {
        return null;
    }
}
