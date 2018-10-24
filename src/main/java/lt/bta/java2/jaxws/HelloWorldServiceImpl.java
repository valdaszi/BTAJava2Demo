package lt.bta.java2.jaxws;

import javax.jws.WebService;

@WebService(endpointInterface = "lt.bta.java2.jaxws.HelloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String sayHello() {
        return "Hello from JAX-WS";
    }

    @Override
    public String sayGoodBye(String name) {
        return "Good bye, " + name;
    }
}
