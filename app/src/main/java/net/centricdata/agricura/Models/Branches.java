package net.centricdata.agricura.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Branches {

    public Branches() {
    }

    @Id(autoincrement = true)
    public Long branchID;

    public String branchName;
    public String branchAddress;
    public String branchTelephone;
    public String branchContact;



    public double branchLatitude;
    public double branchLongitude;

    @Generated(hash = 1902870025)
    public Branches(Long branchID, String branchName, String branchAddress, String branchTelephone, String branchContact, double branchLatitude, double branchLongitude) {
        this.branchID = branchID;
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.branchTelephone = branchTelephone;
        this.branchContact = branchContact;
        this.branchLatitude = branchLatitude;
        this.branchLongitude = branchLongitude;
    }

    public Long getBranchID() {
        return branchID;
    }

    public void setBranchID(Long branchID) {
        this.branchID = branchID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBranchTelephone() {
        return branchTelephone;
    }

    public void setBranchTelephone(String branchTelephone) {
        this.branchTelephone = branchTelephone;
    }

    public String getBranchContact() {
        return branchContact;
    }

    public void setBranchContact(String branchContact) {
        this.branchContact = branchContact;
    }

    public double getBranchLatitude() {
        return branchLatitude;
    }

    public void setBranchLatitude(double branchLatitude) {
        this.branchLatitude = branchLatitude;
    }

    public double getBranchLongitude() {
        return branchLongitude;
    }

    public void setBranchLongitude(double branchLongitude) {
        this.branchLongitude = branchLongitude;
    }
}
