// Второй пример с Checked, потому что код исключений наследуются от Exception.
// ----------------------------------------------------------------------

package sem_02;

public class Calculator {

    private double arg1, arg2;

    public void setArg1(String value) throws InvalidArgumentException {
        if (isNumeric(value)) {
            arg1 = Double.parseDouble(value);
        } else {
            throw new InvalidArgumentException("Invalid argument: " + value + " is not a valid number");
        }
    }

    public void setArg2(String value) throws InvalidArgumentException {
        if (isNumeric(value)) {
            arg2 = Double.parseDouble(value);
        } else {
            throw new InvalidArgumentException("Invalid argument: " + value + " is not a valid number");
        }
    }

    // ... остальной код класса ...

    private boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Определяем собственное исключение внутри класса Calculator
    // public static class InvalidArgumentException extends Exception { // Так будет Checked
    public static class InvalidArgumentException extends RuntimeException { // Так Unchecked
        public InvalidArgumentException(String message) {
            super(message);
        }
    }
}


