// Пример третий c Unchecked. 
// 

package sem_02;

import java.util.regex.Pattern;

public class Calculator2 {

    private double arg1, arg2;

    public void setArg1(String value) {
        if (isValidNumber(value)) {
            arg1 = Double.parseDouble(value);
        } else {
            throw new InvalidArgumentException("Invalid argument: " + value + " is not a valid number");
        }
    }

    public void setArg2(String value) {
        if (isValidNumber(value)) {
            arg2 = Double.parseDouble(value);
        } else {
            throw new InvalidArgumentException("Invalid argument: " + value + " is not a valid number");
        }
    }

    // ... остальной код класса ...

    private boolean isValidNumber(String value) {
        return Pattern.matches("^[-+]?\\d*\\.?\\d+$", value);
    }

    // Определяем собственное исключение внутри класса Calculator
    public static class InvalidArgumentException extends RuntimeException {
        public InvalidArgumentException(String message) {
            super(message);
        }
    }
}
