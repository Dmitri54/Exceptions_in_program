package sem_01;

public class ExDemo {
    public static void main(String[] args) {
        int[] num = {4, 8, 16, 32, 64, 128,256, 512};
        int[] num2 = {2, 0, 4, 4, 0, 8};
        try {
            
            for (int i = 0; i < num.length; i++) {
                try{
                    System.out.println(num[i] + " / " + num2[i] + " = " + num[i]/num2[i]);
                } catch (ArithmeticException exception){
                    System.out.println("Попытка деления на ноль или выход за границы массива");
                } // Продолжает работать
            } 
        } catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("Элемент не найден");
            System.out.println("Фатальная ошибка");

            System.out.println(exception.getMessage());
            exception.printStackTrace();
            System.out.println(exception.toString());
        } // При попадании ошибки сюда, прекращает работу программы.
    }
}


// ArrayIndexOutOfBoundsException exception
// exception - это аргумент, ссылка и через неё можно обращаться к встроенным методам.


// 4 / 2 = 2
// Попытка деления на ноль или выход за границы массива
// 16 / 4 = 4
// 32 / 4 = 8
// Попытка деления на ноль или выход за границы массива
// 128 / 8 = 16
// Элемент не найден
// Фатальная ошибка
// Index 6 out of bounds for length 6                                           - exception.getMessage()
// java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
//         at sem_01.ExDemo.main(ExDemo.java:11)                                - exception.printStackTrace()
// java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6 - exception.toString()