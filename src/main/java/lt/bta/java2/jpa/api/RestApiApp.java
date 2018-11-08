package lt.bta.java2.jpa.api;

import lt.bta.java2.jpa.api.imp.EmployeeServiceImpl;
import lt.bta.java2.jpa.api.imp.SalaryServiceImpl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApiApp extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(RestApiObjectMapperContextResolver.class);

        resources.add(EmployeeServiceImpl.class);
        resources.add(SalaryServiceImpl.class);

        return resources;
    }

}
