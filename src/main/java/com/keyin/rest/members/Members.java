package com.keyin.rest.members;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Members {
    @Id
    @SequenceGenerator(name = "members_sequence", sequenceName = "members_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "members_sequence")
    private long id;
    private String memberName;
    private String memberAddress;
    private String memberEmail;
    private String memberPhoneNumber;
    private String memberStartDate;
    private String membershipDuration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPhoneNumber() {
        return memberPhoneNumber;
    }

    public void setMemberPhoneNumber(String memberPhoneNumber) {
        this.memberPhoneNumber = memberPhoneNumber;
    }

    public String getMemberStartDate() {
        return memberStartDate;
    }

    public void setMemberStartDate(String memberStartDate) {
        this.memberStartDate = memberStartDate;
    }

    public String getMembershipDuration() {
        return membershipDuration;
    }

    public void setMembershipDuration(String membershipDuration) {
        this.membershipDuration = membershipDuration;
    }
}
