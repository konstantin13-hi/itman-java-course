package employeeWeb.dto;

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
