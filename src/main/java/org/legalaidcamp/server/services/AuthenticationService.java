package org.legalaidcamp.server.services;

import com.google.firebase.auth.FirebaseAuthException;

import java.util.List;

public interface AuthenticationService {

    String getUid(String idToken) throws FirebaseAuthException;
    Boolean isAdmin(String idToken);
    List<String> hasRoles(String idToken);
}
