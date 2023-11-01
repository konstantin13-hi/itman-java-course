package entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Employee {

    private Integer id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank
    @Size(min = 2, max = 50)
    private String surname;

    @Size(min = 10, max = 15)
    private String phone;

    @NotBlank
    @Size(min = 2, max = 50)
    private String positionEml;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate dateOfEmployment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate dateOfDismissal;

    @NotNull
    private Double salary;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String name, String surname,
                    String phone, String positionEml, LocalDate dateOfEmployment,
                    LocalDate dateOfDismissal, Double salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.positionEml = positionEml;
        this.dateOfEmployment = dateOfEmployment;
        this.dateOfDismissal = dateOfDismissal;
        this.salary = salary;
    }

    public Employee(String name, String surname, String phone,
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

    public void setId(int id) {
        this.id = id;
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

    public Integer getId() {
        return id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", positionEml='" + positionEml + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                ", dateOfDismissal=" + dateOfDismissal +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id)
                && Objects.equals(name, employee.name)
                && Objects.equals(surname, employee.surname)
                && Objects.equals(phone, employee.phone)
                && Objects.equals(positionEml, employee.positionEml)
                && Objects.equals(dateOfEmployment, employee.dateOfEmployment)
                && Objects.equals(dateOfDismissal, employee.dateOfDismissal)
                && Objects.equals(salary, employee.salary);
    }


}
