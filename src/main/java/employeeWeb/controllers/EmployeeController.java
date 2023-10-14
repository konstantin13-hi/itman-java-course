package employeeWeb.controllers;

import employeeWeb.dto.EmployeeDto;
import employeeWeb.repositories.EmployeeRepository;
import employeeWeb.services.EmployeeService;
import employeeWeb.services.EmployeeServiceImpl;
import entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

import static java.lang.Thread.sleep;


@RestController
public class EmployeeController {

    private final EmployeeService employeeService;



    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/api/employees")
    public void addEmployee(@RequestBody final EmployeeDto employee) throws SQLException, InterruptedException {




        employeeService.addEmployee(employee);
    }
    @PutMapping("/api/employees/{id}")
    public void updateEmployee(@PathVariable int id,
                               @RequestBody EmployeeDto employee) {

         employeeService.updateEmployee(id,employee);


    }

    @DeleteMapping("/api/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);

    }

    @GetMapping("/api/employees/{id}")
    public EmployeeDto getEmployee(@PathVariable int id){
       return employeeService.getEmployee(id);


    }


    @GetMapping("/api/employees")
    public EmployeeDto[] getAllEmployees() throws SQLException {
        return employeeService.getAllEmployees();

    }


}
