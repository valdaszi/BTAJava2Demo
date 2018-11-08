package lt.bta.java2.jpa.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@NamedEntityGraph(name = Employee.GRAPH_SALARIES, attributeNodes = @NamedAttributeNode(value = "salaries"))
public class Employee {

    public static final String GRAPH_SALARIES = "graph.Employee.salaries";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    private Integer empNo;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "first_name", length = 14)
    private String firstName;

    @Column(name = "last_name", length = 16)
    private String lastName;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @OneToMany(mappedBy = "id.empNo",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Salary> salaries = new ArrayList<>();


    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
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

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }
}
