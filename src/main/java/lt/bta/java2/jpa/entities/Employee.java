package lt.bta.java2.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
@NamedEntityGraph(name = Employee.GRAPH_SALARIES,
        attributeNodes = @NamedAttributeNode("salaries"))
public class Employee {

    public static final String GRAPH_SALARIES = "graph.Employee.salaries";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no", nullable = false)
    private int empNo;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "first_name", nullable = false, length = 14)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 16)
    private String lastName;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    @JsonIgnoreProperties("employee")
    private List<Salary> salaries;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empNo == employee.empNo &&
                Objects.equals(birthDate, employee.birthDate) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(hireDate, employee.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, birthDate, firstName, lastName, gender, hireDate);
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }

    public void addSalary(Salary salary) {
        if (this.salaries == null) this.salaries = new ArrayList<>();
        this.salaries.add(salary);
        salary.setEmpNo(this.getEmpNo());
        salary.setEmployee(this);
    }

    public void removeSalary(Salary salary) {
        salary.setEmployee(null);
        this.salaries.remove(salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", birthDate=" + birthDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", hireDate=" + hireDate +
                '}';
    }
}
