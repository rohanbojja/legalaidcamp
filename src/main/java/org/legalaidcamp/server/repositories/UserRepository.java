package org.legalaidcamp.server.repositories;

import org.legalaidcamp.server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
