package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MobileDatabaseConnection {
    public static List<MobilePhone> getAllRecords(){
        ArrayList<MobilePhone> allPhones = new ArrayList<MobilePhone>();
        try{
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTS.MOBILE_PHONES");
            while (resultSet.next()){
                MobilePhone mobilePhone = new MobilePhone();
                mobilePhone.setId(resultSet.getInt("id"));
                mobilePhone.setName(resultSet.getString("name"));
                mobilePhone.setOs(resultSet.getString("os"));
                mobilePhone.setRam(resultSet.getInt("ram"));
                mobilePhone.setStorage(resultSet.getInt("storage"));
                mobilePhone.setPrice(resultSet.getFloat("price"));
                allPhones.add(mobilePhone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allPhones;
    }
}
