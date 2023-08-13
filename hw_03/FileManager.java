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
    public void read(String filePath) throws FileNotFoundException {
        
        File file = new File(filePath);

        if(!file.exists()){
            throw new FileNotFoundException("Фаил для чтения не найден" + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/User/Desktop/Exceptions_in_program/hw_03/FileForHw_03.java"))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    // Метод записи в фаил
    public void write (String filePath, String content) throws FileNotFoundException {
        File file = new File(filePath);

        if(!file.exists()){
            throw new FileNotFoundException("Фаил для записи не найден: " + filePath);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/User/Desktop/Exceptions_in_program/hw_03/FileForHw_03.java"))){
            writer.write(content);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    // Метод копирования файла
    public void copy (String sourcePath, String destinationPath) throws FileNotFoundException {
        File sourcFile = new File(sourcePath);

        if (! sourcFile.exists()) {
            throw new FileNotFoundException("Фаил для копирования не найден: " + sourcePath);
        }

        File destinationFile = new File(destinationPath);

        try (InputStream input = new FileInputStream(sourcePath); 
            OutputStream output = new FileOutputStream(destinationPath)){
            
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = input.read(buffer)) != -1){
                    output.write(buffer, 0 , bytesRead);
                }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
