// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.

// Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива

// Метод divisionByZero - Деление на 0

// Метод numberFormatException - Ошибка преобразования строки в число

// Важно: они не должны принимать никаких аргументов

package hw_01;

class Answer {
    public static void arrayOutOfBoundsException() {
        int[] num = new int[4];
        num[6] = 10;
        System.out.println(num[6]);

    }

    public static void divisionByZero() {
        int[] num = { 4, 8, 16, 32, 64, 128, 256, 512 };
        int[] num2 = { 2, 0, 4, 4, 0, 8 };
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i] + " / " + num2[i] + " = " + num[i] / num2[i]);
        }

    }

    public static void numberFormatException() {
        String str = "Hello world!";
        Integer st = Integer.parseInt(str);
        System.out.println(st);

    }
}

public class Program {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}


