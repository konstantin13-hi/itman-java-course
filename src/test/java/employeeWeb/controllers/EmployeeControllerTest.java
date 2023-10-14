package employeeWeb.controllers;
import org.junit.jupiter.api.Nested;
import org.mockito.ArgumentCaptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import employeeWeb.dto.EmployeeDto;
import employeeWeb.services.EmployeeService;
import entities.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc
class EmployeeControllerTest {





    @Autowired
  private MockMvc mockMvc;




    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;


@Nested
public class GetEmployee{

    @Test
    public void shouldReturnEmployeeWith200StatusWhenGetEmployee() throws Exception {
        EmployeeDto employee = new EmployeeDto(
                "John",
                "Doe",
                "123456789",
                "Manager",
                LocalDate.of(2023, 10, 9),
                null,
                50000.0
        );

        when(employeeService.getEmployee(1)).thenReturn(employee);
        String employeeJson = objectMapper.writeValueAsString(employee);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/employees/{id}", 1);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(employeeJson));
    }


    @Test
    public void testGetEmployee() throws Exception {
        // Создаем тестового сотрудника
        EmployeeDto employee = new EmployeeDto(
                "John",
                "Doe",
                "123456789",
                "Manager",
                LocalDate.of(2023, 10, 9),
                null,
                50000.0
        );

        // Захватываем аргумент, переданный в метод getEmployee
        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);

        // Заглушка для метода getEmployee
        when(employeeService.getEmployee(1)).thenReturn(employee);

        // Выполняем GET-запрос для получения сотрудника по идентификатору
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/employees/{id}", 1);

        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(employee)));

        // Проверка, что метод getEmployee вызывается с правильным аргументом
        verify(employeeService).getEmployee(idCaptor.capture());
        assertEquals(1, idCaptor.getValue().intValue());
    }

}

 @Nested
 public class AddEmployee{
     @Test
     public void testAddEmployee() throws Exception {
         // Создаем тестового сотрудника
         EmployeeDto employee = new EmployeeDto("John", "Doe", "123456789", "Manager", LocalDate.now(), null, 50000.0);

         // Захватываем аргумент, переданный в метод addEmployee
         ArgumentCaptor<EmployeeDto> employeeCaptor = ArgumentCaptor.forClass(EmployeeDto.class);

         // Заглушка для метода addEmployee
         doNothing().when(employeeService).addEmployee(employeeCaptor.capture());

         mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
                         .content(objectMapper.writeValueAsString(employee))
                         .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(MockMvcResultMatchers.status().isOk());

         // Проверка, что метод addEmployee вызывается с правильными аргументами
         EmployeeDto capturedEmployee = employeeCaptor.getValue();
         assertEquals(employee, capturedEmployee);
     }

 }

 @Nested
 public class UpdateEmployee{
     @Test
     public void testUpdateEmployee() throws Exception {
         // Создаем тестового сотрудника для обновления
         EmployeeDto updatedEmployee = new EmployeeDto("John", "Doe", "123456789", "Manager", LocalDate.now(), null, 50000.0);

         // Устанавливаем заглушку для метода updateEmployee
         doNothing().when(employeeService).updateEmployee(eq(1), eq(updatedEmployee));

         mockMvc.perform(MockMvcRequestBuilders.put("/api/employees/{id}", 1)
                         .content(objectMapper.writeValueAsString(updatedEmployee))
                         .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(MockMvcResultMatchers.status().isOk());
     }
 }


 @Nested
 public class DeleteEmployee{
     @Test
     public void testDeleteEmployee() throws Exception {
         // Устанавливаем заглушку для метода deleteEmployee
         doNothing().when(employeeService).deleteEmployee(eq(1));

         mockMvc.perform(MockMvcRequestBuilders.delete("/api/employees/{id}", 1))
                 .andExpect(MockMvcResultMatchers.status().isOk());
     }
 }

 @Nested
 public class GetAllEmployee{
     @Test
     public void testGetAllEmployees() throws Exception {
         // Создаем массив тестовых сотрудников
         EmployeeDto[] employees = new EmployeeDto[] {
                 new EmployeeDto("John", "Doe", "123456789", "Manager", LocalDate.now(), null, 50000.0),
                 new EmployeeDto("Jane", "Smith", "987654321", "Engineer", LocalDate.now(), null, 60000.0)
         };

         // Устанавливаем заглушку для метода getAllEmployees
         when(employeeService.getAllEmployees()).thenReturn(employees);

         mockMvc.perform(MockMvcRequestBuilders.get("/api/employees")
                         .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(employees)))
                 .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2))); // Проверяем, что возвращено 2 сотрудника
     }
 }





