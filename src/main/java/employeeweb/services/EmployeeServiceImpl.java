package employeeweb.services;

import employeeweb.dto.EmployeeDto;
import employeeweb.exceptions.EmployeeNotFoundException;
import employeeweb.repositories.DbEmployeeRepository;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(EmployeeDto employeeDto) {
        Employee employee = employeeDto.toEmployee();
        employeeRepository.save(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeDto getEmployee(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с ID " + id + " не найден"));
        return new EmployeeDto().toEmployeeDto(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(int id, EmployeeDto employeeDto) {
        Employee employee = employeeDto.toEmployee();
        employee.setId(id);
        employeeRepository.save(employee)
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с ID " + id + " не найден"));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteEmployee(int id) {
        boolean deleted = employeeRepository.deleteEmployee(id);
        if (!deleted) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeDto[] getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        EmployeeDto[] employeeDtos = new EmployeeDto[employees.size()];

        int index = 0;
        for (Employee employee : employees) {
            employeeDtos[index] = new EmployeeDto().toEmployeeDto(employee);
            index++;
        }

        return employeeDtos;
    }

}
