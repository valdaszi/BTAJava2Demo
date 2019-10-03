package lt.bta.java2.jpa.dao;

import lt.bta.java2.jpa.entities.Employee;
import lt.bta.java2.jpa.entities.Salary;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class EmployeeDao extends DaoImp<Employee> {

    public EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void update(Object pk, Employee employee) {
        executeInsideTransaction(em -> {
            Employee empOrg = em.find(Employee.class, pk);
            empOrg.setFirstName(employee.getFirstName());
            empOrg.setLastName(employee.getLastName());
            empOrg.setBirthDate(employee.getBirthDate());
            empOrg.setHireDate(employee.getHireDate());
            empOrg.setGender(employee.getGender());
            em.persist(empOrg);
        });
    }

    public void addSalary(int empNo, Salary salary) {
        executeInsideTransaction(em -> {
            Employee employee = em.find(Employee.class, empNo);
            if (employee == null) return;
            employee.addSalary(salary);
            em.persist(employee);
        });
    }

    public void removeSalary(int empNo, LocalDate dateFrom) {
        executeInsideTransaction(em -> {
            Employee employee = em.find(Employee.class, empNo);
            if (employee == null || employee.getSalaries() == null) return;
            employee.getSalaries()
                    .stream()
                    .filter(it -> it.getFromDate().equals(dateFrom))
                    .findAny()
                    .ifPresent(employee::removeSalary);
        });
    }
}
