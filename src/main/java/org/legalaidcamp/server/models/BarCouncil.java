package org.legalaidcamp.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "barcouncils")
public class BarCouncil {
    @Id
    Long id;

    @Column(unique = true, name = "barcouncil")
    String barCouncilName;
    @JsonIgnore
    @OneToMany(mappedBy = "barCouncil", fetch = FetchType.LAZY)
    List<Lawyer> lawyers;


    public BarCouncil() {
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
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
