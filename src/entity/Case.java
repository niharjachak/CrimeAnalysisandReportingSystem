package entity;

public class Case {
    private int caseId;
    private String caseDescription;
    private int incidentId;

    public Case() {
    }

    public Case(int caseId, String caseDescription, int incidentId) {
        this.caseId = caseId;
        this.caseDescription = caseDescription;
        this.incidentId = incidentId;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public int getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseId=" + caseId +
                ", caseDescription='" + caseDescription + '\'' +
                ", incidentId=" + incidentId +
                '}';
    }
}
