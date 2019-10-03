package lt.bta.java2.jpa.api.service;

import lt.bta.java2.jpa.entities.Employee;
import lt.bta.java2.jpa.entities.Salary;

import javax.ws.rs.core.Response;

public interface EmployeeService {

    Response get(int empNo, boolean withSalaries);

    Response save(Employee employee);

    Response delete(int empNo);

    Response update(int empNo, Employee employee);

    Response list(int size, int skip);

    Response addSalary(int empNo, Salary salary);

    Response removeSalary(int empNo, String dateFrom);
}
