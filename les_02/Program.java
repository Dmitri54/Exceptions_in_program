// Урок 2. Исключения и их обработка
// ---------------------------------------------------------------------------------


package les_02;

import java.io.File;

public class Program {
    public static void main(String[] args) {
// Exceptions:
// 1) NullPointerException
        // String name = null;
        // System.out.println(name.length()); // NullPointerException

// ClassCastException (Но у меня просто выводит Error) 
        Object object = new String("123");
        File file = (File) object;
        System.out.println(file);


    }
}
