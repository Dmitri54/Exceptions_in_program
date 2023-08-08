package les_03;

import java.io.IOException;

// public class SavedException extends IOException {
//     public SavedException(String message, Exception e){
//         super(message, e);
//     }
// }

public class SavedException extends RuntimeException {
    public SavedException(String message, Exception e){
        super(message, e);
    }
}
