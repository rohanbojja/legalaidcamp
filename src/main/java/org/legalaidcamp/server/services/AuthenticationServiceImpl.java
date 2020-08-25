package org.legalaidcamp.server.services;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.legalaidcamp.server.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    UtilityService utilityService;

    @Override
    public String getUid(String idToken) throws IllegalArgumentException,FirebaseAuthException{
        /*
        TODO: Remove "dev" in production!
         */
        if(idToken.length()<6){
            return idToken;
        }else{
            FirebaseToken decodedToken;
            try {
                decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
                return decodedToken.getUid();
            } catch (FirebaseAuthException | IllegalArgumentException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    @Override
    public Boolean isAdmin(String idToken) {
        FirebaseToken decodedToken;
        try {
            return Boolean.TRUE.equals(FirebaseAuth.getInstance().verifyIdToken(idToken).getClaims().get("admin"));

        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<String> hasRoles(String idToken) {
        return null;
    }

}
