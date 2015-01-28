package com.ufgov.zc.server.zc.dao.ibatis;import java.sql.Connection;import java.sql.DriverManager;import java.sql.SQLException;import java.util.Properties;import com.ufgov.zc.server.system.util.AsOptionUtil;public class DAOFactory {  private static String userName = AsOptionUtil.getInstance().getOptionVal("OPT_ZC_PORTAL_ORACLE_USERNAME");  private static String passWord = AsOptionUtil.getInstance().getOptionVal("OPT_ZC_PORTAL_ORACLE_PASSWROD");  private static String jdbcUrl = AsOptionUtil.getInstance().getOptionVal("OPT_ZC_PORTAL_ORACLE_URL");  public static DAOFactory getInstance() {    return new DAOFactory();  }  /** 连接 oracle */  public static Connection getConnection() {    Connection conn = null;    try {      String driverName = "oracle.jdbc.driver.OracleDriver";      String url;      Properties p = new Properties();      String[][] ss = { { jdbcUrl, userName, passWord } };      int ii = 0; // TODO: 选择合适的连接                                          url = ss[ii][0];      p.put("user", ss[ii][1]);      p.put("password", ss[ii][2]);      Class.forName(driverName);      conn = DriverManager.getConnection(url, p);    }    catch (ClassNotFoundException e) {      e.printStackTrace();    }    catch (SQLException e) {      e.printStackTrace();    }    return conn;  }}