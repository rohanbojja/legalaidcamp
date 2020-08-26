package org.legalaidcamp.server.repositories;

import org.legalaidcamp.server.models.Lawyer;
import org.legalaidcamp.server.models.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawyerRepository extends JpaRepository<Lawyer, String> {

    /*
    TODO: Write better custom query!
     */

    public Page<Lawyer> findByStateOfPractice(State stateOfPractice, Pageable page);
}
