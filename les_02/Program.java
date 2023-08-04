// Урок 2. Исключения и их обработка
// ---------------------------------------------------------------------------------


package les_02;

import java.io.File;
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
        List<Object> emptyList = Collections.emptyList();
        emptyList.add(new Object()); // метод .add не доступен для emptyList

    }
}
