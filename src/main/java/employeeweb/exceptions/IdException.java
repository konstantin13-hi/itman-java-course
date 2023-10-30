package employeeweb.exceptions;

public class IdException extends RuntimeException {

    /**
     * Constructs a new instance of the exception with a default message.
     */
    public IdException() {
        super("Id is not correct");
    }

    /**
     * Constructs a new instance of the exception with a custom message.
     *
     * @param message A custom error message to describe the exception.
     */
    public IdException(String message) {
        super(message);
    }
}
