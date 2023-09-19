package entities;

import java.time.LocalDate;

public class Employee {

    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String positionEml;
    private LocalDate dateOfEmployment;
    private LocalDate dateOfDismissal;
    private Double salary;

    public Employee() {
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


}
