package entity;

import java.util.Date;

public class Reports {

    private int reportID;
    private int reportingOfficer;
    private int incidentId;
    private Date reportDate;
    private String reportDetails;
    private String status;

    public Reports(){

    }

    public Reports(int reportID, int reportingOfficer, int incidentId, Date reportDate, String reportDetails, String status) {
        this.reportID = reportID;
        this.reportingOfficer = reportingOfficer;
        this.incidentId = incidentId;
        this.reportDate = reportDate;
        this.reportDetails = reportDetails;
        this.status = status;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public int getReportingOfficer() {
        return reportingOfficer;
    }

    public void setReportingOfficer(int reportingOfficer) {
        this.reportingOfficer = reportingOfficer;
    }

    public int getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reports{" +
                "reportID=" + reportID +
                ", reportingOfficer=" + reportingOfficer +
                ", incidentId=" + incidentId +
                ", reportDate=" + reportDate +
                ", reportDetails='" + reportDetails + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
