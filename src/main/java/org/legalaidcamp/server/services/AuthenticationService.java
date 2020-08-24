package org.legalaidcamp.server.services;

import java.util.List;

public interface AuthenticationService {

    String getUid(String idToken);
    Boolean isAdmin(String idToken);
    List<String> hasRoles(String idToken);
}
