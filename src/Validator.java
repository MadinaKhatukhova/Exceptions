import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern LOGIN_PATTERN = Pattern.compile("[a-zA-Z0-9_]{1,20}");

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9_]{1,20}");

    public static void validate(String Login, String password, String confirmPassword) throws WrongLoginException {
        try {
            validateLogin(Login);
            validatePassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Валидация пройдена");

        }

    }

    private static void validateLogin(String login) throws WrongLoginException {
        if (!LOGIN_PATTERN.matcher(login).matches()) {
            throw new WrongLoginException("Логин неверный, проверьте корректность введенных данных");

        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new WrongPasswordException("Пароль неверный, проверьте корректность введенных данных");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают, проверьте корректность введенных данных");
        }
    }

}