// Это простой пример с нарушением принципа одного уровня абстракции.
// --------------------------------------------------------------------------
package sem_03.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();
            System.out.print("Введите операцию (+, -, *, /, ^): ");
            char operator = scanner.next().charAt(0);
            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            switch (operator) {
                case '+':
                    System.out.println("Результат: " + (num1 + num2));
                    break;
                case '-':
                    System.out.println("Результат: " + (num1 - num2));
                    break;
                case '*':
                    System.out.println("Результат: " + (num1 * num2));
                    break;
                case '/':
                    System.out.println("Результат: " + (num1 / num2));
                    break;
                case '^':
                    System.out.println("Результат: " + (Math.pow(num1, num2)));
                    break;
                default:
                    throw new IllegalArgumentException("Недопустимая операция");
            }
        } catch (InputMismatchException e) {
            System.out.println("Некорректный ввод");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
