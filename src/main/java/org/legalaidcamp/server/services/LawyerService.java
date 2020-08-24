package org.legalaidcamp.server.services;

import org.legalaidcamp.server.models.CourtCase;
import org.legalaidcamp.server.models.Lawyer;

import java.util.List;

public interface LawyerService {
    Lawyer createLawyer(Lawyer lawyer);
    Lawyer deleteLawyer(String uid);
    List<CourtCase> assignedCases(String uid);
}
