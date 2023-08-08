package les_03;

import java.io.IOException;
import java.util.Date;


// public class SavedException extends IOException {
//     public SavedException(String message, Exception e){
//         super(message, e);
//     }
// }


public class SavedException extends IOException {

    private Date startDate; // Добавил поле, для получения дополнительной информации.

    public SavedException(String message, Date startDate, Exception e){
        // super(message, e);
        super ("exception with message: " + message, e); // Модифицировал. Пример заранее заготовленной фразы.
        this.startDate = startDate;
    }
}
