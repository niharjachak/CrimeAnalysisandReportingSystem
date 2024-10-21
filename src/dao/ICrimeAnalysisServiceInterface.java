package dao;

import entity.Case;
import entity.Incidents;
import entity.Reports;

import java.util.Collection;
import java.util.Date;
import java.util.List;

interface ICrimeAnalysisServiceInterface {

    public boolean createIncident(Incidents  newIncidents);

    public boolean updateIncidentStatus(String status ,int incidentId);

    public List<Incidents> getincidentsInRange(String startdate,String endDate);

    public List<Incidents> searchIncidents(String incidentType);

    public Reports generateIncidentReports (Incidents newincidents);

    public boolean createCase( Case newCase );

    public Case getDetails(int caseId);

    public boolean updateCaseDetails(Case updateCase);

    public List<Case> getAllCases();




}
