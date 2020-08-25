package org.legalaidcamp.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "languages")
public class Language {
    @Id
    Long id;

    @Column(name = "language", unique = true)
    String languageName;

    @JsonIgnore
    @ManyToMany(mappedBy = "languages", fetch = FetchType.LAZY)
    Set<Lawyer> lawyers;

    public Language() {
    }

    public Set<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(Set<Lawyer> lawyers) {
        this.lawyers = lawyers;
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
