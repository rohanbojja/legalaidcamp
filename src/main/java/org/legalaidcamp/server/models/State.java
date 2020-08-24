package org.legalaidcamp.server.models;

import javax.persistence.*;

@Entity(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "state")
    String stateName;

    @Column(name = "type")
    String type;

    public State() {
    }

    public State(String stateName, String type) {
        this.stateName = stateName;
        this.type = type;
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
