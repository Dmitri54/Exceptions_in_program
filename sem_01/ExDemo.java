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
        } // При попадании ошибки сюда, прекращает работу программы.
    }
}


// Чтобы сделать разный приоритет обработки ошибок.


// 4 / 2 = 2
// Попытка деления на ноль или выход за границы массива
// 16 / 4 = 4
// 32 / 4 = 8
// Попытка деления на ноль или выход за границы массива
// 128 / 8 = 16
// Элемент не найден
// Фатальная ошибка