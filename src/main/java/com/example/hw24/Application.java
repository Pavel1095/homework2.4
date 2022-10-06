package com.example.hw24;

import com.example.hw24.exceptions.WrongLoginException;
import com.example.hw24.exceptions.WrongPasswordException;

public class Application {

    public static void main(String[] args) {

      boolean isCorrect = validate("Ivan", "12345", "12345");
        System.out.println(isCorrect);

    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            if (login.length() > 20) {
                throw new WrongLoginException();
            }

            if (password.length() > 20) {
                throw new WrongPasswordException();
            }

            if (!confirmPassword.equals(password))
                throw new WrongPasswordException();

        } catch (WrongLoginException e) {
            System.out.println("Слишком длинный логин.");
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("слишком доинный пароль или пароли не совпадают.");
            return false;
        }
        return true;
    }
}
