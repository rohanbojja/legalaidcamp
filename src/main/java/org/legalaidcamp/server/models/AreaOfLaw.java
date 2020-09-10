package org.legalaidcamp.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "areasoflaw")
public class AreaOfLaw {
    @Id
    Long id;

    @Column(name = "areaoflaw", unique = true)
    String areaOfLaw;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "areasOfLaw", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    List<Lawyer> lawyers;

    public AreaOfLaw() {
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    public AreaOfLaw(String areaOfLaw) {
        this.areaOfLaw = areaOfLaw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaOfLaw() {
        return areaOfLaw;
    }

    public void setAreaOfLaw(String areaOfLaw) {
        this.areaOfLaw = areaOfLaw;
    }

}
