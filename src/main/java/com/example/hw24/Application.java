package com.example.hw24;

import com.example.hw24.exceptions.WrongLoginException;
import com.example.hw24.exceptions.WrongPasswordException;

public class Application {

    public static final String allowedSymbols = "abcdefghijklmnopqrstuvwxyz0123456789_";
    public static final int MAX_LOGIN_LENGTH = 20;
    public static final int MAX_PASSWORD_LENGTH = 19;

    public static void main(String[] args) {
        boolean isCorrect = validate("IvanIvanIvanIvanIvan", "12345", "12345");
        System.out.println(isCorrect);
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            if (login.length() > MAX_LOGIN_LENGTH) {
                throw new WrongLoginException();
            }

            if (containsAnyDisallowedSymbols(login)) {
                System.out.println("логин содержит недопустимые символы.");
                return false;
            }

            if (password.length() > MAX_PASSWORD_LENGTH) {
                throw new WrongPasswordException();
            }

            if (containsAnyDisallowedSymbols(password)) {
                System.out.println("пароль содержит недопустимые символы.");
                return false;
            }

            if (!confirmPassword.equals(password)) {
                throw new WrongPasswordException();
            }


        } catch (WrongLoginException e) {
            System.out.println("Слишком длинный логин.");
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("слишком доинный пароль или пароли не совпадают.");
            return false;
        }
        return true;
    }

    private static boolean containsAnyDisallowedSymbols(String string) {
        String stringLowerCase = string.toLowerCase();
        for (int i = 0; i < stringLowerCase.length(); i++) {
            char c = stringLowerCase.charAt(i);
            if (!allowedSymbols.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}


