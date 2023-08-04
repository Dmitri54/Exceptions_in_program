// Урок 2. Исключения и их обработка
// ---------------------------------------------------------------------------------


package les_02;

import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {
// Exceptions:
// 1) NullPointerException
        // String name = null;
        // System.out.println(name.length()); // NullPointerException

// 2) ClassCastException (Но у меня просто выводит Error) 
        // Object object = new String("123");
        // File file = (File) object;
        // System.out.println(file);

// 3) NumberFormatException
        // String number = "123fg";
        // int result = Integer.parseInt(number);
        // System.out.println(result);

// 4) UnsupportedOperationException
        // List<Object> emptyList = Collections.emptyList();
        // emptyList.add(new Object()); // метод .add не доступен для emptyList

// ==============================================================================
// try - catch
        // int number = 1;
        // try {
        //     number = 10 / 0;
        //     // number = 10 / 1; // Так работает.
            
        //     String test = null;
        //     // System.out.println(test.length()); // получу исключение - NullPointerException
        //     Collections.emptyList().add(new Object());
        // } catch (ArithmeticException e) { // Заменил и приложение перестало падать с ошибкой.
        //     System.out.println("На ноль делить нельзя (operation divide by zero not supported)");
        // } catch (NullPointerException e) {
        //     System.out.println("nullpointer exeption");
        // } catch (Exception e) {
        //     System.out.println("exception");
        // }
        // System.out.println(number);

// -----------------------------------------------------------------------------------------
// Checked - обязательные. Проверяемые.
// Unchecked - не обязательные исключения. Не проверяемые.

// Checked не дадут скомпилировать код, если обработка этой ошибки не была произведена.
        // FileReader test = new FileReader("test"); // VSC не даст скомпилировать этот код, т.к. ошибка FileNotFoundException  

        try {
            FileReader test = new FileReader("test");
        } catch (RuntimeException e) { // или FileNotFoundException не работает. С Exception - работает.
            throw new RuntimeException(e);
            
        }

    }
}