//
//    @Test
//    public void shouldGetEmployee() throws Exception {
//        EmployeeDto employee = new EmployeeDto(
//                "John",
//                "Doe",
//                "123456789",
//                "Manager",
//                LocalDate.of(2023, 10, 9),
//                null,
//                50000.0
//        );
//
//        Mockito.when(employeeService.getEmployee(1)).thenReturn(employee);
//
//        String employeeJson = objectMapper.writeValueAsString(employee);
//
//        final MockHttpServletRequestBuilder request =
//                MockMvcRequestBuilders.get("/api/employees/{id}", 1);
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(employeeJson));
//    }
//
//    @Test
//    public void shouldAddEmployee() throws Exception {
//        Employee employee = new Employee(
//                "John",
//                "Doe",
//                "123456789",
//                "Manager",
//                LocalDate.of(2023, 10, 9),
//                null,
//                50000.0
//        );
//
//        doNothing().when(employeeService).addEmployee(eq(employee));
//        final MockHttpServletRequestBuilder request =
//                MockMvcRequestBuilders.post("/api/employees")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(employee));
//        final var result = this.mockMvc.perform(request);
//        result.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(""));
//        verify(employeeService, times(1)).addEmployee(eq(employee));
//    }


//    @Test
//    public void testAddEmployee() throws Exception {
//        // Создаем тестового сотрудника
//        EmployeeDto employee = new EmployeeDto(
//                "John",
//                "Doe",
//                "123456789",
//                "Manager",
//                LocalDate.of(2023, 10, 9),
//                null,
//                50000.0
//        );
//        // Заглушка для метода addEmployee
//        doNothing().when(employeeService).addEmployee(eq(employee));
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
//                        .content(objectMapper.writeValueAsString(employee))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        // Проверка, что метод addEmployee вызывается с правильными аргументами
//        verify(employeeService, times(1)).addEmployee(eq(employee));
//    }




    // Преобразование объекта в JSON строку
    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//
//    @Test
//    public void shouldUpdateEmployee() throws Exception {
//        EmployeeDto employee = new EmployeeDto(
//                "John",
//                "Doe",
//                "123456789",
//                "Manager",
//                LocalDate.of(2023, 10, 9),
//                null,
//                50000.0
//        );
//
//        String employeeJson = objectMapper.writeValueAsString(employee);
//
//        final MockHttpServletRequestBuilder request =
//                MockMvcRequestBuilders.put("/api/employees/{id}", 1)
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(employee));
//        final var result = this.mockMvc.perform(request);
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(""));
//        Mockito.verify(employeeService, times(1)).updateEmployee(1,new EmployeeDto(
//                "John",
//                "Doe",
//                "123456789",
//                "Manager",
//                LocalDate.of(2023, 10, 9),
//                null,
//                50000.0
//        ));
//    }
//
////    @Test
////    public void shouldDeleteEmployee() throws Exception {
////        Mockito.doNothing().when(employeeService).delete(1);
////
////        final MockHttpServletRequestBuilder request =
////                MockMvcRequestBuilders.delete("/api/employees/{id}", 1);
////
////        this.mockMvc.perform(request)
////                .andExpect(MockMvcResultMatchers.status().isOk());
////    }
////
//    @Test
//    public void shouldGetAllEmployees() throws Exception {
//        EmployeeDto[] employees = new EmployeeDto[]{
//                new EmployeeDto("John", "Doe", "123456789", "Manager", LocalDate.of(2023, 10, 9), null, 50000.0),
//                new EmployeeDto("Din", "Bi", "1289", "IT", LocalDate.of(2023, 10, 9), null, 30000.0),
//                new EmployeeDto("Alex", "Ke", "6789", "QA", LocalDate.of(2023, 10, 9), null, 20000.0),
//        };
//
//        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
//
//        String employeesJson = objectMapper.writeValueAsString(employees);
//
//        final MockHttpServletRequestBuilder request =
//                MockMvcRequestBuilders.get("/api/employees");
//
//        this.mockMvc.perform(request)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(employeesJson));
//    }
}