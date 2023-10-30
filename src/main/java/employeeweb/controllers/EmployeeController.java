package employeeweb.controllers;

import employeeweb.dto.*;
import employeeweb.exceptions.IdException;
import employeeweb.services.EmployeeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import javax.validation.Valid;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Creates an instance of the EmployeeController class.
     *
     * @param employeeService The service responsible for handling employee-related operations.
     */
    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Creates a new employee based on the provided information.
     *
     * @param employee Information about the employee to be added.
     * @cpu O(1)
     * @ram O(1)
     */
    @PostMapping("/api/employees")
    public void addEmployee(@Validated @RequestBody final EmployeeDto employee) {
        employeeService.add(employee);
    }

    /**
     * Updates an existing employee's information based on the provided data.
     *
     * @param id The unique identifier of the employee to be updated.
     * @param employee Information about the employee's updated details.
     * @cpu O(n), where n is the length of the employees list.
     * @ram O(1)
     */
    @PutMapping("/api/employees/{id}")
    public void updateEmployee(@PathVariable int id,
                               @Valid @RequestBody EmployeeDto employee) {
        if (id <= 0) {
            throw new IdException("Неправильное значение ID: " + id);
        }
        employeeService.update(id, employee);
    }

    /**
     * Deletes an employee with the specified unique identifier.
     *
     * @param id The unique identifier of the employee to be deleted.
     * @cpu O(n), where n is the length of the employees list.
     * @ram O(1)
     */
    @DeleteMapping("/api/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        if (id <= 0) {
            throw new IdException("Неправильное значение ID: " + id);
        }
        employeeService.deleteEmployee(id);
    }

    /**
     * Retrieves information about an employee with the specified unique identifier.
     *
     * @param id The unique identifier of the employee to be retrieved.
     * @return An EmployeeDto object representing the employee's information.
     * @cpu O(n)  where n is the length of the employees list.
     * @ram O(1)
     */
    @GetMapping("/api/employees/{id}")
    public EmployeeDto getEmployee(@PathVariable int id) {
        if (id <= 0) {
            throw new IdException("Неправильное значение ID: " + id);
        }
        return employeeService.getEmployee(id);
    }

    /**
     * Retrieves a list of all employees in the database.
     *
     * @return An array of EmployeeDto objects representing the employee information.
     * @cpu O(n), where n is the length of the employees list.
     * @ram O(n). where n is the length of the employees list.
     */
    @GetMapping("/api/employees")
    public EmployeeDto[] getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
