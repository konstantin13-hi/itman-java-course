package employeeweb.controllers;

import employeeweb.dto.EmployeeDto;
import employeeweb.services.EmployeeService;
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
     */
    @PostMapping("/api/employees")
    public void addEmployee(@Valid @RequestBody final EmployeeDto employee) throws SQLException {
        employeeService.add(employee);
    }

    /**
     * Updates an existing employee's information based on the provided data.
     *
     * @param id The unique identifier of the employee to be updated.
     * @param employee Information about the employee's updated details.
     * @throws SQLException If an error occurs during the database interaction.
     */
    @PutMapping("/api/employees/{id}")
    public void updateEmployee(@PathVariable int id,
                               @Valid @RequestBody EmployeeDto employee) throws SQLException {

        employeeService.update(id, employee);


    }

    /**
     * Deletes an employee with the specified unique identifier.
     *
     * @param id The unique identifier of the employee to be deleted.
     * @throws SQLException If an error occurs during the database interaction.
     */
    @DeleteMapping("/api/employees/{id}")
    public void deleteEmployee(@PathVariable int id) throws SQLException {
        employeeService.deleteEmployee(id);

    }

    /**
     * Retrieves information about an employee with the specified unique identifier.
     *
     * @param id The unique identifier of the employee to be retrieved.
     * @return An EmployeeDto object representing the employee's information.
     * @throws SQLException If an error occurs during the database interaction.
     */
    @GetMapping("/api/employees/{id}")
    public EmployeeDto getEmployee(@PathVariable int id) throws SQLException {
        return employeeService.getEmployee(id);
    }

    /**
     * Retrieves a list of all employees in the database.
     *
     * @return An array of EmployeeDto objects representing the employee information.
     * @throws SQLException If an error occurs during the database interaction.
     */
    @GetMapping("/api/employees")
    public EmployeeDto[] getAllEmployees() throws SQLException {
        return employeeService.getAllEmployees();

    }


}
