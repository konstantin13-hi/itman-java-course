package employeeweb.repositories;


import employeeweb.repositories.DbEmployeeRepository;
import entities.Employee;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import tasks.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeRepositoryTest {
    private static Connection connection;
    private final DbEmployeeRepository employeeRepository = new DbEmployeeRepository();
    private int idForAdding = returnsEmployeesData().size() + 1;

    @BeforeAll
    private static void openConnection() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }

    @AfterAll
    private static void closeConnection() throws SQLException {
        connection.close();
    }

    @BeforeEach
    public void shouldSetUpDatabaseWhenRunTests() throws SQLException {
        final String dropTableSql = "DROP TABLE IF EXISTS employee;";
        final String createTableSql = "CREATE TABLE IF NOT EXISTS employee(id serial PRIMARY key,\n" +
                "                      name VARCHAR (50) not null,\n" +
                "                       surname VARCHAR (50) not null,\n" +
                "                       phone VARCHAR (15),\n" +
                "                       position_eml VARCHAR (50) not null,\n" +
                "                        date_of_employment DATE NOT NULL DEFAULT CURRENT_DATE,\n" +
                "                        date_of_dismissal DATE ,\n" +
                "                       salary NUMERIC(10, 2));";

        Statement statement = connection.createStatement();
        statement.execute(dropTableSql);
        statement.execute(createTableSql);


    }


    @BeforeEach
    private void shouldInitializeDatabaseWhenRunTests() throws SQLException {
        insertInitialData();
    }


    private static void insertInitialData() throws SQLException {
        String insertCommand =
                "INSERT INTO employee (name, surname, phone, position_eml, " +
                        "date_of_employment, date_of_dismissal, salary) " +
                        "VALUES " +
                        "('John', 'Doe', '555-1234', 'Manager', '2023-01-15', NULL, 50000.0), " +
                        "('Jane', 'Smith', '555-5678', 'Developer', '2022-08-20', NULL, 60000.0), " +
                        "('Alice', 'Johnson', '555-9876', 'Designer', '2023-03-10', NULL, 45000.0), " +
                        "('Michael', 'Brown', '555-3456', 'Designer', '2022-11-05', NULL, 55000.0), " +
                        "('Emily', 'Williams', '555-7890', 'Developer', '2023-02-28', NULL, 52000.0), " +
                        "('Robert', 'Jones', '555-2345', 'Developer', '2023-04-18', NULL, 48000.0), " +
                        "('Sophia', 'Miller', '555-6543', 'Accountant', '2022-09-10', NULL, 51000.0), " +
                        "('Daniel', 'Wilson', '555-8765', 'Designer', '2022-12-22', NULL, 59000.0), " +
                        "('Olivia', 'Taylor', '555-4321', 'Marketing Specialist', '2023-05-09', NULL, 47000.0), " +
                        "('William', 'Anderson', '555-8901', 'IT Specialist', '2022-07-12', NULL, 63000.0);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertCommand)) {
            preparedStatement.execute();
        }

    }


    @Nested
    public class FindById {
        @Test
        public void shouldFindByIdWhenValidIdProvided() throws SQLException {
            Employee expected = new Employee(1, "John", "Doe",
                    "555-1234", "Manager", LocalDate.parse("2023-01-15"), null, 50000.00);
            Optional<Employee> employee = employeeRepository.findById(1);
            Employee expectedEmployee = employee.orElse(null);
            assertEquals(expected, expectedEmployee);
        }

    }

    @Nested
    public class FindAll {
        @Test
        void findAll() throws SQLException {
            List<Employee> expected = returnsEmployeesData();

            List<Employee> actual = employeeRepository.findAll();
            assertEquals(expected.size(), actual.size());
            for (int i = 0; i < actual.size(); i++) {
                assertEquals(expected.get(i).toString(), actual.get(i).toString());
            }
        }
    }

    @Nested
    public class FindByPosition {

        @Test
        void shouldFindByPositionWhenValidArgument() throws SQLException {
            String position = "Manager";
            List<Employee> actual = employeeRepository.findByPosition(position);
            List<Employee> expected = returnsFilteredEmployeesByPosition(returnsEmployeesData(), position);
            for (int i = 0; i < actual.size(); i++) {
                assertEquals(expected.get(i).toString(), actual.get(i).toString());
            }
        }

        @Test
        public void shouldFindByPositionWhenNullPosition() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                employeeRepository.findByPosition(null);
            });
        }

        @Test
        public void shouldFindByPositionWhenEmptyPosition() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                employeeRepository.findByPosition("");
            });
        }
    }

    @Nested
    public class Save {
        @Test
        void saveEmployeeWithAllData() throws SQLException {
            Employee newEmployee = new Employee();
            newEmployee.setName("John");
            newEmployee.setSurname("Doe");
            newEmployee.setPhone("555-1234");
            newEmployee.setPositionEml("Manager");
            newEmployee.setDateOfEmployment(LocalDate.parse("2023-01-15"));
            newEmployee.setSalary(50000.0);
            Optional<Employee> employee = employeeRepository.save(newEmployee);
            newEmployee.setId(idForAdding);
            Employee expectedEmployee = employee.orElse(null);
            assert expectedEmployee != null;
            assertEquals(newEmployee.toString(), expectedEmployee.toString());
        }

        @Test
        void saveEmployeeWithMinimalData() throws SQLException {
            Employee newEmployee = new Employee();
            newEmployee.setName("Jane");
            newEmployee.setSurname("Smith");
            newEmployee.setPositionEml("Developer");
            Optional<Employee> employee = employeeRepository.save(newEmployee);
            newEmployee.setId(idForAdding);
            newEmployee.setDateOfEmployment(LocalDate.now());
            Employee expectedEmployee = employee.orElse(null);
            assert expectedEmployee != null;
            assertEquals(newEmployee.toString(), expectedEmployee.toString());
        }

        @Test
        void saveEmployeeWithDismissalDateAndNullSalary() throws SQLException {
            Employee newEmployee = new Employee();
            newEmployee.setName("Alice");
            newEmployee.setSurname("Johnson");
            newEmployee.setPositionEml("Designer");
            newEmployee.setDateOfEmployment(LocalDate.parse("2023-03-10"));
            newEmployee.setDateOfDismissal(LocalDate.parse("2023-06-15"));
            newEmployee.setSalary(null);
            Optional<Employee> employee = employeeRepository.save(newEmployee);
            newEmployee.setId(idForAdding);
            Employee expectedEmployee = employee.orElse(null);
            assert expectedEmployee != null;
            assertEquals(newEmployee.toString(), expectedEmployee.toString());
        }


    }

    @Nested
    public class Update {
        @Test
        void shouldThrowExceptionWhenNameIsNull() {
            Employee employee = new Employee(null, null,
                    "Surname", "Position", null, null, null, 1000.0);
            IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> employeeRepository.save(employee));
            assertEquals("Employee name cannot be empty.", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenSurnameIsNull() {
            Employee employee = new Employee(null, "Name",
                    null, "Position", null, null, null, 1000.0);
            IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> employeeRepository.save(employee));
            assertEquals("Employee surname cannot be empty.", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenPositionIsNull() {
            Employee employee = new Employee(null, "Name",
                    "Surname", null, null, null, null, 1000.0);
            IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> employeeRepository.save(employee));
            assertEquals("Employee position cannot be empty.", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenSalaryIsInvalid() {
            Employee employee = new Employee(null, "Name",
                    "Surname", null, "Position", null, null, -1000.0);
            IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> employeeRepository.save(employee));
            assertEquals("Employee's salary must be in the range from 0.00 to 9,999,999.99.", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenDateOfEmploymentIsInFuture() {
            Employee employee = new Employee("Name", "Surname",
                    null, "Position", LocalDate.parse("2030-01-01"), null, 1000.0);
            IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> employeeRepository.save(employee));
            assertEquals("Date of employment cannot be in the future.", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenDateOfDismissalIsBeforeDateOfEmployment() {
            Employee employee = new Employee("Name", "Surname",
                    null, "Position", LocalDate.parse("2023-01-01"), LocalDate.parse("2022-12-31"), 1000.0);
            IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> employeeRepository.save(employee));
            assertEquals("Date of dismissal cannot be earlier than date of employment.", exception.getMessage());
        }


        @Test
        void shouldUpdateEmployeeWithNewDataPhone() throws SQLException {
            Employee newEmployee = new Employee(1, "John",
                    "Doe", "6-54445-444", "Manager",
                    LocalDate.parse("2023-01-15"), null, 50000.0);
            Optional<Employee> employee = employeeRepository.save(newEmployee);
            Employee expectedEmployee = employee.orElse(null);
            assert expectedEmployee != null;
            assertEquals(newEmployee.toString(), expectedEmployee.toString());


        }

        @Test
        void shouldUpdateEmployeeWithDifferentDate() throws SQLException {
            Employee newEmployee = new Employee(1, "brad",
                    "Dav", "6-54445-444", "It-CON",
                    LocalDate.parse("2023-01-15"), LocalDate.now(), 150000.0);
            Optional<Employee> employee = employeeRepository.save(newEmployee);
            Employee expectedEmployee = employee.orElse(null);
            assert expectedEmployee != null;
            assertEquals(newEmployee.toString(), expectedEmployee.toString());


        }

        @Test
        void shouldUpdateEmployeeWithNullDate() throws SQLException {
            Employee newEmployee = new Employee(1, "John",
                    "Doe", null, "Manager",
                    LocalDate.parse("2023-01-15"), null, null);
            Optional<Employee> employee = employeeRepository.save(newEmployee);
            Employee expectedEmployee = employee.orElse(null);
            assert expectedEmployee != null;
            assertEquals(newEmployee.toString(), expectedEmployee.toString());

        }

    }


    private static List<Employee> returnsEmployeesData() {
        Employee[] employeesArray = new Employee[]{
                new Employee(1, "John", "Doe", "555-1234",
                        "Manager", LocalDate.parse("2023-01-15"), null, 50000.0),
                new Employee(2, "Jane", "Smith", "555-5678",
                        "Developer", LocalDate.parse("2022-08-20"), null, 60000.0),
                new Employee(3, "Alice", "Johnson", "555-9876",
                        "Designer", LocalDate.parse("2023-03-10"), null, 45000.0),
                new Employee(4, "Michael", "Brown", "555-3456",
                        "Designer", LocalDate.parse("2022-11-05"), null, 55000.0),
                new Employee(5, "Emily", "Williams", "555-7890",
                        "Developer", LocalDate.parse("2023-02-28"), null, 52000.0),
                new Employee(6, "Robert", "Jones", "555-2345",
                        "Developer", LocalDate.parse("2023-04-18"), null, 48000.0),
                new Employee(7, "Sophia", "Miller", "555-6543",
                        "Accountant", LocalDate.parse("2022-09-10"), null, 51000.0),
                new Employee(8, "Daniel", "Wilson", "555-8765",
                        "Designer", LocalDate.parse("2022-12-22"), null, 59000.0),
                new Employee(9, "Olivia", "Taylor", "555-4321",
                        "Marketing Specialist", LocalDate.parse("2023-05-09"), null, 47000.0),
                new Employee(10, "William", "Anderson", "555-8901",
                        "IT Specialist", LocalDate.parse("2022-07-12"), null, 63000.0),

        };

        return new ArrayList<>(List.of(employeesArray));
    }


    private List<Employee> returnsFilteredEmployeesByPosition(List<Employee> allEmployees, String position) {
        return allEmployees.stream()
                .filter(employee -> employee.getPositionEml().equals(position)) // Фильтр по должности
                .collect(Collectors.toList());
    }


}