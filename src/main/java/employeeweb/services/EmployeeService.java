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
     * @throws SQLException If there is an SQL-related error during the operation.
     */
    void add(EmployeeDto employee) throws SQLException;

    /**
     * Updates an employee's information based on the provided ID.
     *
     * @param id      The ID of the employee to be updated.
     * @param employee The EmployeeDto object containing the updated employee information.
     * @throws SQLException If there is an SQL-related error during the operation.
     */
    void update(int id, EmployeeDto employee) throws SQLException;

    /**
     * Deletes an employee with the specified ID.
     *
     * @param id The ID of the employee to be deleted.
     * @throws SQLException If there is an SQL-related error during the operation.
     */
    void deleteEmployee(int id) throws SQLException;

    /**
     * Retrieves an employee's information based on the provided ID.
     *
     * @param id The ID of the employee to be retrieved.
     * @return An EmployeeDto object containing the information of the requested employee.
     * @throws SQLException If there is an SQL-related error during the operation.
     */
    EmployeeDto getEmployee(int id) throws SQLException;

    /**
     * Retrieves information about all employees.
     *
     * @return An array of EmployeeDto objects representing the information of all employees.
     * @throws SQLException If there is an SQL-related error during the operation.
     */
    EmployeeDto[] getAllEmployees() throws SQLException;
}
