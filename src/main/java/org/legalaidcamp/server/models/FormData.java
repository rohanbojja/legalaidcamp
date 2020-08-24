package org.legalaidcamp.server.models;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;

public class FormData {
    public Iterable<AreaOfLaw> areaOfLaws;

    public Iterable<BarCouncil> barCouncils;

    public Iterable<State> states;

    public Iterable<Language> languages;

    public FormData() {
    }

    public Iterable<AreaOfLaw> getAreaOfLaws() {
        return areaOfLaws;
    }

    public void setAreaOfLaws(Iterable<AreaOfLaw> areaOfLaws) {
        this.areaOfLaws = areaOfLaws;
    }

    public Iterable<BarCouncil> getBarCouncils() {
        return barCouncils;
    }

    public void setBarCouncils(Iterable<BarCouncil> barCouncils) {
        this.barCouncils = barCouncils;
    }

    public Iterable<State> getStates() {
        return states;
    }

    public void setStates(Iterable<State> states) {
        this.states = states;
    }

    public Iterable<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Iterable<Language> languages) {
        this.languages = languages;
    }
}
