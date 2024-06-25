package org.example;

import java.sql.*;
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
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allPhones;
    }

    public static int saveRecord(String name, String os, int ram, int storage, float price){
        int result = 0;
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mobile_phones(name, os, ram, storage, price) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, os);
            preparedStatement.setInt(3, ram);
            preparedStatement.setInt(4, storage);
            preparedStatement.setFloat(5, price);
            result = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
