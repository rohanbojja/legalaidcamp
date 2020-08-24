package org.legalaidcamp.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

//TODO: WIP
@Entity(name = "users")
public class User {
    @Id
    String uid;

    String displayName;

    String emailAddress;

    String phoneNumber;

    String photoUrl;

    @JsonIgnore
    @OneToOne(targetEntity = Lawyer.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Lawyer lawyer;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Integer createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private Integer modifiedDate;

    public User() {
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Integer createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Integer modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
