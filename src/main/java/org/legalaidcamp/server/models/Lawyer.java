package org.legalaidcamp.server.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

//TODO: WIP
@Entity
public class Lawyer {
    @Id
    String uid;
    @Column(unique = true, nullable = false)
    @ManyToMany
    Set<Language> languages;
    Long stateOfPractice;
    String city;
    Long barCouncil;
    @Column(unique = true, nullable = false)
    @ManyToMany(targetEntity = AreaOfLaw.class)
    List<AreaOfLaw> areasOfLaw;
    Long gender;
    String officeAddress;
    String officePincode;
    Boolean allowCalls;
    Boolean allowVisits;
    Boolean profileStatus;
    Boolean isVerified;

    @JsonIgnore
    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    User user;

    public Lawyer() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public List<AreaOfLaw> getAreasOfLaw() {
        return areasOfLaw;
    }

    public void setAreasOfLaw(List<AreaOfLaw> areasOfLaw) {
        this.areasOfLaw = areasOfLaw;
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

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
