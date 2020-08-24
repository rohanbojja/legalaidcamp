package org.legalaidcamp.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "barcouncils")
public class BarCouncil {
    @Id
    Long id;
    @Column(unique = true, name = "barcouncil")
    String barCouncilName;

    public BarCouncil() {
    }

    public BarCouncil(String barCouncilName) {
        this.barCouncilName = barCouncilName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarCouncilName() {
        return barCouncilName;
    }

    public void setBarCouncilName(String barCouncilName) {
        this.barCouncilName = barCouncilName;
    }
}
