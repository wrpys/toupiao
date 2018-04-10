package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Sqlcon
{
  public static void main(String[] args)
    throws SQLException
  {
    new Sqlcon(); getConnection();
  }

  public static Connection getConnection() throws SQLException
  {
    String url = "jdbc:mysql://localhost:3306/db_toupiao?useUnicode=true&amp;characterEncoding=utf-8";
    String user = "root";
    String password = "";
    Connection conn = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(url, user, password);
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return conn;
  }
}
