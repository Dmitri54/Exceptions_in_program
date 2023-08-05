// Урок 2. Исключения и их обработка
// ==================================================================================

package sem_02;

class MyException extends Exception { // Создал свой класс Исключений и наследую от Exception

    public MyException() {
        super("This is my exception"); // или так, но в первом варианте будет лучше!
    }

    public static class Test {
        public static void main(String[] args) {
            try {
                throw new MyException(); // Пробросил MyException сюда
            } catch (MyException e) {
                System.out.println(e.getMessage()); // .getMessage() - метод выводит сообщение об ошибки
            }
        }
    }
}
