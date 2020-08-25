package org.legalaidcamp.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "state", unique = true)
    String stateName;

    @Column(name = "type")
    String type;

    @JsonIgnore
    @OneToMany(mappedBy = "stateOfPractice")
    Set<Lawyer> lawyers;

    public State() {
    }

    public State(String stateName, String type) {
        this.stateName = stateName;
        this.type = type;
    }

    public Set<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(Set<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
