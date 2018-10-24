package lt.bta.java2.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface HelloWorldService {

    @WebMethod
    public String sayHello();

    @WebMethod
    public String sayGoodBye(String name);

}
