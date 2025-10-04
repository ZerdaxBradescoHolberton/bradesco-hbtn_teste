import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkUser() {
        return username.length() >= 8
                && !Pattern.compile("[^a-zA-Z0-9]").matcher(username).find();
    }

    public boolean checkPassword() {
        
        return password.length() >= 8
                && Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()
                && Pattern.compile("[a-z]").matcher(password).find()
                && Pattern.compile("[A-Z]").matcher(password).find()
                && Pattern.compile("[0-9]").matcher(password).find();
    }
}