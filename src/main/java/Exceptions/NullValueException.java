package Exceptions;

public class NullValueException extends RuntimeException{

    public NullValueException() {
        super("A value cannot be null");
    }
    public NullValueException(String cause) {
        super(cause);
    }
}
