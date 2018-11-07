package lt.bta.java2.jpa.api;

import lt.bta.java2.jaxrs.GenericResponse;
import lt.bta.java2.jpa.PersistenceUtil;
import lt.bta.java2.jpa.dao.DaoImp;
import lt.bta.java2.jpa.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    @GET
    @Path("/{empNo}")
    public Response get(@PathParam("empNo") int empNo) {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("my-persistence-unit");

        EntityManagerFactory emf = PersistenceUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        DaoImp<Employee> employeeDao = new DaoImp<>(em);

        Employee e = employeeDao.get(Employee.class, empNo);

        em.close();

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

    @Override
    @POST
    @Path("/")
    public Response save(Employee employee) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        DaoImp<Employee> employeeDao = new DaoImp<>(em);

        employeeDao.save(employee);

        GenericResponse response = new GenericResponse();
        response.setStatus(true);
        response.setData(employee);
        return Response.status(HttpServletResponse.SC_OK).entity(response).build();

    }

    @Override
    public Response delete(Employee employee) {
        return null;
    }

    @Override
    public Response update(Employee employee) {
        return null;
    }
}
