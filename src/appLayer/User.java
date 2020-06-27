package appLayer;

public class User {

  private final String username;
  private final String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public boolean isValid(String username, String password) {
    return username.equals(this.username) && password.equals(this.password);
  }
}
