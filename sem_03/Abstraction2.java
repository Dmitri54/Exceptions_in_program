// В этом примере я разделил чтение данных из файла и вычисление результата в разные методы.
// Это упрощает чтение, понимания кода, принципы SOLID.
package sem_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Abstraction2 {
    public static void main(String[] args) { 
// С использованием одного уровня абстракции
// Код выглядет гораздо короче и понятнее.

        try { 
            CalculationData data = readDataFromFile("input.txt");
            double result = calculate(data.num1, data.operator, data.num2);
            System.out.println("Результат: " + result);
        } catch (IOException | InvalidInputException e) {
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

// Этот метод отвечает за чтение файла.
    public static CalculationData readDataFromFile(String fileName) throws IOException { 
        FileReader file = new FileReader(fileName);
        BufferedReader fileInput = new BufferedReader(file);

        double num1 = Double.parseDouble(fileInput.readLine()); // читаю
        char operator = fileInput.readLine().charAt(0);
        double num2 = Double.parseDouble(fileInput.readLine());

        fileInput.close();
        return new CalculationData(num1, operator, num2);
    }

// Этот класс занимается вычислением
    static class CalculationData { 
        double num1;
        char operator;
        double num2;

// Конструктор класса
        CalculationData(double num1, char operator, double num2) { 
            this.num1 = num1;
            this.operator = operator;
            this.num2 = num2;
        }
    }
}
