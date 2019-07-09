package net.centricdata.agricura.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class SalesTeam {


    @Id(autoincrement = true)
    Long salesID;

    public  String salesPerson;
    public String salesPersonTel;
    public String salesBranch;
    public String salesContact;
    public String salesEmail;


    @Generated(hash = 934070522)
    public SalesTeam(Long salesID, String salesPerson, String salesPersonTel, String salesBranch, String salesContact, String salesEmail) {
        this.salesID = salesID;
        this.salesPerson = salesPerson;
        this.salesPersonTel = salesPersonTel;
        this.salesBranch = salesBranch;
        this.salesContact = salesContact;
        this.salesEmail = salesEmail;
    }

    public SalesTeam() {
    }

    public Long getSalesID() {
        return salesID;
    }

    public void setSalesID(Long salesID) {
        this.salesID = salesID;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }

    public String getSalesPersonTel() {
        return salesPersonTel;
    }

    public void setSalesPersonTel(String salesPersonTel) {
        this.salesPersonTel = salesPersonTel;
    }

    public String getSalesBranch() {
        return salesBranch;
    }

    public void setSalesBranch(String salesBranch) {
        this.salesBranch = salesBranch;
    }

    public String getSalesContact() {
        return salesContact;
    }

    public void setSalesContact(String salesContact) {
        this.salesContact = salesContact;
    }

    public String getSalesEmail() {
        return salesEmail;
    }

    public void setSalesEmail(String salesEmail) {
        this.salesEmail = salesEmail;
    }
}
