// // Задание 3:
// ---------------------------------------------------------------------------------------------
// Реализуйте метод divArrays, принимающий в качестве аргументов два целочисленных массива a и b, 
// и возвращающий новый массив с, каждый элемент которого равен частному элементов двух входящих 
// массивов в той же ячейке.
// Если длины массивов не равны - верните нулевой массив длины 1.

// Важно: При выполнении метода единственное исключение, которое пользователь может увидеть 
// RuntimeException, т.е. ваше.
// Напишите свой код в методе divArrays класса Answer. 
// Метод divArrays принимает на вход два параметра:

// int[] a - первый массив
// int[] b - второй массив
// Пример:
// a = new int[]{12, 8, 16};
// b = new int[]{4, 2, 4};

// Вывод: [3, 4, 4]
// -----------------------------------------------------
// a = new int[]{12, 8, 16, 25};
// b = new int[]{4, 2, 4};

// Вывод: [0]

package hw_01;

// public class Program3 {

// }

import java.util.Arrays;
import java.util.Random;

public class Program3 {
    public static void main(String[] args) {
        task();
    }

    static void task() {
        try {
            int[] arr1 = new GenerateArray().generateArray();
            int[] arr2 = new GenerateArray().generateArray();
            int[] result = new ProcessArray().arraysDivide(arr1, arr2);
            for (int a1 : arr1)
                System.out.printf("%d\t", a1);
            System.out.println();
            for (int a2 : arr2)
                System.out.printf("%d\t", a2);
            System.out.println();
            System.out.println("Частное элементов двух массивов равна:");
            for (int i : result)
                System.out.printf("%d\t", i);
        } catch (ProcessArray.CustomArraySizeException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            System.out.printf(
                    "Длина первого массива: %d\nДлина второго массива: %d\n",
                    e.getLength1(), e.getLength2());
        } catch (ProcessArray.CustomDivideException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            System.out.printf("Элемент по индексу %d равен нулю", e.getElement());
        }
    }

    public class GenerateArray {
        public int[] generateArray() {
            Random random = new Random();
            int[] arr = new int[random.nextInt(2) + 4];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(10);
            }
            return arr;
        }
    }

    public class ProcessArray {
        public int[] arraysDifference(int[] arr1, int[] arr2) {
            if (arr1 == null || arr2 == null) {
                throw new NullPointerException("Оба массива должны существовать.");
            }
            if (arr1.length != arr2.length) {
                throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаково.",
                        arr1.length, arr2.length);
            }
            int[] result = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                result[i] = arr1[i] - arr2[i];
            }
            return result;
        }

        public int[] arraysDivide(int[] arr1, int[] arr2) {
            if (arr1 == null || arr2 == null) {
                throw new NullPointerException("Оба массива должны существовать.");
            }
            if (arr1.length != arr2.length) {
                throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаково.",
                        arr1.length, arr2.length);
            }
            int[] result = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                if (arr2[i] == 0) {
                    throw new CustomDivideException("Делить на ноль нинада !", i);
                }
                result[i] = arr1[i] / arr2[i];
            }
            return result;
        }

        class CustomArraySizeException extends RuntimeException {

            int length1;
            int length2;

            public int getLength1() {
                return length1;
            }

            public int getLength2() {
                return length2;
            }

            public CustomArraySizeException(String message, int length1, int length2) {
                super(message);
                this.length1 = length1;
                this.length2 = length2;
            }
        }

        class CustomDivideException extends ArithmeticException {
            int element;

            public int getElement() {
                return element;
            }

            public CustomDivideException(String message, int element) {
                super(message);
                this.element = element;
            }
        }
    }
}
