package entity;

import java.util.Date;

public class Suspects {
    private int suspectID;

    private String firstName;
    private String lastName;
    private Date dateofBirth;
    private String gender;
    private String contactInfo;

    public Suspects() {
    }

    public int getSuspectID() {
        return suspectID;
    }

    public void setSuspectID(int suspectID) {
        this.suspectID = suspectID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
        return "Suspects{" +
                "suspectID=" + suspectID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateofBirth=" + dateofBirth +
                ", gender='" + gender + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
