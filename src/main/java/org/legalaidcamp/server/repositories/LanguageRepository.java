package org.legalaidcamp.server.repositories;

import org.legalaidcamp.server.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
