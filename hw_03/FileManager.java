// Задача 2: Файловый менеджер (ООП, исключения)

// Создайте класс FileManager. 
// Этот класс должен иметь методы для выполнения основных операций с файлами: 
// чтение, запись и копирование. 
// Каждый из этих методов должен выбрасывать соответствующее исключение, 
// если в процессе выполнения операции произошла ошибка 
// (например, FileNotFoundException, если файл не найден).


package hw_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileManager {
    // Метод чтения файла


    String filePath = "/Users/User/Desktop/Exceptions_in_program/hw_03/FileForHw_03.java";
    String fileDestinationPath = "/Users/User/Desktop/Exceptions_in_program/hw_03/Copy_FileForHw_03.java";
    public void read() throws FileNotFoundException {
        
        File file = new File(filePath);

        if(!file.exists()){
            throw new FileNotFoundException("Фаил для чтения не найден" + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Метод записи в фаил
    public void write (String content) throws FileNotFoundException {
               
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write(content);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Метод копирования файла
    public void copy () throws FileNotFoundException {      
        
        try (InputStream input = new FileInputStream(filePath); 
            OutputStream output = new FileOutputStream(fileDestinationPath)){
            
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = input.read(buffer)) != -1){
                    output.write(buffer, 0 , bytesRead);
                }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
