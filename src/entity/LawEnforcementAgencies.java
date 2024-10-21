package entity;

public class LawEnforcementAgencies {
    private int agencyId;
    private String agencyName;
    private String Jurisdiction;
    private String contactInfo;
    private int reportingOfficer;

    public LawEnforcementAgencies(){}

    public LawEnforcementAgencies(int agencyId, String agencyName,
                                  String jurisdiction, String contactInfo,
                                  int reportingOfficer) {
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        Jurisdiction = jurisdiction;
        this.contactInfo = contactInfo;
        this.reportingOfficer = reportingOfficer;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getJurisdiction() {
        return Jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        Jurisdiction = jurisdiction;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getReportingOfficer() {
        return reportingOfficer;
    }

    public void setReportingOfficer(int reportingOfficer) {
        this.reportingOfficer = reportingOfficer;
    }

    @Override
    public String toString() {
        return "LawEnforcementAgencies{" +
                "agencyId=" + agencyId +
                ", agencyName='" + agencyName + '\'' +
                ", Jurisdiction='" + Jurisdiction + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", reportingOfficer=" + reportingOfficer +
                '}';
    }
}
