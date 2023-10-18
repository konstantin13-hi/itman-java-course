package employeeweb.repositories;

import entities.Employee;
import org.springframework.stereotype.Repository;
import tasks.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class DbEmployeeRepository implements EmployeeRepository {


    /**
     * Looks for an employee by the specified ID.
     *
     * @param id ID of the employee to be found.
     * @return An object of type Employee that represents the employee with the specified ID.
     * If the employee is not found, null is returned.
     * @cpu O(n)  where n is the length of the employees list.
     * @ram O(1)
     */
    public Optional<Employee> findById(int id) throws SQLException {
        if (id < 1) {
            throw new IllegalArgumentException("Id should be more than 0");
        }
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                List<Employee> filteredEmployees = getFilteredEmployees(statement);
                if (!filteredEmployees.isEmpty()) {
                    return Optional.of(filteredEmployees.get(0));
                }
            } catch (SQLException e) {
                throw new SQLException("Ошибка при выполнении SQL-запроса", e);
            }
        } catch (SQLException e) {
            throw new SQLException("Ошибка при подключении к базе данных", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employee> add(Employee employee) throws SQLException {
        return save(employee);
    }

    @Override
    public Optional<Employee> update(Employee employee) throws SQLException {
        return save(employee);
    }

    @Override
    public Optional<Employee> getEmployee(int id) throws SQLException {
        return findById(id);
    }

    /**
     * Deletes an employee with the specified ID from the database.
     *
     * @param id The ID of the employee to be deleted.
     * @return {@code true} if the employee was successfully deleted, or {@code false} if the employee was not found.
     * @throws IllegalArgumentException If the provided ID is less than 1.
     */
    public boolean deleteEmployee(int id) throws SQLException {
        if (id < 1) {
            throw new IllegalArgumentException("Id should be more than 0");
        }
        boolean result = true;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM employee WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                int deletedRows = statement.executeUpdate();

                if (deletedRows == 0) {
                    result = false;
                }
            } catch (SQLException e) {
                throw new SQLException("Error executing SQL query", e);
            }
        } catch (SQLException e) {
            throw new SQLException("Error connecting to the database", e);
        }
        return result;
    }


    /**
     * Retrieves a list of all employees.
     *
     * @return A List of Employee objects representing all employees in the database.
     * @cpu O(1)
     * @ram O(n) where n is the number of employees in the list.
     */
    public List<Employee> findAll() throws SQLException {
        List<Employee> employeeList = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM employee";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                employeeList = getFilteredEmployees(preparedStatement);
            } catch (SQLException e) {
                throw new SQLException("Ошибка при выполнении SQL-запроса", e);
            }
        } catch (SQLException e) {
            throw new SQLException("Ошибка при подключении к базе данных", e);
        }
        return employeeList;
    }

    /**
     * Searches for employees with a specific position.
     *
     * @param position The position to search for.
     * @return A List of Employee objects representing employees with the specified position.
     * @cpu O(n), where n is the length of the employees list.
     * @ram O(n). where n is the length of the employees list.
     */
    public List<Employee> findByPosition(String position) throws SQLException {
        if (position == null || position.isEmpty()) {
            throw new IllegalArgumentException("Поле 'position' не должно быть пустым или равным null");
        }
        List<Employee> employeeList;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sqlQuery = "SELECT * FROM employee WHERE position_eml = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, position);
            employeeList = getFilteredEmployees(preparedStatement);
        } catch (SQLException e) {
            throw new SQLException("Ошибка при подключении к базе данных", e);
        }
        return employeeList;
    }

    private List<Employee> getFilteredEmployees(PreparedStatement preparedStatement) throws SQLException {
        final List<Employee> employeesList = new LinkedList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("name");
            String lastName = resultSet.getString("surname");
            String phone = resultSet.getString("phone");
            String position = resultSet.getString("position_eml");
            LocalDate dateOfEmployment = getDateFromResulSet(resultSet, "date_of_employment");
            LocalDate dateOfDismissal = getDateFromResulSet(resultSet, "date_of_dismissal");
            Object salaryObject = resultSet.getObject("salary");
            Double salary = (salaryObject == null) ? null : ((Number) salaryObject).doubleValue();
            Employee employee = new Employee(id, firstName, lastName, phone,
                    position, dateOfEmployment, dateOfDismissal, salary);
            employeesList.add(employee);
        }

        return employeesList;

    }

    /**
     * Saves or updates an Employee record in the database.
     *
     * @param employee The Employee object to be saved or updated.
     * @return The newly saved Employee object with its updated properties,
     * including the assigned ID (if it's a new record).
     */
    public Optional<Employee> save(Employee employee) throws SQLException {
        if (employee.getName() == null || employee.getName().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty.");
        }

        if (employee.getSurname() == null || employee.getSurname().isEmpty()) {
            throw new IllegalArgumentException("Employee surname cannot be empty.");
        }

        if (employee.getPositionEml() == null || employee.getPositionEml().isEmpty()) {
            throw new IllegalArgumentException("Employee position cannot be empty.");
        }
        if (employee.getSalary() != null && (employee.getSalary() < 0.0 || employee.getSalary() > 9999999.99)) {
            throw new IllegalArgumentException("Employee's salary must be in the range from 0.00 to 9,999,999.99.");
        }

        if (employee.getDateOfEmployment() != null) {
            LocalDate dateOfEmployment = employee.getDateOfEmployment();
            LocalDate currentDate = LocalDate.now();

            if (dateOfEmployment.isAfter(currentDate)) {
                throw new IllegalArgumentException("Date of employment cannot be in the future.");
            }
        }
        if (employee.getDateOfDismissal() != null) {
            LocalDate dateOfDismissal = employee.getDateOfDismissal();
            LocalDate currentDate = LocalDate.now();

            if (dateOfDismissal.isAfter(currentDate)) {
                throw new IllegalArgumentException("Date of dismissal cannot be in the future.");
            }

            if (employee.getDateOfEmployment() != null && dateOfDismissal.isBefore(employee.getDateOfEmployment())) {
                throw new IllegalArgumentException("Date of dismissal cannot be earlier than date of employment.");
            }
        }

        int id = 0;
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (employee.getId() == null) {
                StringBuilder insertCommandBuilder = new StringBuilder("INSERT INTO employee " +
                        "(name, surname, phone, position_eml");
                StringBuilder valuesBuilder = new StringBuilder(" VALUES (?, ?, ?, ?");
                if (employee.getDateOfEmployment() != null) {
                    insertCommandBuilder.append(", date_of_employment");
                    valuesBuilder.append(", ?");
                }
                insertCommandBuilder.append(", date_of_dismissal, salary)");
                valuesBuilder.append(", ?, ?)");
                insertCommandBuilder.append(valuesBuilder);
                String insertCommand = insertCommandBuilder.toString();
                id = statement(employee, connection, insertCommand);
            } else {
                String updateCommand = "UPDATE employee set name =? ," +
                        "surname=?,phone=?,position_eml=?,date_of_employment=?,date_of_dismissal=?,salary =? " +
                        "WHERE id = ? ";
                id = statement(employee, connection, updateCommand);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findById(id);
    }

    private int statement(Employee employee, Connection connection, String updateCommand) throws SQLException {
        PreparedStatement preparedStatement;
        if (employee.getId() == null) {
            preparedStatement = connection.prepareStatement(updateCommand, Statement.RETURN_GENERATED_KEYS);
        } else {
            preparedStatement = connection.prepareStatement(updateCommand);
        }

        int parameterIndex = 1;
        preparedStatement.setString(parameterIndex++, employee.getName()); // name
        preparedStatement.setString(parameterIndex++, employee.getSurname()); // surname
        preparedStatement.setString(parameterIndex++, employee.getPhone()); // position_eml
        preparedStatement.setString(parameterIndex++, employee.getPositionEml()); // phone
        if (employee.getDateOfEmployment() != null) {
            preparedStatement.setDate(parameterIndex++, Date.valueOf(employee.getDateOfEmployment()));
        }

        if (employee.getDateOfDismissal() != null) {
            preparedStatement.setDate(parameterIndex++, Date.valueOf(employee.getDateOfDismissal()));
        } else {
            preparedStatement.setNull(parameterIndex++, java.sql.Types.DATE);
        }

        if (employee.getSalary() != null) {
            preparedStatement.setDouble(parameterIndex++, employee.getSalary());
        } else {
            preparedStatement.setNull(parameterIndex++, java.sql.Types.DOUBLE);
        }

        if (employee.getId() != null) {
            preparedStatement.setInt(parameterIndex++, employee.getId());
        }

        int generatedId = -1;
        int updatedRows = preparedStatement.executeUpdate();

        if (employee.getId() == null) {
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                }
            }
        } else {
            generatedId = employee.getId();
        }

        return generatedId;
    }

    private LocalDate getDateFromResulSet(ResultSet resultSet, String columnName) throws SQLException {
        Date dateSql = resultSet.getDate(columnName);
        return dateSql != null ? dateSql.toLocalDate() : null;
    }




}
