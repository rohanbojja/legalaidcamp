package org.legalaidcamp.server.services;

import org.legalaidcamp.server.models.*;
import org.legalaidcamp.server.repositories.AreaOfLawRepository;
import org.legalaidcamp.server.repositories.LanguageRepository;
import org.legalaidcamp.server.repositories.LawyerRepository;
import org.legalaidcamp.server.repositories.UserRepository;
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
    UserRepository userRepository;

    @Override
    public Optional<Lawyer> createLawyer(String uid, LawyerData lawyerData) {
        return Optional.ofNullable(userRepository.findById(uid).map(
                value -> {
                    try {

                        List<AreaOfLaw> areaOfLaws = areaOfLawRepository.findAllById(lawyerData.getAreasOfLaw());
                        List<Language> languages = languageRepository.findAllById(lawyerData.getLanguages());
                        Set<Language> languageSet = new HashSet<Language>(languages);
                        Lawyer createdLawyer = new Lawyer(uid, languageSet, lawyerData.getStateOfPractice(), lawyerData.getCity(), lawyerData.getBarCouncil(), areaOfLaws,
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
