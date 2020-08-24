package org.legalaidcamp.server.services;

import org.legalaidcamp.server.models.CourtCase;
import org.legalaidcamp.server.models.Lawyer;
import org.legalaidcamp.server.models.User;
import org.legalaidcamp.server.models.UserData;

public interface UserService {
    CourtCase createCase(String uid, CourtCase courtCase);
    void deleteCase(String uid, CourtCase courtCase);
    User createUser(String uid,UserData userData);
    Lawyer getLawyer(CourtCase courtCase);
}
