// Урок 3. Продвинутая работа с исключениями в Java
// ============================================================================


package les_03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        
    //     FileReader test = null;
    //     try {
    //         test = new FileReader("/Users/User/Desktop/Exceptions_in_program/les_02/test");
    //         // test.read();
    //     } catch (RuntimeException | IOException e) {  
    //         System.out.println("catch exceprion: " + e.getClass().getSimpleName()); 
    //     } finally { 
    //         System.out.println("finally start");
    //         if (test != null){
    //             try {
    // // Очень важный элемент, при работе с файлами! Нужно всегда закрывать за собой!
    //                 test.close(); // Так
    //             } catch (IOException e) {
    //                 System.out.println("exception while close");
    //             }
    //         }
    //         System.out.println("finally finished");
    //     }

// Блок try-with-resources  - закроет те ресурсы которые были открыты в пределах блока try, поэтому код короче.
// Модернизировал код 

        // Это два различных потока. Будут закрыты автоматически после завершения работы кода.
        try (FileReader reader = new FileReader("/Users/User/Desktop/Exceptions_in_program/les_02/test");
        FileWriter writer = new FileWriter("/Users/User/Desktop/Exceptions_in_program/les_03/test2")) { 
           while (reader.ready()){ // Пока в reader есть что читать
                writer.write(reader.read()); // записывать в writer
           } 
        } catch (RuntimeException | IOException e) {  
            System.out.println("catch exceprion: " + e.getClass().getSimpleName()); 
        } 
        System.out.println("Copy successfully");
    }
}
