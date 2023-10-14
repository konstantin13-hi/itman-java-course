package employeeWeb.services;

import employeeWeb.dto.EmployeeDto;
import employeeWeb.repositories.DbEmployeeRepository;
import entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   private DbEmployeeRepository employeeRepository;



    @Autowired
    public EmployeeServiceImpl(DbEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void addEmployee(EmployeeDto employee) throws SQLException {


//      employeeRepository.save(employee);


    }

    @Override
    public void updateEmployee(int id, EmployeeDto employee) {

    }

    @Override
    public void deleteEmployee(int id) {

    }

 @Override
 public EmployeeDto getEmployee(int id) {
  return null;
 }

 @Override
 public EmployeeDto[] getAllEmployees() throws SQLException {
  return null;
 }


//    @Override
//    public EmployeeDto[] getAllEmployees() throws SQLException {
//     List<Employee> list = employeeRepository.findAll();
//     EmployeeDto[] employeeDtos = new EmployeeDto[list.size()];
//     for (int i=0;i<list.size();i++){
//      employeeDtos[i] = new EmployeeDto(list.get(i).getName(),
//              list.get(i).getSurname(),
//              list.get(i).getPhone(),list.get(i).getPositionEml(),list.get(i).getDateOfEmployment(),
//              list.get(i).getDateOfDismissal(),list.get(i).getSalary());
//
//     }
//     return employeeDtos;
//    }

}
