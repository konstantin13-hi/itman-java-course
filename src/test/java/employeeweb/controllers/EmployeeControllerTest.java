package employeeweb.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import employeeweb.dto.EmployeeDto;
import employeeweb.services.EmployeeService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
    public class GetEmployee {

        @Test
        public void shouldReturnEmployeeWith200StatusWhenGetEmployee() throws Exception {
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

            ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);

            when(employeeService.getEmployee(1)).thenReturn(employee);

            MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.get("/api/employees/{id}", 1);

            mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(employee)));

            verify(employeeService).getEmployee(idCaptor.capture());
            assertEquals(1, idCaptor.getValue().intValue());
        }



    }

    @Nested
    public class AddEmployee {

        @Test
        public void shouldAddEmployeeWhenValidData() throws Exception {
            EmployeeDto employee = new EmployeeDto("John",
                    "Doe", "123456789",
                    "Manager", LocalDate.of(2012, 5, 5),
                    null, 50000.0);

            ArgumentCaptor<EmployeeDto> employeeCaptor = ArgumentCaptor.forClass(EmployeeDto.class);

            doNothing().when(employeeService).add(employeeCaptor.capture());

            mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
                            .content(objectMapper.writeValueAsString(employee))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk());

            EmployeeDto capturedEmployee = employeeCaptor.getValue();
            assertEquals(employee, capturedEmployee);

        }




        @Test
        public void shouldReturnBadRequestWhenInvalidData() throws Exception {
            EmployeeDto invalidEmployee = new EmployeeDto();
            invalidEmployee.setName("");
            invalidEmployee.setSurname("");
            invalidEmployee.setPhone("123g");
            invalidEmployee.setPositionEml("");
            invalidEmployee.setDateOfEmployment(LocalDate.now());
            invalidEmployee.setDateOfDismissal(LocalDate.now());
            invalidEmployee.setSalary(-100.0);

            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(invalidEmployee)))
                    .andExpect(status().isBadRequest())
                    .andReturn();


            String responseBody = result.getResponse().getContentAsString();
            System.out.println("Тело ответа: " + responseBody);
        }


    }


    @Nested
    public class UpdateEmployee {
        @Test
        public void shouldUpdateEmployeeWhenValidData() throws Exception {

            EmployeeDto updatedEmployee = new EmployeeDto("John",
                    "Doe", "123456789", "Manager",
                    LocalDate.of(2012, 5, 5), null, 50000.0);


            doNothing().when(employeeService).update(eq(1), eq(updatedEmployee));

            mockMvc.perform(MockMvcRequestBuilders.put("/api/employees/{id}", 1)
                            .content(objectMapper.writeValueAsString(updatedEmployee))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }
    }


    @Nested
    public class DeleteEmployee {
        @Test
        public void shouldDeleteEmployeeWhenValid() throws Exception {
            // Устанавливаем заглушку для метода deleteEmployee
            doNothing().when(employeeService).deleteEmployee(eq(1));

            mockMvc.perform(MockMvcRequestBuilders.delete("/api/employees/{id}", 1))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }
    }

    @Nested
    public class GetAllEmployee {
        @Test
        public void shouldGetAllEmployeesWhenValidData() throws Exception {
            EmployeeDto[] employees = new EmployeeDto[]{
                    new EmployeeDto("John",
                            "Doe", "123456789",
                            "Manager", LocalDate.now(), null, 50000.0),
                    new EmployeeDto("Jane",
                            "Smith", "987654321",
                            "Engineer", LocalDate.now(), null, 60000.0)
            };

            when(employeeService.getAllEmployees()).thenReturn(employees);

            mockMvc.perform(MockMvcRequestBuilders.get("/api/employees")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(employees)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
        }
    }
}