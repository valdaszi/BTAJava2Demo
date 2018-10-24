package lt.bta.java2.jaxws;

import lt.bta.java2.bean.Person;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PersonService {

    @WebMethod
    boolean addPerson(Person p);

    @WebMethod
    boolean deletePerson(int id);

    @WebMethod
    Person getPerson(int id);

    @WebMethod
    Person[] getAllPersons();
}
