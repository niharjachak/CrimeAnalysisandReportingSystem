package entity;

import java.util.Date;

public class Victims {
    private int victimID;
    private String firstname;
    private String lastName;
    private Date dateofBirth;
    private String gender;
    private String contactInfo;

    public Victims() {
    }

    public Victims(int victimID, String firstname,
                   String lastName, Date dateofBirth,
                   String gender, String contactInfo) {
        this.victimID = victimID;
        this.firstname = firstname;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.contactInfo = contactInfo;
    }

    public int getVictimID() {
        return victimID;
    }

    public void setVictimID(int victimID) {
        this.victimID = victimID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Victims{" +
                "victimID=" + victimID +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateofBirth=" + dateofBirth +
                ", gender='" + gender + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
