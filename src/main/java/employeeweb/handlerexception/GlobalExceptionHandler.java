package employeeweb.handlerexception;

import employeeweb.exceptions.EmployeeNotFoundException;
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

    /**
     * Handles exceptions related to validation errors.
     *
     * @param ex The MethodArgumentNotValidException to handle.
     * @return A ResponseEntity containing error messages for validation issues.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return getStringResponseEntity(ex);
    }

    /**
     * Handles exceptions related to employee not found.
     *
     * @param ex The EmployeeNotFoundException to handle.
     * @return A ResponseEntity containing the error message for an employee not found.
     */
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    private static ResponseEntity<String> getStringResponseEntity(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> errors = bindingResult.getAllErrors();
        List<String> errorMessages = new ArrayList<>();

        for (ObjectError error : errors) {
            errorMessages.add(error.getDefaultMessage());
        }

        String errorMessage = String.join(", ", errorMessages);


        return ResponseEntity.badRequest().body(errorMessage);
    }
}
