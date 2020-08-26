package org.legalaidcamp.server.models;

public class CourtCaseData {
    String description;

    Long areaOfLaw;

    String city;

    Long state;

    Long language;

    Long gender;

    String uid;

    public CourtCaseData() {
    }

    public CourtCaseData(String description, Long areaOfLaw, String city, Long state, Long language, Long gender, String uid) {
        this.description = description;
        this.areaOfLaw = areaOfLaw;
        this.city = city;
        this.state = state;
        this.language = language;
        this.gender = gender;
        this.uid = uid;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
