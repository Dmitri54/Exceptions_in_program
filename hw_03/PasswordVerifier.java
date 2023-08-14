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
        
        if (password.length() < 8) {
            throw new Exception("Пароль должен быть не менее 8 символов.");
        }

        boolean conteinsDigit = false;
        boolean containsUppercase = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);            
            if (Character.isDigit(ch)) {
                conteinsDigit = true;                
            }
            if (Character.isUpperCase(ch)) {
                containsUppercase = true;                
            }
        }

        if (!conteinsDigit) {
            throw new Exception("Пароль должен содержать хотя бы одну цифру.");
        }
     
        if (!containsUppercase) {
            throw new Exception("Пароль должен содержать хотя бы одну заглавную букву.");
        }
    }
}

