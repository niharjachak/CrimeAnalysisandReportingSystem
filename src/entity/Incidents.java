package entity;

import java.util.Date;

public class Incidents {
    private int incidentId;
    private String IncidentType;
    private Date IncidentDate;
    private String location;
    private String description;
    private String Status;

    private int agencyId;
    private int suspectID;
    private int victimID;

    public Incidents() {
    }

    public Incidents(int incidentId, String incidentType, Date incidentDate,
                     String location, String description, String status,
                     int agencyId,int suspectID, int victimID) {
        this.incidentId = incidentId;
        IncidentType = incidentType;
        IncidentDate = incidentDate;
        this.location = location;
        this.description = description;
        Status = status;
        this.agencyId = agencyId;
        this.suspectID = suspectID;
        this.victimID = victimID;
    }

    public int getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    public String getIncidentType() {
        return IncidentType;
    }

    public void setIncidentType(String incidentType) {
        IncidentType = incidentType;
    }

    public Date getIncidentDate() {
        return IncidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        IncidentDate = incidentDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public int getSuspectID() {
        return suspectID;
    }

    public void setSuspectID(int suspectID) {
        this.suspectID = suspectID;
    }

    public int getVictimID() {
        return victimID;
    }

    public void setVictimID(int victimID) {
        this.victimID = victimID;
    }

    @Override
    public String toString() {
        return "Incidents{" +
                "incidentId=" + incidentId +
                ", IncidentType='" + IncidentType + '\'' +
                ", IncidentDate=" + IncidentDate +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", Status='" + Status + '\'' +
                ", agencyId=" + agencyId +
                ", suspectID=" + suspectID +
                ", victimID=" + victimID +
                '}';
    }
}
