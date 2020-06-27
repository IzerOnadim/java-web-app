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

  public boolean isValid(String username, String password) {
    boolean valid = false;

    Connection connection = null;
    Statement statement = null;

    try {
      //Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //Open a connection
      System.out.println("Connecting to database...");
      connection = DriverManager.getConnection(DB_URL, USER, PASS);

      //Form and execute a query
      System.out.println("Creating statement...");
      statement = connection.createStatement();

      String sql = String.format(
          "SELECT * FROM users WHERE username = \"%s\" AND password = \"%s\"", username, password);

      System.out.println(sql);
      ResultSet resultSet = statement.executeQuery(sql);

      //Extract data from resultSet
      if (resultSet.next()) {
        valid = true;

        resultSet.close();
        statement.close();
        connection.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("closing DB connection");

    return valid;
  }

}
