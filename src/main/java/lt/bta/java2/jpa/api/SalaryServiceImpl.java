package lt.bta.java2.jpa.api;

import lt.bta.java2.jaxrs.GenericResponse;
import lt.bta.java2.jpa.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/salary")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SalaryServiceImpl implements SalaryService {

    @Override
    @GET
    @Path("/{empNo}")
    public Response get(@PathParam("empNo") int empNo) {

        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();

        Query query = em.createQuery("from Salary where id.empNo = :empNo");
        query.setParameter("empNo", empNo);
        List result = query.getResultList();

        GenericResponse response = new GenericResponse();
        response.setStatus(true);
        response.setData(result);

        return Response.status(HttpServletResponse.SC_OK).entity(response).build();
    }
}
