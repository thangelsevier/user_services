package com.thangdtran.user_services.domain.model;

public class User {
    private String userName;
    private String userId;
    private String address;
    private String phoneNumber;
    private String gender;

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
