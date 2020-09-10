package org.legalaidcamp.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

//TODO: WIP
@Entity
public class CourtCase {
    //TODO: Tie it up with User
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    User user;

    String description;

    Long areaOfLaw;
    String city;

    Long state;

    Long language;

    Long gender;

    @ManyToOne
    Lawyer activeLawyer;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Lawyer> assignedLawyers;

    public CourtCase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAreaOfLaw() {
        return areaOfLaw;
    }

    public void setAreaOfLaw(Long areaOfLaw) {
        this.areaOfLaw = areaOfLaw;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getLanguage() {
        return language;
    }

    public void setLanguage(Long language) {
        this.language = language;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public Lawyer getActiveLawyer() {
        return activeLawyer;
    }

    public void setActiveLawyer(Lawyer activeLawyer) {
        this.activeLawyer = activeLawyer;
    }

    public List<Lawyer> getAssignedLawyers() {
        return assignedLawyers;
    }

    public void setAssignedLawyers(List<Lawyer> assignedLawyers) {
        this.assignedLawyers = assignedLawyers;
    }
}
