package org.legalaidcamp.server.repositories;

import org.legalaidcamp.server.models.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

}
