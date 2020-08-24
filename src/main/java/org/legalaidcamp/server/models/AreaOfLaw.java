package org.legalaidcamp.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "areasoflaw")
public class AreaOfLaw {
    @Id
    Long id;
    @Column(name = "areaoflaw", unique = true)
    String areaOfLaw;

    public AreaOfLaw() {
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
