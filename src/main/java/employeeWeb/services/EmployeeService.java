package employeeWeb.services;

import employeeWeb.dto.EmployeeDto;
import entities.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {


    void addEmployee(EmployeeDto employee) throws SQLException;

    void updateEmployee(int id, EmployeeDto employee);

    void deleteEmployee(int id);


    EmployeeDto getEmployee(int id);

    EmployeeDto[] getAllEmployees() throws SQLException;



}
