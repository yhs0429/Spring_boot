package com.styud.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOpen {

  private static final String URL = null;
  private static Connection con;
  
  public static Connection getConnection() {
    
    try {
      Class.forName(Constant.DRIVER);
      con = DriverManager.getConnection(Constant.URL , Constant.USER , Constant.PASSWD);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return con;
    
  }
}
