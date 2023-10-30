package employeeweb.handlerexception;

import employeeweb.exceptions.DatabaseQueryException;
import employeeweb.exceptions.EmployeeNotFoundException;
import employeeweb.exceptions.IdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;



@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<String> createErrorResponse(String message) {
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception handler for handling validation errors using the MethodArgumentNotValidException.
     *
     * @param ex The MethodArgumentNotValidException instance.
     * @return A ResponseEntity with a bad request status and an error message.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return createErrorResponse(getStringResponseEntity(ex));
    }

    /**
     * Exception handler for handling EmployeeNotFoundException.
     *
     * @param ex The EmployeeNotFoundException instance.
     * @return A ResponseEntity with a bad request status and an error message.
     */
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return createErrorResponse(ex.getMessage());
    }

    /**
     * Exception handler for handling custom IdException.
     *
     * @param e The IdException instance.
     * @return A ResponseEntity with a bad request status and an error message.
     */
    @ExceptionHandler(IdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleIdException(IdException e) {
        return createErrorResponse(e.getMessage());
    }

    /**
     * Exception handler for handling DatabaseQueryException.
     *
     * @param ex The DatabaseQueryException instance.
     * @return A ResponseEntity with a bad request status and an error message.
     */
    @ExceptionHandler(DatabaseQueryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleInvalidQueryException(DatabaseQueryException ex) {
        return createErrorResponse("Ошибка в SQL-запросе: " + ex.getMessage());
    }


    private static String getStringResponseEntity(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> errors = bindingResult.getAllErrors();
        List<String> errorMessages = new ArrayList<>();

        for (ObjectError error : errors) {
            errorMessages.add(error.getDefaultMessage());
        }

        String errorMessage = String.join(", ", errorMessages);


        return errorMessage;
    }

}
