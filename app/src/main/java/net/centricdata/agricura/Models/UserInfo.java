package net.centricdata.agricura.Models;

import java.util.List;

public class UserInfo {

    private int userId;
    private String fullname;
    private String mobileNumber;
    private String email;
    private List[] cropPreferences;

    public UserInfo() {

    }

    public UserInfo(int userId, String fullname, String mobileNumber, String email, List[] cropPreferences) {
        this.userId = userId;
        this.fullname = fullname;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.cropPreferences = cropPreferences;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List[] getCropPreferences() {
        return cropPreferences;
    }

    public void setCropPreferences(List[] cropPreferences) {
        this.cropPreferences = cropPreferences;
    }
}
