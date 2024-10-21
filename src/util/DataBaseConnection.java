package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {
    private static Connection conn = null;

    public static Connection getDBConnection() {

        if (conn == null) {

            try {
                String propertyFilePath = "src/resources/DB.properties";

                String connectionString = PropertyUtil.getPropertyString(propertyFilePath);
                System.out.println("Connection String: "+connectionString);

                conn = DriverManager.getConnection(connectionString);
                System.out.println("Connection established Succesfully! ");

            } catch (SQLException s) {
                s.printStackTrace();
                System.out.println("Failed to establish Connection.");
            }
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection con = DataBaseConnection.getDBConnection();
        if(con!= null ){
            System.out.println("Database connection succesful");
        }
        else{
            System.out.println("Unsuccesful database connection");
        }
    }
}