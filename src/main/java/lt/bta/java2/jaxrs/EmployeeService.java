package lt.bta.java2.jaxrs;

import lt.bta.java2.bean.Employee;

import javax.ws.rs.core.Response;

public interface EmployeeService {

    Response addEmployee(Employee e);

    Response deleteEmployee(int id);

    Response getEmployee(int id);

    Employee[] getAllEmployees();

}
