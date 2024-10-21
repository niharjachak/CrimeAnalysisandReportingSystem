package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    public  static String getPropertyString(String propertyFilePath){
        Properties properties = new Properties();

        try(FileInputStream input = new FileInputStream(propertyFilePath)){
            properties.load(input);
        }catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        String hostname= properties.getProperty("hostname");
        String dbname= properties.getProperty("dbname");
        String username= properties.getProperty("username");
        String password= properties.getProperty("password");
        String port= properties.getProperty("port");
        if (hostname == null || dbname == null || username == null || password == null || port == null) {
            throw new IllegalArgumentException("Missing required connection properties");
        }

        return "jdbc:mysql://"+hostname+":"+port+"/"+dbname+"?user="+ username + "&password="+password;
        }


}
