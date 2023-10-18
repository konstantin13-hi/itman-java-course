package employeeweb.services;

import employeeweb.dto.CreateEmployeeDto;
import employeeweb.dto.EmployeeDto;
import employeeweb.exceptions.EmployeeNotFoundException;
import employeeweb.repositories.DbEmployeeRepository;
import employeeweb.repositories.EmployeeRepository;
import entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private DbEmployeeRepository employeeRepository;

    /**
     * Constructor for creating an Employee Service implementation.
     *
     * @param employeeRepository The employee repository used for data access.
     */
    @Autowired
    public EmployeeServiceImpl(DbEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void add(EmployeeDto employeeDto) throws SQLException {
        Employee employee = employeeDto.toEmployee();
        employeeRepository.save(employee);
    }


    @Override
    public EmployeeDto getEmployee(int id) throws SQLException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с ID " + id + " не найден"));
        return new CreateEmployeeDto().employeeDto(employee);

    }

    @Override
    public void update(int id, EmployeeDto employeeDto) throws SQLException {
        Employee employee = employeeDto.toEmployee();
        employee.setId(id);
        employeeRepository.save(employee)
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с ID " + id + " не найден"));

    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        boolean deleted = employeeRepository.deleteEmployee(id);
        if (!deleted) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
    }


    @Override
    public EmployeeDto[] getAllEmployees() throws SQLException {
        List<Employee> employees = employeeRepository.findAll();
        EmployeeDto[] employeeDtos = new EmployeeDto[employees.size()];

        int index = 0;
        for (Employee employee : employees) {
            employeeDtos[index] = convertToDto(employee);
            index++;
        }

        return employeeDtos;
    }

    private EmployeeDto convertToDto(Employee employee) {
        return new EmployeeDto(
                employee.getName(),
                employee.getSurname(),
                employee.getPhone(),
                employee.getPositionEml(),
                employee.getDateOfEmployment(),
                employee.getDateOfDismissal(),
                employee.getSalary()
        );
    }
}
