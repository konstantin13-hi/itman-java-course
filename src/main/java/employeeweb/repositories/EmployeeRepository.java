package employeeweb.repositories;

import entities.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * This interface defines the contract for interacting with the repository of employee data.
 */
public interface EmployeeRepository {

    /**
     * Adds a new employee to the repository.
     *
     * @param employee The employee to be added.
     * @return An optional containing the added employee if successful, or an empty optional if the addition failed.
     */
    Optional<Employee> add(Employee employee) throws SQLException;

    /**
     * Updates an existing employee in the repository.
     *
     * @param employee The employee to be updated.
     * @return An optional containing the updated employee if successful, or an empty optional if the update failed.
     */
    Optional<Employee> update(Employee employee) throws SQLException;

    /**
     * Deletes an employee with the specified ID from the repository.
     *
     * @param id The ID of the employee to be deleted.
     * @return {@code true} if the employee was successfully deleted, or {@code false} if the employee was not found.
     * @throws SQLException If an SQL error occurs during the database operation.
     */
    boolean deleteEmployee(int id) throws SQLException;

    /**
     * Retrieves an employee's information based on the provided ID.
     *
     * @param id The ID of the employee to be retrieved.
     * @return An EmployeeDto object containing the information of the requested employee.
     */
    Optional<Employee> getEmployee(int id) throws SQLException;

    /**
     * Retrieves a list of all employees from the repository.
     *
     * @return A list of Employee objects containing the information of all employees.
     * @throws SQLException If an SQL error occurs during the database operation.
     */
    List<Employee> findAll() throws SQLException;
}
