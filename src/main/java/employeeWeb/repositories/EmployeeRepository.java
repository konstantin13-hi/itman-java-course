package employeeWeb.repositories;

import entities.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    void add(Employee employee) ;

    void update(int id,Employee employee);

    void delete(int id);

    Employee getEmployee(int id);

    List<Employee> getAll() throws SQLException;
}
