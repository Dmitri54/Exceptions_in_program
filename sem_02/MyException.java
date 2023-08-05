// Урок 2. Исключения и их обработка
// ==================================================================================

package sem_02;

class MyException extends Exception { // Создал свой класс Исключений и наследую от Exception

    public MyException(String message) {
        super(message);
    }

    public static class Test {
        public static void main(String[] args) {
            try {
                throw new MyException("This is my exception");
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
