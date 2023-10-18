package employeeweb.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    /**
     * Constructs a new instance of the exception with a default message.
     */
    public EmployeeNotFoundException() {
        super("Employee not found");
    }

    /**
     * Constructs a new instance of the exception with a custom message.
     *
     * @param message A custom error message to describe the exception.
     */
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
