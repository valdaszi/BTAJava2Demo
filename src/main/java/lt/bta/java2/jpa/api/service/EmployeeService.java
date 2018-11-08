package lt.bta.java2.jpa.api.service;

import lt.bta.java2.jpa.entities.Employee;

import javax.ws.rs.core.Response;

public interface EmployeeService {

    Response get(int empNo, boolean withSalaries);

    Response save(Employee employee);

    Response delete(Employee employee);

    Response update(Employee employee);

    Response list(int size, int skip);

}
