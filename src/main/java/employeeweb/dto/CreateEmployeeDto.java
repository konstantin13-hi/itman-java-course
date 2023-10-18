package employeeweb.dto;

import entities.Employee;

import java.time.LocalDate;

public class CreateEmployeeDto {
    private String name;
    private String surname;
    private String phone;
    private String positionEml;
    private LocalDate dateOfEmployment;
    private LocalDate dateOfDismissal;
    private Double salary;

    /**
     * Constructs a new CreateEmployeeDto object.
     */
    public CreateEmployeeDto() {

    }

    /**
     * Converts an Employee object into an EmployeeDto object.
     *
     * @param employee The Employee object to be converted.
     * @return The corresponding EmployeeDto object.
     */
    public EmployeeDto employeeDto(Employee employee) {
        return new EmployeeDto(employee.getName(), employee.getSurname(),
                employee.getPhone(), employee.getPositionEml(),
                employee.getDateOfEmployment(), employee.getDateOfDismissal(),
                employee.getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", positionEml='" + positionEml + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                ", dateOfDismissal=" + dateOfDismissal +
                ", salary=" + salary +
                '}';
    }


}
