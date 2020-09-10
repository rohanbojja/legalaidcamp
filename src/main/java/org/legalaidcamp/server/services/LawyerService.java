package org.legalaidcamp.server.services;

import org.legalaidcamp.server.models.CourtCase;
import org.legalaidcamp.server.models.Lawyer;
import org.legalaidcamp.server.models.LawyerData;

import java.util.List;
import java.util.Optional;

public interface LawyerService {
    Optional<Lawyer> createLawyer(String uid, LawyerData lawyerData);
    void toggleVerification(String uid);

    Lawyer deleteLawyer(String uid);

    List<CourtCase> assignedCases(String uid);
}
