package lt.bta.java2.jaxrs;

import lt.bta.java2.bean.Employee;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeServiceImpl implements EmployeeService {

    private static Map<Integer, Employee> emps;

    static {
        emps = new HashMap<>();

        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Jonas");
        e1.setSalary(1200.0);
        emps.put(e1.getId(), e1);

        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Ona");
        e2.setSalary(1500.0);
        emps.put(e2.getId(), e2);
    }

    @Override
    @POST
    @Path("/add")
    public Response addEmployee(Employee e) {
        GenericResponse response = new GenericResponse();
        if(emps.get(e.getId()) != null){
            response.setStatus(false);
            response.setMessage("Employee Already Exists");
            response.setErrorCode("EC-01");
            return Response.status(422).entity(response).build();
        }
        emps.put(e.getId(), e);
        response.setStatus(true);
        response.setMessage("Employee created successfully");
        return Response.ok(response).build();
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    public Response deleteEmployee(@PathParam("id") int id) {
        GenericResponse response = new GenericResponse();
        if(emps.get(id) == null){
            response.setStatus(false);
            response.setMessage("Employee Doesn't Exists");
            response.setErrorCode("EC-02");
            return Response.status(404).entity(response).build(); // HttpServletResponse.SC_NOT_FOUND
        }
        emps.remove(id);
        response.setStatus(true);
        response.setMessage("Employee deleted successfully");
        return Response.ok(response).build();
    }

    @Override
    @GET
    @Path("/{id}/get")
    public Response getEmployee(@PathParam("id") int id) {
        Employee e = emps.get(id);
        GenericResponse response = new GenericResponse();
        if (e == null) {
            response.setStatus(false);
            response.setMessage("Employee Doesn't Exists");
            response.setErrorCode("EC-01");;
        } else {
            response.setStatus(true);
            response.setData(e);
        }
        return Response.status(response.isStatus() ? HttpServletResponse.SC_OK : HttpServletResponse.SC_NOT_FOUND).entity(response).build();
    }

    @GET
    @Path("/{id}/getDummy")
    @Produces(MediaType.APPLICATION_XML)
    public Employee getDummyEmployee(@PathParam("id") int id) {
        Employee e = new Employee();
        e.setSalary(8976.55);
        e.setName("Dummy");
        e.setId(id);
        return e;
    }

    @Override
    @GET
    @Path("/getAll")
    public Employee[] getAllEmployees() {
        return emps.values().toArray(new Employee[0]);
    }
}
