package org.legalaidcamp.server.services;

import org.legalaidcamp.server.models.CourtCase;
import org.legalaidcamp.server.models.Lawyer;

public interface UserService {
    CourtCase createCase(CourtCase courtCase);
    void deleteCase(CourtCase courtCase);
    Lawyer getLawyer(CourtCase courtCase);
}
