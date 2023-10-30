package employeeweb.exceptions;

public class DatabaseQueryException extends RuntimeException {

    /**
     * Constructs a new DatabaseQueryException with a default "Bad query" message.
     */
    public DatabaseQueryException() {
        super("Bad query");
    }

    /**
     * Constructs a new DatabaseQueryException with the specified detail message.
     *
     * @param message The detail message explaining the exception.
     */
    public DatabaseQueryException(String message) {
        super(message);
    }
}