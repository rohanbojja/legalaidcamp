package org.legalaidcamp.server.models;

import java.util.List;

public class LawyerData {
    List<Long> areasOfLaw;
    Long gender;
    String officeAddress;
    String officePincode;
    Boolean allowCalls;
    Boolean allowVisits;
    Boolean profileStatus;
    List<Long> languages;
    Long stateOfPractice;
    String city;
    Long barCouncil;

    public LawyerData() {
    }

    public LawyerData(List<Long> areasOfLaw, Long gender, String officeAddress, String officePincode, Boolean allowCalls, Boolean allowVisits, Boolean profileStatus, List<Long> languages, Long stateOfPractice, String city, Long barCouncil) {
        this.areasOfLaw = areasOfLaw;
        this.gender = gender;
        this.officeAddress = officeAddress;
        this.officePincode = officePincode;
        this.allowCalls = allowCalls;
        this.allowVisits = allowVisits;
        this.profileStatus = profileStatus;
        this.languages = languages;
        this.stateOfPractice = stateOfPractice;
        this.city = city;
        this.barCouncil = barCouncil;
    }

    public List<Long> getAreasOfLaw() {
        return areasOfLaw;
    }

    public void setAreasOfLaw(List<Long> areasOfLaw) {
        this.areasOfLaw = areasOfLaw;
    }

    public List<Long> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Long> languages) {
        this.languages = languages;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficePincode() {
        return officePincode;
    }

    public void setOfficePincode(String officePincode) {
        this.officePincode = officePincode;
    }

    public Boolean getAllowCalls() {
        return allowCalls;
    }

    public void setAllowCalls(Boolean allowCalls) {
        this.allowCalls = allowCalls;
    }

    public Boolean getAllowVisits() {
        return allowVisits;
    }

    public void setAllowVisits(Boolean allowVisits) {
        this.allowVisits = allowVisits;
    }

    public Boolean getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(Boolean profileStatus) {
        this.profileStatus = profileStatus;
    }


    public Long getStateOfPractice() {
        return stateOfPractice;
    }

    public void setStateOfPractice(Long stateOfPractice) {
        this.stateOfPractice = stateOfPractice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getBarCouncil() {
        return barCouncil;
    }

    public void setBarCouncil(Long barCouncil) {
        this.barCouncil = barCouncil;
    }
}
