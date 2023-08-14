package hw_03;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пароль:");
        String answer = scanner.nextLine();
        

        PasswordVerifier pswd = new PasswordVerifier();
        pswd.PaswrdVerifier(answer);  
        System.out.println("Вы ввели пароль:" + answer);

        FileManager file = new FileManager();
        
        file.write(answer);
        System.out.println("file.read result:");
        file.read();
        System.out.println("file.copy ready");
        file.copy();
    }
}
