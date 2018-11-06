package lt.bta.java2.jpa.dao;

import lt.bta.java2.jpa.entities.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee getByEmpNo(int empNo);

    boolean update(Employee emp);
}
