/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.server;

import java.sql.*;

/**
 *
 * @author Satyam Sharan
 */
public class Database {

    Connection con;
    Statement statement;
    ResultSet resultSet;

    public void startDatabase() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dbshopping";
            con = DriverManager.getConnection(url, "shopping", "Password@99");
            statement = con.createStatement();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        return (resultSet);
    }

    public boolean updateQuery(String query) throws SQLException {
        return (statement.execute(query));

    }

    public void closeDatabase() throws SQLException {
        con.close();
    }
}
