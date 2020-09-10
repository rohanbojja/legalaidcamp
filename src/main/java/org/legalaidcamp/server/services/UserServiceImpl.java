package org.legalaidcamp.server.services;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.legalaidcamp.server.models.*;
import org.legalaidcamp.server.repositories.CourtCaseRepository;
import org.legalaidcamp.server.repositories.LawyerRepository;
import org.legalaidcamp.server.repositories.StateRepository;
import org.legalaidcamp.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    UserRepository userRepository;

    @Autowired
    LawyerRepository lawyerRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CourtCaseRepository courtCaseRepository;

    public CourtCase createCase(String uid, CourtCaseData courtCaseData) {
        /*
        TODO
        -> Write a better method. This is garbage
         */
        CourtCase courtCase = new CourtCase();
        return userRepository.findById(uid).map(
                value -> {
                    logger.info("Assigned user to the case.");
                    courtCase.setUser(value);
                    stateRepository.findById(courtCaseData.getState()).ifPresentOrElse(
                            state -> {
                                logger.info("Assigning location: " + courtCaseData.getState() + " " + courtCaseData.getCity());
                                Pageable pageable = PageRequest.of(0, 3);
                                Page<Lawyer> lawyerList = lawyerRepository.findByStateOfPractice(state, pageable);
                                courtCase.setAreaOfLaw(courtCaseData.getAreaOfLaw());
                                courtCase.setDescription(courtCaseData.getDescription());
                                courtCase.setCity(courtCaseData.getCity());
                                courtCase.setState(courtCaseData.getState());
                                courtCase.setLanguage(courtCaseData.getLanguage());
                                courtCase.setGender(courtCaseData.getGender());
                                courtCase.setAssignedLawyers(lawyerList.toList());
                            }, () -> {
                    /*
                    TODO
                    No matches found. Logging here.
                     */
                            }
                    );
                    return courtCaseRepository.saveAndFlush(courtCase);
                }
        ).orElseThrow();
    }

    @Override
    public void deleteCase(String uid, CourtCase courtCase) {

    }

    @Override
    public User createUser(String uid, UserData userData) {
        User user = new User();
        //Validation. Add more cases;

        if (userData.getDisplayName().length() > 0 && userData.getDisplayName().length() < 50) {
            user.setDisplayName(userData.getDisplayName());
            user.setEmailAddress(userData.getEmailAddress());
            /*
                TODO:
                Discard the phone number in UserData and retrieve it from Firebase.
                -> Uncomment the code below and get rid of phoneNumber from userData.
             */

            if (uid.length() >= 6) {
                try {
                    user.setPhoneNumber(FirebaseAuth.getInstance().getUser(uid).getPhoneNumber());
                } catch (FirebaseAuthException e) {
                    e.printStackTrace();
                }


            } else {
                user.setPhoneNumber(userData.getPhoneNumber());
            }
            user.setPhotoUrl(userData.getPhotoUrl());
            user.setUid(uid);
            return userRepository.saveAndFlush(user);
        } else {
            return null;
        }
    }

    @Override
    public Lawyer getLawyer(CourtCase courtCase) {
        return null;
    }
}
