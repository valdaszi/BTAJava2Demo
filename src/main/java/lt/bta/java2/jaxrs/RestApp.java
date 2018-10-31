package lt.bta.java2.jaxrs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestApp extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(ObjectMapperContextResolver.class);
        resources.add(EmployeeServiceImpl.class);
        return resources;
    }

}
