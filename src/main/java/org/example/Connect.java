package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
  private String url = "jdbc:sqlite:C:/Users/User/Desktop/db/employees.db";
  private Connection connection;

  public void connectToDb() throws SQLException {
      connection = DriverManager.getConnection(url);
      System.out.println("Connected to database");
  }

  public void closeConnection() throws SQLException {
      if (connection != null) {
          connection.close();
          System.out.println("Connection closed");
      }
  }

  public Connection getConnection() {
      return connection;
  }



}
