package les_03;

import java.io.FileWriter;
import java.io.IOException;

public class SaveService {
    public void save(){
        System.out.println("save document started...");
        try (FileWriter writer = new FileWriter("/Users/User/Desktop/Exceptions_in_program/les_03/test3")) {
            throw new IOException("Operation failed");
        } catch (IOException e) {
            e.printStackTrace(); // вывожу исключение в лог
        }
    }
}