// Задача 1:
// Напишите программу, которая запрашивает у пользователя число и проверяет, 
// является ли оно положительным. 
// Если число отрицательное или равно нулю, программа должна выбрасывать исключение 
// InvalidNumberException с сообщением "Некорректное число". 
// В противном случае, программа должна выводить сообщение "Число корректно".

package hw_02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;

        do {
            
                System.out.print("Введите число: ");
                int num = scanner.nextInt();
                try {
                    System.out.println(numcheck(num));
                } catch (InvalidNumberException e) {
                    System.out.println("Некорректное число");
                }

                continueInput = false;
                
            
        } while (continueInput);
    }

    public static int numcheck(int number) throws InvalidNumberException{
        if (number <= 0){
            throw new InvalidNumberException("Некорректное число");
        } else {
            System.out.println("Число корректно");
        }
        return number;
    }

    public static class InvalidNumberException extends Exception {
        public InvalidNumberException (String message){
            super(message);
        }
    }
}
