package employeeweb.services;

import employeeweb.dto.EmployeeDto;
import employeeweb.exceptions.EmployeeNotFoundException;
import employeeweb.repositories.DbEmployeeRepository;
import entities.Employee;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {


    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private DbEmployeeRepository dbEmployeeRepository;


    @Nested
    public class AddEmployee {

        @Test
        public void shouldAddEmployeeWhenValidData() throws SQLException {
            EmployeeDto employeeDto = new EmployeeDto("John", "Doe",
                    "5551234", "Manager", LocalDate.now(),
                    null, 50000.0);
            Employee employee = employeeDto.toEmployee();
            System.out.println(employee.toString());
            ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
            Optional<Employee> existingEmployeeOptional = Optional.of(employee);
            when(dbEmployeeRepository.save(employee)).thenReturn(existingEmployeeOptional);
            employeeService.add(employeeDto);
            verify(dbEmployeeRepository, times(1)).save(employeeCaptor.capture());

            Employee capturedEmployee = employeeCaptor.getValue();

            assertEquals("John", capturedEmployee.getName());
            assertEquals("Doe", capturedEmployee.getSurname());
            assertEquals("5551234", capturedEmployee.getPhone());
            assertEquals("Manager", capturedEmployee.getPositionEml());
            assertEquals(LocalDate.now(), capturedEmployee.getDateOfEmployment());
            assertNull(capturedEmployee.getDateOfDismissal());
            assertEquals(50000.0, capturedEmployee.getSalary(), 0.01);
        }

    }


    @Nested
    public class GetEmployee {
        @Test
        public void shouldGetEmployeeWhenValidData() throws SQLException {
            Employee sampleEmployee = new Employee(1, "John",
                    "Doe", "555-1234",
                    "Manager", LocalDate.now(), null, 50000.0);

            when(dbEmployeeRepository.findById(1)).thenReturn(Optional.of(sampleEmployee));

            EmployeeDto employeeDto = employeeService.getEmployee(1);

            assertEquals("John", employeeDto.getName());
            assertEquals("Doe", employeeDto.getSurname());
            assertEquals("555-1234", employeeDto.getPhone());
            assertEquals("Manager", employeeDto.getPositionEml());
            assertEquals(LocalDate.now(), employeeDto.getDateOfEmployment());
            assertNull(employeeDto.getDateOfDismissal());
            assertEquals(50000.0, employeeDto.getSalary(), 0.01);
        }


        @Test
        public void shouldThrowsExceptionWhenNotValidID() throws SQLException {
            when(dbEmployeeRepository.findById(any(Integer.class))).thenReturn(Optional.empty());
            assertThrows(EmployeeNotFoundException.class, () -> {
                employeeService.getEmployee(1);
            });

        }
    }


    @Nested
    public class UpdateEmployee {

        public void shouldUpdateEmployeeWhenValidId() throws SQLException {
            int id = 1;
            EmployeeDto validEmployeeDto = new EmployeeDto();
            Employee existingEmployee = new Employee();

            when(dbEmployeeRepository.save(any(Employee.class))).thenReturn(Optional.of(existingEmployee));

            employeeService.update(id, validEmployeeDto);

            Mockito.verify(dbEmployeeRepository, Mockito.times(1)).save(any(Employee.class));

        }


        @Test
        public void shouldThrowsExceptionWhenInvalidId() throws SQLException {

            when(dbEmployeeRepository.findById(any(Integer.class))).thenReturn(Optional.empty());

            assertThrows(EmployeeNotFoundException.class, () -> {
                employeeService.getEmployee(1);
            });
        }
    }

    @Nested
    public class Delete {
        @Test
        public void shouldDeleteEmployeeWhenValidId() throws SQLException {
            int id = 1;

            when(dbEmployeeRepository.deleteEmployee(id)).thenReturn(true);

            employeeService.deleteEmployee(id);

            verify(dbEmployeeRepository, times(1)).deleteEmployee(id);
        }

        @Test
        public void shouldDeleteEmployeeWhenInvalidId() throws SQLException {
            int id = 2;
            when(dbEmployeeRepository.deleteEmployee(id)).thenReturn(false);

            assertThrows(EmployeeNotFoundException.class, () -> {
                employeeService.deleteEmployee(id);
            });

            verify(dbEmployeeRepository, times(1)).deleteEmployee(id);
        }
    }

    @Nested
    public class GetAllEmployees {
        @Test
        public void shouldGetAllEmployeesWhenValidData() throws SQLException {
            Employee employee1 = new Employee();
            Employee employee2 = new Employee();

            List<Employee> fakeEmployees = new ArrayList<>();
            fakeEmployees.add(employee1);
            fakeEmployees.add(employee2);

            when(dbEmployeeRepository.findAll()).thenReturn(fakeEmployees);


            EmployeeDto[] result = employeeService.getAllEmployees();

            assertEquals(fakeEmployees.size(), result.length);

        }
    }
}