// В данном примере принцип одного уровня абстракций достигнут в следующих аспектах:
// 1. Использование исключений, т.е. программа использует исключения для обработки различных 
// ситуаций, которые могут возникнуть в ходе вычисления.
// InvalidInputException наследуется от базового класса Exception - это мне позволяет группировать
// связанные ошибки и обрабатывать их в одном месте, т.е в одном catch, что способствует упрощению кода
// и повышению читаемости.
// 2. Структура классов и методов. Каждая задача разбита на логические функции.
// Класс calculate занимается основным потоком выполнения.
// Класс CalculationData представляет объект выполнения для хранения входных данных.
// 3. Четкое определение и обработка исключений, т.к. каждый метод который может вызвать исключение
// имеет явное объявление этого в сигнатуре метода (throws).

package sem_03.task2;

import java.util.Scanner;


public class Calculator2 {
    public static void main(String[] args) {
        try {
            CalculationData data = getInput();
            double result = calculate(data);
            System.out.println("Результат: " + result);

// Использую только один catch (в сравнении с Calculator.java)
        } catch (InvalidInputException | ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static CalculationData getInput() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();
        System.out.print("Введите операцию (+, -, *, /, ^): ");
        char operator = scanner.next().charAt(0);
        if (!isValidOperator(operator)) {
            scanner.close();
            throw new InvalidInputException("Недопустимая операция: " + operator);
        }
        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();
        scanner.close(); // Закрытие сканнера после использования
        return new CalculationData(num1, operator, num2);
    }

    public static boolean isValidOperator(char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '^';
    }

    public static double calculate(CalculationData data) throws ArithmeticException {
        switch (data.operator) {
            case '+':
                return data.num1 + data.num2;
            case '-':
                return data.num1 - data.num2;
            case '*':
                return data.num1 * data.num2;
            case '/':
                if (data.num2 == 0) {
                    throw new ArithmeticException("Деление на ноль недопустимо");
                }
                return data.num1 / data.num2;
            case '^':
                return Math.pow(data.num1, data.num2);
            default:
                throw new IllegalArgumentException("Недопустимая операция");
        }
    }

    static class CalculationData {
        double num1;
        char operator;
        double num2;

        CalculationData(double num1, char operator, double num2) {
            this.num1 = num1;
            this.operator = operator;
            this.num2 = num2;
        }
    }

    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}
