package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        MysqlDataSource dataSource = null;
        try{
            dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/products");
            dataSource.setUser("root");
            dataSource.setPassword("vicky");
        } catch (Exception e){
            e.printStackTrace();
        }
        return dataSource.getConnection();
    }
}
