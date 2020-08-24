package org.legalaidcamp.server.services;

import org.legalaidcamp.server.models.CourtCase;
import org.legalaidcamp.server.models.Lawyer;
import org.legalaidcamp.server.models.User;
import org.legalaidcamp.server.models.UserData;
import org.legalaidcamp.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public CourtCase createCase(String uid, CourtCase courtCase) {
        return null;
    }

    @Override
    public void deleteCase(String uid, CourtCase courtCase) {

    }

    @Override
    public User createUser(String uid, UserData userData) {
        User user = new User();
        //Validation. Add more cases;

        if(userData.getDisplayName().length()>0 && userData.getDisplayName().length()<50){
            user.setDisplayName(userData.getDisplayName());
            user.setEmailAddress(userData.getEmailAddress());
            user.setPhoneNumber(userData.getPhoneNumber());
            user.setPhotoUrl(userData.getPhotoUrl());
            user.setUid(uid);
            return userRepository.saveAndFlush(user);
        }else{
            return null;
        }
    }

    @Override
    public Lawyer getLawyer(CourtCase courtCase) {
        return null;
    }
}
