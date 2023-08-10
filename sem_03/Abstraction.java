// Пример: допустим я хочу добавить в мой Calculator добавить фукцию чтение данных из файла
// и выполнение математических операций, которые указаны в этом файле.

package sem_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Abstraction {
    public static void main(String[] args) {
// Без использования одного уровня абстракции.
// ----------------------------------------------------------------------------------------
        try {
            // Чтение данных из файла
            FileReader file = new FileReader("input.txt");
            BufferedReader fileInput = new BufferedReader(file);
            double num1 = Double.parseDouble(fileInput.readLine());
            char operator = fileInput.readLine().charAt(0);
            double num2 = Double.parseDouble(fileInput.readLine());

            // Вычисление и печать результата
            double result = calculate(num1, operator, num2);
            System.out.println("Результат: " + result);

            fileInput.close();
        } catch (IOException | InvalidInputException e) { // IOException - ошибки ввода-вывода
            e.printStackTrace();
        }
    }
    public static double calculate(double num1, char operator, double num2)
            throws InvalidInputException, ArithmeticException {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль недопустимо");
                }
                return num1 / num2;
            case '^':
                if (num1 == 0 && num2 < 0) {
                    throw new InvalidInputException("Ноль не может быть возведен в отрицательную степень.");
                }
                return Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException("Недопустимая операция");
        }
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
