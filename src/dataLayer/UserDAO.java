package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

  //JDBC driver name and database URL
  private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
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

  private void resultSetCloseSafe(ResultSet resultSet) {
    try {
      if (resultSet != null && !resultSet.isClosed())
        resultSet.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void statementCloseSafe(Statement statement) {
    try {
      if (statement != null && !statement.isClosed())
        statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void closeAndDisconnect(Statement statement, ResultSet resultSet) {
    resultSetCloseSafe(resultSet);
    statementCloseSafe(statement);
    disconnect();
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
      valid = resultSet.next();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      closeAndDisconnect(statement, resultSet);
    }
    return valid;
  }

  public boolean createAccount(String username, String password) {

    connect();
    Statement statement = null;
    ResultSet resultSet = null;

    try {
      statement = connection.createStatement();
      String userQuery = String.format("SELECT * FROM users WHERE username = \"%s\"", username);

      resultSet = statement.executeQuery(userQuery);

      if (resultSet.next()) return false;

      String sql = String.format(
          "INSERT INTO users (username, password) VALUES (\"%s\", \"%s\")", username, password);

      return statement.executeUpdate(sql) > 0;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      closeAndDisconnect(statement, resultSet);
    }

    return false;
  }

}
