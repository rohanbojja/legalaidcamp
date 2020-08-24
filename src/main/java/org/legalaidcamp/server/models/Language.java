package org.legalaidcamp.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "languages")
public class Language {
    @Id
    Long id;

    @Column(name = "language")
    String languageName;

    public Language() {
    }

    public Language(String languageName) {
        this.languageName = languageName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
