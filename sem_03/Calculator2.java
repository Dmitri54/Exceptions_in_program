package sem_03;

import java.util.Scanner;

class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true; // Переменная типа флаг - по true делай это

        do { // цикл do-while для повторения запроса ввода
            try {
                System.out.print("Введите первое число: ");
                double num1 = scanner.nextDouble();

                System.out.print("Введите операцию (+, -, *, /, ^): ");
                char operator = scanner.next().charAt(0);

                System.out.print("Введите второе число: ");
                double num2 = scanner.nextDouble();

                double result = calculate(num1, operator, num2);
                System.out.println("Результат: " + result);
                continueInput = false; // if no exception is thrown, we can stop asking for input
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        } while (continueInput); // keep asking for input while continueInput is true
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
