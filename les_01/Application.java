package les_01;

import java.io.File;

public class Application { // Возвращает информацию о размере файла на моём ПК.
    public static void main(String[] args) {
        System.out.println(getFileSize(new File("123")));
    }

    public static long getFileSize(File file){ // Метод возвращает информацию о размере файла на моём ПК
        if (file.exists()){
            return -1; // Чтобы точно знать что файла нет возвращаю -1
        }
        return file.length(); // обращаюсь к функции length() - т.к. если есть длинна у файла значит существует. 
    }
}
