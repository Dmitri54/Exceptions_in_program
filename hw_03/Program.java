// Задача 1: Проверка пароля (Основы языка Java, операторы, ветвления)

// Создайте класс PasswordVerifier. Этот класс должен содержать метод, который 
// принимает строку пароля и проверяет его на соответствие следующим правилам:

// Пароль должен быть не менее 8 символов.
// Пароль должен содержать хотя бы одну цифру.
// Пароль должен содержать хотя бы одну заглавную букву.

// Метод должен выбрасывать исключение, если пароль не соответствует какому-либо из этих правил.

package hw_03;

import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws PaswdEnterIncorrect {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        try {
            PasswordVerifier str = PaswrdVerifier();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        
    }

}

class PasswordVerifier { 
    public void PaswrdVerifier(String password) throws PaswdEnterIncorrect {
        System.out.println("Введите пароль.");
        if (password.length() < 8) {
            throw new PaswdEnterIncorrect("Пароль должен быть не менее 8 символов.");
        }

        boolean conteinsDigit = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                conteinsDigit = true;
                break;
            }
        }
        if (!conteinsDigit) {
            throw new PaswdEnterIncorrect("Пароль должен содержать хотя бы одну цифру.");
        }

        boolean containsUppercase = false;
        for (int j = 0; j < password.length(); j++) {
            char ch = password.charAt(j);
            if (Character.isUpperCase(ch)) {
                containsUppercase = true;
                break;
            }
        }

        if (!containsUppercase) {
            throw new PaswdEnterIncorrect("Пароль должен содержать хотя бы одну заглавную букву.");
        }

    }
}

class PaswdEnterIncorrect extends Exception {
    public PaswdEnterIncorrect(String message) {
        super(message);
    }
}
