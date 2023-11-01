package employeeweb.services;

import employeeweb.dto.EmployeeDto;

import java.sql.SQLException;

/**
 * This interface defines the contract for services related to employee management.
 */
public interface EmployeeService {

    /**
     * Adds a new employee with the provided information.
     *
     * @param employee The EmployeeDto object containing employee details to be added.
     */
    void add(EmployeeDto employee);

    /**
     * Updates an employee's information based on the provided ID.
     *
     * @param id      The ID of the employee to be updated.
     * @param employee The EmployeeDto object containing the updated employee information.
     */
    void update(int id, EmployeeDto employee);

    /**
     * Deletes an employee with the specified ID.
     *
     * @param id The ID of the employee to be deleted.
     */
    void deleteEmployee(int id);

    /**
     * Retrieves an employee's information based on the provided ID.
     *
     * @param id The ID of the employee to be retrieved.
     * @return An EmployeeDto object containing the information of the requested employee.
      */
    EmployeeDto getEmployee(int id);

    /**
     * Retrieves information about all employees.
     *
     * @return An array of EmployeeDto objects representing the information of all employees.
     */
    EmployeeDto[] getAllEmployees();
}
