package employeeweb.repositories;

import entities.Employee;

import java.util.List;
import java.util.Optional;


/**
 * This interface defines the contract for interacting with the repository of employee data.
 */
public interface EmployeeRepository {

    /**
     * Deletes an employee with the specified ID from the database.
     *
     * @param id The ID of the employee to be deleted.
     * @return {@code true} if the employee was successfully deleted, or {@code false} if the employee was not found.
     * @cpu O(n)  where n is the length of the employees list.
     * @ram O(1)
     */
    boolean deleteEmployee(int id);

    /**
     * Retrieves a list of all employees.
     *
     * @return A List of Employee objects representing all employees in the database.
     * @cpu O(n) where n is the number of employees in the list.
     * @ram O(n) where n is the number of employees in the list.
     */
    List<Employee> findAll();

    /**
     * Looks for an employee by the specified ID.
     *
     * @param id ID of the employee to be found.
     * @return An object of type Employee that represents the employee with the specified ID.
     * If the employee is not found, null is returned.
     * @cpu O(n)  where n is the length of the employees list.
     * @ram O(1)
     */
    Optional<Employee> findById(int id);


    /**
     * Searches for employees with a specific position.
     *
     * @param position The position to search for.
     * @return A List of Employee objects representing employees with the specified position.
     * @cpu O(n), where n is the length of the employees list.
     * @ram O(n). where n is the length of the employees list.
     */
    List<Employee> findByPosition(String position);

    /**
     * Saves or updates an Employee record in the database.
     *
     * @param employee The Employee object to be saved or updated.
     * @return The newly saved Employee object with its updated properties,
     * including the assigned ID (if it's a new record).
     * @cpu O(n), where n is the length of the employees list.
     * @ram O(1)
     */
    Optional<Employee> save(Employee employee);
}
