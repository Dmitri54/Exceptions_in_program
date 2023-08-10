//  Урок 3. Продвинутая работа с исключениями в Java
// ======================================================================

package sem_03;

import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();

            System.out.print("Введите операцию (+, -, *, /, ^): ");
            char operator = scanner.next().charAt(0);

            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            double result = calculate(num1, operator, num2);
            System.out.println("Результат: " + result);
// Дополнительная обработка ошибок
        } catch (InvalidInputException e) {
// В скобках - InvalidInputException e = new InvalidInputException("Недопустимая операция");
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    public static double calculate(double num1, char operator, double num2)
            throws InvalidInputException { 
// Пишу в сигнатуре метода throws, чтобы явно дать понять, что использую это исключение (InvalidInputException).
// Поэтому можно не писать блок try-catch.
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new InvalidInputException("Деление на ноль недопустимо");
// В месте где нужно выкинуть исключение, при помощи слова (throw) указываю на это и создаю запрос на создание исклбчения (new InvalidInputException)
                }
                return num1 / num2;
            case '^':
                if (num1 == 0 && num2 < 0) {
                    throw new InvalidInputException("Ноль не может быть возведен в отрицательную степень.");
                }
                return Math.pow(num1, num2);
            default:
                throw new InvalidInputException("Недопустимая операция");
        }
    }
}

class InvalidInputException extends Exception { // Мой класс, наследую от Exception
    public InvalidInputException(String message) { // Мой метод. Недопустимое исключение ввода
        super(message);
    }
}