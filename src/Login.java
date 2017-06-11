/**
 * Created by Acer on 11/06/2017.
 */
public class Login {

    public static boolean authenticate(String username, String password)
    {
        // hardcoded username and password
        if (username.equals("admin") && password.equals("admin")) {
            return true;

        }
        return false;
    }
}