package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

  //JDBC driver name and database URL
  private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_URL = "jdbc:mysql://localhost/java-web-app";

  //Database credentials;
  private static final String USER = "java-web-app-user";
  private static final String PASS = "pass";
  private static Connection connection;

  private void connect() {
    try {
      if (connection == null || connection.isClosed()) {
        //Register JDBC driver
        Class.forName(JDBC_DRIVER);
        //Open a connection
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("MySQL connection established");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void disconnect() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
        System.out.println("MySQL connection closed");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public boolean isValid(String username, String password) {
    boolean valid = false;
    connect();
    Statement statement = null;
    ResultSet resultSet = null;

    try {
      //Form and execute a query
      statement = connection.createStatement();
      String sql = String.format(
          "SELECT * FROM users WHERE username = \"%s\" AND password = \"%s\"", username, password);
      resultSet = statement.executeQuery(sql);

      if (resultSet.next()) valid = true;

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (resultSet != null && !resultSet.isClosed())
          resultSet.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
      try {
        if (statement != null && !statement.isClosed())
          statement.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    disconnect();
    return valid;
  }

  public boolean createAccount(String username, String password) {

    if (isValid(username, password)) return false;

    boolean accountCreated = false;
    connect();
    Statement statement = null;
    ResultSet resultSet = null;

    try {
      statement = connection.createStatement();
      String sql = String.format(
          "INSERT INTO users (username, password) VALUES (\"%s\", \"%s\")", username, password);

      accountCreated = statement.executeUpdate(sql) > 0;
    } catch (Exception e) {
      e.printStackTrace();
    }

    disconnect();
    return accountCreated;
  }

}
