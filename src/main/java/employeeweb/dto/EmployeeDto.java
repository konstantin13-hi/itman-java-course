package employeeweb.dto;

import entities.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.*;

public class EmployeeDto {

    @NotBlank(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно содержать от 2 до 50 символов")
    private String name;

    @NotBlank(message = "Фамилия не должна быть пустой")
    @Size(min = 2, max = 50, message = "Фамилия должна содержать от 2 до 50 символов")
    private String surname;

    @NotBlank(message = "Телефон не должен быть пустым")
    @Size(min = 5, max = 15, message = "Телефон должен содержать от 5 до 15 символов")
    @Pattern(regexp = "^[0-9]+$", message = "Телефон должен содержать только цифры")
    private String phone;

    @NotBlank(message = "Должность не должна быть пустой")
    @Size(min = 2, max = 50, message = "Должность должна содержать от 2 до 50 символов")
    private String positionEml;

    @NotNull(message = "Дата приема на работу не должна быть пустой")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Дата приема на работу должна быть в прошлом")
    private LocalDate dateOfEmployment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Дата увольнения должна быть в прошлом")
    private LocalDate dateOfDismissal;

    @NotNull(message = "Зарплата не должна быть пустой")
    @Min(value = 0, message = "Зарплата не может быть отрицательной")
    private Double salary;

    /**
     * Default constructor.
     */
    public EmployeeDto() {
    }

    /**
     * Parameterized constructor to create an EmployeeDto.
     *
     * @param name The name of the employee.
     * @param surname The surname of the employee.
     * @param phone The phone number of the employee.
     * @param positionEml The job position or title of the employee.
     * @param dateOfEmployment The date of employment of the employee.
     * @param dateOfDismissal The date of dismissal (if any) of the employee.
     * @param salary The salary of the employee.
     */
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

    /**
     * Get the phone number of the employee.
     *
     * @return The phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone number of the employee.
     *
     * @param phone The phone number to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set the name of the employee.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the surname of the employee.
     *
     * @param surname The surname to set.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Set the job position or title of the employee.
     *
     * @param positionEml The job position to set.
     */
    public void setPositionEml(String positionEml) {
        this.positionEml = positionEml;
    }

    /**
     * Set the date of employment of the employee.
     *
     * @param dateOfEmployment The date of employment to set.
     */
    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    /**
     * Set the date of dismissal (if any) of the employee.
     *
     * @param dateOfDismissal The date of dismissal to set.
     */
    public void setDateOfDismissal(LocalDate dateOfDismissal) {
        this.dateOfDismissal = dateOfDismissal;
    }

    /**
     * Set the salary of the employee.
     *
     * @param salary The salary to set.
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * Get the name of the employee.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the surname of the employee.
     *
     * @return The surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Get the job position or title of the employee.
     *
     * @return The job position.
     */
    public String getPositionEml() {
        return positionEml;
    }

    /**
     * Get the date of employment of the employee.
     *
     * @return The date of employment.
     */
    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    /**
     * Get the date of dismissal (if any) of the employee.
     *
     * @return The date of dismissal.
     */
    public LocalDate getDateOfDismissal() {
        return dateOfDismissal;
    }

    /**
     * Get the salary of the employee.
     *
     * @return The salary.
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * Convert this DTO to an Employee entity.
     *
     * @return An Employee entity.
     */
    public Employee toEmployee() {
        return new Employee(getName(), getSurname(),
                getPhone(), getPositionEml(), getDateOfEmployment(),
                getDateOfDismissal(), getSalary());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(name, that.name)
                && Objects.equals(surname, that.surname)
                && Objects.equals(phone, that.phone)
                && Objects.equals(positionEml, that.positionEml)
                && Objects.equals(dateOfEmployment, that.dateOfEmployment)
                && Objects.equals(dateOfDismissal, that.dateOfDismissal)
                && Objects.equals(salary, that.salary);
    }

}
