import java.util.regex.Pattern;

public class Validator {

    private static final Pattern LOGIN_PATTERN = Pattern.compile("[a-zA-Z0-9]{1,20}");

    private static void validatelogin(String Login) {
        if (!LOGIN_PATTERN.matcher(Login).matches()) ;
        {

        }
    }

    private static void validatePassword(String password){

    }
}

