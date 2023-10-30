package employeeweb.exceptions;

public class DatabaseConnectionException extends RuntimeException {

    /**
     * Constructs a new DatabaseConnectionException with a default message "Error in database".
     */
    public DatabaseConnectionException() {
        super("Error in database");
    }

    /**
     * Constructs a new DatabaseConnectionException with the specified detail message.
     *
     * @param message The detail message explaining the exception.
     */
    public DatabaseConnectionException(String message) {
        super(message);
    }
}
