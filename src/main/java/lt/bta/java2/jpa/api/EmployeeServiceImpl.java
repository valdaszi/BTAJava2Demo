package lt.bta.java2.jpa.api;

import lt.bta.java2.jaxrs.GenericResponse;
import lt.bta.java2.jpa.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/emp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    @GET
    @Path("/{empNo}")
    public Response get(@PathParam("empNo") int empNo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee e = em.find(Employee.class, empNo);

        em.getTransaction().commit();
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
}
