// Задача 1: Проверка пароля (Основы языка Java, операторы, ветвления)

// Создайте класс PasswordVerifier. Этот класс должен содержать метод, который 
// принимает строку пароля и проверяет его на соответствие следующим правилам:

// Пароль должен быть не менее 8 символов.
// Пароль должен содержать хотя бы одну цифру.
// Пароль должен содержать хотя бы одну заглавную букву.

// Метод должен выбрасывать исключение, если пароль не соответствует какому-либо из этих правил.

package hw_03;

public class PasswordVerifier {

    public void PaswrdVerifier(String password) throws Exception {
        // System.out.println("Введите пароль.");
        if (password.length() < 8) {
            throw new Exception("Пароль должен быть не менее 8 символов.");
        }

        boolean conteinsDigit = true;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                conteinsDigit = false;
                break;
            }
        }
        if (conteinsDigit) {
            throw new Exception("Пароль должен содержать хотя бы одну цифру.");
        }

        boolean containsUppercase = true;
        for (int j = 0; j < password.length(); j++) {
            char ch = password.charAt(j);
            if (Character.isUpperCase(ch)) {
                containsUppercase = false;
                break;
            }
        }

        if (containsUppercase) {
            throw new Exception("Пароль должен содержать хотя бы одну заглавную букву.");
        }
    }
}

