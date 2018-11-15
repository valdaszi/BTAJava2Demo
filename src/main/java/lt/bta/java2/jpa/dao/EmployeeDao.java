package lt.bta.java2.jpa.dao;

import lt.bta.java2.jpa.entities.Employee;
import lt.bta.java2.jpa.entities.Salary;

import javax.persistence.EntityManager;
import java.util.ArrayList;

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
            em.merge(empOrg);
        });
    }

    public void addSalary(Object pk, Salary salary) {
        executeInsideTransaction(em -> {
            Employee employee = em.find(Employee.class, pk);
            if (employee.getSalaries() == null) employee.setSalaries(new ArrayList<>());
            salary.setEmpNo(employee.getEmpNo());
            employee.getSalaries().add(salary);
            em.merge(employee);
        });
    }
}
