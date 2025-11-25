package by.innowise.tkachuk.exception;

public class UnexpectedValueException extends Exception {

    public UnexpectedValueException(String message) {
        super(message);
    }

    public UnexpectedValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
