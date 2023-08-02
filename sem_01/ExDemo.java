package sem_01;

public class ExDemo {
    public static void main(String[] args) {
        int[] num = {4, 8, 16, 32, 64, 128,256, 512};
        int[] num2 = {2, 0, 4, 4, 0, 8};
        for (int i = 0; i < num.length; i++) {
            try{
                System.out.println(num[i] + " / " + num2[i] + " = " + num[i]/num2[i]);
            } catch (Exception exception){
                System.out.println("Попытка деления на ноль или выход за границы массива");
            } // catch (ArrayIndexOutOfBoundsException exception){
            //     System.out.println("Элемент не найден");
            // }
        }
    }
}
// Throwable - super class, поэтому ловятся все исключения. 

// Exception - является под классом Throwable. 
// Обрабатывает исключения связанные только с програмными ошибками.

// 4 / 2 = 2
// Попытка деления на ноль или выход за границы массива
// 16 / 4 = 4
// 32 / 4 = 8
// Попытка деления на ноль или выход за границы массива
// 128 / 8 = 16
// Попытка деления на ноль или выход за границы массива
// Попытка деления на ноль или выход за границы массива