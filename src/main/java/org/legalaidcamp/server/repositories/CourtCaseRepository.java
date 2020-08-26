package org.legalaidcamp.server.repositories;

import org.legalaidcamp.server.models.CourtCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtCaseRepository extends JpaRepository<CourtCase, Long> {
}
