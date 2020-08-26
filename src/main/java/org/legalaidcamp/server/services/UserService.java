package org.legalaidcamp.server.services;

import org.legalaidcamp.server.models.*;

public interface UserService {
    CourtCase createCase(String uid, CourtCaseData courtCaseData);
    void deleteCase(String uid, CourtCase courtCase);
    User createUser(String uid,UserData userData);
    Lawyer getLawyer(CourtCase courtCase);
}
