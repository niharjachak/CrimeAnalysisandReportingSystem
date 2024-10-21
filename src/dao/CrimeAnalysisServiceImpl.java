package dao;

import com.mysql.cj.protocol.Resultset;
import entity.Case;
import entity.Incidents;
import entity.Reports;
import util.DataBaseConnection;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrimeAnalysisServiceImpl  implements ICrimeAnalysisServiceInterface{

    Connection connection ;


    @Override
    public boolean createIncident(Incidents newIncidents) {
        try{
            connection= DataBaseConnection.getDBConnection();
            String sql = "INSERT INTO Incidents(IncidentId ,IncidentType,IncidentDate,Location,Description,Status,VictimId,SuspectID,AgencyID) VALUES(?,?,?,?,?,?,?,?,?)";
            try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                pstmt.setInt(1,newIncidents.getIncidentId());
                pstmt.setString(2,newIncidents.getIncidentType());
                pstmt.setDate(3, new java.sql.Date(newIncidents.getIncidentDate().getTime()));
                pstmt.setString(4,newIncidents.getLocation());
                pstmt.setString(5, newIncidents.getDescription());
                pstmt.setString(6, newIncidents.getStatus());
                pstmt.setInt(7,newIncidents.getVictimID());
                pstmt.setInt(8,newIncidents.getSuspectID());
                pstmt.setInt(9,newIncidents.getAgencyId());

                int rowsAffected= pstmt.executeUpdate();

                return rowsAffected>0;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateIncidentStatus(String status, int incidentId) {
        try {
            connection = DataBaseConnection.getDBConnection();
            String sql = "UPDATE Incidents SET Status=  ? WHERE IncidentID= ?";
            try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                pstmt.setString(1,status);
                pstmt.setInt(2,incidentId);

                int rowsAffected = pstmt.executeUpdate();

                return rowsAffected>0;

            }
        }catch (SQLException s){
            s.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Incidents> getincidentsInRange(String startDatestr, String endDatestr) {
        List<Incidents> incidentsList = new ArrayList<>();
        try{
            connection= DataBaseConnection.getDBConnection();
            String sql= "SELECT * FROM Incidents WHERE IncidentDate BETWEEN ? AND ? ";
            try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                Date startdate= new java.sql.Date(dateFormat.parse(startDatestr).getTime());
                Date enddate= new java.sql.Date(dateFormat.parse(endDatestr).getTime());

                pstmt.setDate(1, (java.sql.Date) startdate);
                pstmt.setDate(2, (java.sql.Date) enddate);
            }
        }catch(SQLException | ParseException s){
            s.printStackTrace();
        }finally {
            try{
            if (connection!=null){
                connection.close();
            }
        }catch (SQLException s){
                s.printStackTrace();
            }
        }
        return incidentsList;
    }

    @Override
    public List<Incidents> searchIncidents(String incidentType) {
        List<Incidents> incidentsList = new ArrayList<>();
        String sql = "SELECT * FROM Incidents WHERE IncidentType= ?";
        try {
            connection = DataBaseConnection.getDBConnection();
            try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                pstmt.setString(1,incidentType);

                try(ResultSet rs = pstmt.executeQuery()){
                    while(rs.next()){
                        Incidents incident = new Incidents();

                        incident.setIncidentId(rs.getInt("IncidentID"));
                        incident.setIncidentType(rs.getString("IncidentType"));
                        incident.setIncidentDate(rs.getDate("IncidentDate"));
                        incident.setLocation(rs.getString("Location"));
                        incident.setDescription(rs.getString("Description"));
                        incident.setStatus(rs.getString("Status"));
                        incident.setVictimID(rs.getInt("VicitmId"));
                        incident.setSuspectID(rs.getInt("SuspectID"));
                        incident.setAgencyId(rs.getInt("AgencyID"));

                        incidentsList.add(incident);
                    }

                }
            }
        }catch(SQLException s){
            s.printStackTrace();
        }
        finally {
            try{
                if (connection!=null)
                    connection.close();
            }catch (SQLException s){
                s.printStackTrace();
            }
        }
        return incidentsList;
    }

    @Override
    public Reports generateIncidentReports(Incidents newincidents) {
        return null;
    }

    @Override
    public boolean createCase(Case newCase) {
        boolean success= false;
        try{
            connection = DataBaseConnection.getDBConnection();
            String sql = "INSERT INTO Cases (CaseID, CaseDescription, incidentId) VALUES(?,?,?)";
            try(PreparedStatement pstmt= connection.prepareStatement(sql)){
                pstmt.setInt(1,newCase.getCaseId());
                pstmt.setString(2, newCase.getCaseDescription());
                pstmt.setInt(3,newCase.getIncidentId());

                int affectedRows= pstmt.executeUpdate();
                if (affectedRows>0)
                    success =true;
            }
        }catch(SQLException s){
            s.printStackTrace();
        }finally {
            try{
                if(connection!=null){
                    connection.close();
                }
            }catch (SQLException s){
                s.printStackTrace();
            }
        }

        return success;
    }

    @Override
    public Case getDetails(int caseId) {
        Case caseDetails = null;
        try{
            connection = DataBaseConnection.getDBConnection();
            String sql = "SELECT * FROM Cases WHERE caseID= ?";
            try(PreparedStatement pstmt= connection.prepareStatement(sql)){
                pstmt.setInt(1,caseId);
                try(ResultSet rs = pstmt.executeQuery()){
                    if(rs.next()){
                        caseDetails = new Case();
                        caseDetails.setCaseId(rs.getInt("caseID"));
                        caseDetails.setCaseDescription(rs.getString("caseDescription"));
                    }
                }

            }
        }catch(SQLException s){
            s.printStackTrace();
        }

        return caseDetails;
    }

    @Override
    public boolean updateCaseDetails(Case updateCase) {
        try{
            connection= DataBaseConnection.getDBConnection();
            String sql= "UPDATE Cases SET caseDescription= ?, incidentID= ? WHERE caseID=?";
            try(PreparedStatement pstmt= connection.prepareStatement(sql)){
                pstmt.setString(1,updateCase.getCaseDescription());
                pstmt.setInt(2,updateCase.getIncidentId());
                pstmt.setInt(3,updateCase.getCaseId());

                int rowsAffected = pstmt.executeUpdate();

                return rowsAffected>0;
            }
        }catch(SQLException s){
            s.printStackTrace();
            return false;
        }
        finally{
            try{
                if (connection!=null)
                    connection.close();
            }catch(SQLException s){
                s.printStackTrace();
            }
        }

    }

    @Override
    public List<Case> getAllCases() {

        List<Case> caseList = new ArrayList<>();
        try{
            connection= DataBaseConnection.getDBConnection();
            String sql ="SELECT * FROM Cases";

            try(Statement st = connection.createStatement();
                ResultSet rs= st.executeQuery(sql)){

                while(rs.next()){
                    Case caseobj = new Case();
                    caseobj.setCaseId(rs.getInt("CaseID"));
                    caseobj.setCaseDescription(rs.getString("CaseDescription"));
                    caseobj.setIncidentId(rs.getInt("incidentId"));

                    caseList.add(caseobj);
                }

            }
        }catch(SQLException s){
            s.printStackTrace();
        }finally {
            try{
                if(connection!=null){
                    connection.close();
                }
            }catch (SQLException s){
                s.printStackTrace();
            }
        }

        return caseList;
    }
}