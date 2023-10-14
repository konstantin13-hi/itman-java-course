package employeeWeb.dto;

import entities.Employee;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeDto {

    private String name;
    private String surname;
    private String phone;
    private String positionEml;
    private LocalDate dateOfEmployment;
    private LocalDate dateOfDismissal;
    private Double salary;

    public EmployeeDto() {
    }


    public EmployeeDto(String name, String surname, String phone,
                       String positionEml, LocalDate dateOfEmployment,
                       LocalDate dateOfDismissal, Double salary) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.positionEml = positionEml;
        this.dateOfEmployment = dateOfEmployment;
        this.dateOfDismissal = dateOfDismissal;
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPositionEml(String positionEml) {
        this.positionEml = positionEml;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }


    public void setDateOfDismissal(LocalDate dateOfDismissal) {
        this.dateOfDismissal = dateOfDismissal;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPositionEml() {
        return positionEml;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public LocalDate getDateOfDismissal() {
        return dateOfDismissal;
    }

    public Double getSalary() {
        return salary;
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

    public Employee toEmployee(){
        return new Employee(getName(),
                getSurname(),getPhone()
                ,getPositionEml(),
                getDateOfEmployment(),
                getDateOfEmployment()
                ,getSalary());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(phone, that.phone) && Objects.equals(positionEml, that.positionEml) && Objects.equals(dateOfEmployment, that.dateOfEmployment) && Objects.equals(dateOfDismissal, that.dateOfDismissal) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phone, positionEml, dateOfEmployment, dateOfDismissal, salary);
    }
}
