package lt.bta.java2.jpa.api.imp;

import lt.bta.java2.jpa.PersistenceUtil;
import lt.bta.java2.jpa.api.service.EmployeeService;
import lt.bta.java2.jpa.dao.DaoImp;
import lt.bta.java2.jpa.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    @GET
    @Path("/{empNo}")
    public Response get(@PathParam("empNo") int empNo, @QueryParam("salaries") boolean withSalaries) {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("my-persistence-unit");

        EntityManagerFactory emf = PersistenceUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        DaoImp<Employee> employeeDao = new DaoImp<>(em);

        Employee e = employeeDao.get(withSalaries ? Employee.GRAPH_SALARIES : null, Employee.class, empNo);

        em.close();

        return Response
                .status(e == null ? HttpServletResponse.SC_NOT_FOUND : HttpServletResponse.SC_OK)
                .entity(e)
                .build();
    }

    @Override
    @POST
    @Path("/")
    public Response save(Employee employee) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        DaoImp<Employee> employeeDao = new DaoImp<>(em);

        employeeDao.save(employee);

        return Response.status(HttpServletResponse.SC_OK).entity(employee).build();

    }

    @Override
    public Response delete(Employee employee) {
        return null;
    }

    @Override
    public Response update(Employee employee) {
        return null;
    }

    @Override
    @GET
    @Path("/list")
    public Response list(@QueryParam("size") int size, @QueryParam("skip") int skip) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        DaoImp<Employee> employeeDao = new DaoImp<>(em);

        List<Employee> employeeList = employeeDao.getPage(Employee.class, size, skip);

        return Response.status(HttpServletResponse.SC_OK).entity(employeeList).build();
    }
}
