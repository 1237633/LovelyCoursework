package sky.pro.java.course2.homework17.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Storage is full!")
public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException() {
    }

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }

    public EmployeeStorageIsFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
