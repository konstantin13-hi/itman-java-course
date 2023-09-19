package tasks;

import entities.Employee;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateTest {


    private static Connection connection;
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @BeforeAll
    private static void openConnection() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }

    @AfterAll
    private static void closeConnection() throws SQLException {
        connection.close();
    }

    @BeforeEach
    private void shouldSetUpDatabaseWhenRunTests() throws SQLException {
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

        String insertCommand = "INSERT INTO employee(name, surname,phone," +
                "position_eml, date_of_employment, date_of_dismissal, salary) VALUES (?, ?, ?, ?, ?, ?, ?)";
        List<Employee> employeesData = returnsEmployeesData();


        try (PreparedStatement statement = connection.prepareStatement(insertCommand)) {
            for (Employee employeeData : employeesData) {
                statement.setString(1, employeeData.getName()); // name
                statement.setString(2, employeeData.getSurname()); // surname
                statement.setString(3, employeeData.getPhone()); // phone
                statement.setString(4, employeeData.getPositionEml()); // position
                if (employeeData.getDateOfEmployment() != null) {
                    statement.setDate(5, java.sql.Date.valueOf(employeeData.getDateOfEmployment()));
                } else {
                    statement.setNull(5, Types.DATE);
                }
                if (employeeData.getDateOfDismissal() != null) {
                    statement.setDate(6, java.sql.Date.valueOf(employeeData.getDateOfDismissal()));
                } else {
                    statement.setNull(6, Types.DATE);
                }
                statement.setDouble(7, employeeData.getSalary()); // salary

                statement.addBatch();
            }
            statement.executeBatch();
        }

    }


    @Nested
    public class Save {
        @org.junit.jupiter.api.Test
        void save2() throws SQLException {

            Employee newEmployee = new Employee();
            newEmployee.setName("Jon");
            newEmployee.setSurname("Bon");
            newEmployee.setPositionEml("DADSAD");
            newEmployee.setDateOfEmployment(LocalDate.now());


            Employee employee = employeeRepository.save(newEmployee);
            newEmployee.setId(11);

            Assertions.assertEquals(newEmployee.toString(), employee.toString());
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
                        "IT Specialist", LocalDate.parse("2022-07-12"), null, 63000.0)
        };

        return new ArrayList<>(Arrays.asList(employeesArray));
    }


    private List<Employee> returnsfilteredEmployeesByPosition(List<Employee> allEmployees, String position) {
        return allEmployees.stream()
                .filter(employee -> employee.getPositionEml().equals(position)) // Фильтр по должности
                .collect(Collectors.toList());
    }


}
