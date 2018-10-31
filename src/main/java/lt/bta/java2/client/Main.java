package lt.bta.java2.client;

import lt.bta.java2.bean.Person;
import lt.bta.java2.jaxws.PersonService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        URL wsdlURL = new URL("http://localhost:8080/kokinori/person?wsdl");

        //creating QName using targetNamespace and name
        QName qname = new QName("http://jaxws.java2.bta.lt/", "PersonServiceImplService");

        Service service = Service.create(wsdlURL, qname);

        //We need to pass interface and model beans to client,
        // i.e. client must know what interface is used (PersonService) and model bean (Person)
        // This info can be generated from wsdl
        PersonService ps = service.getPort(PersonService.class);

        Person p1 = new Person(); p1.setName("Vycka"); p1.setId(1); p1.setAge(30);
        Person p2 = new Person(); p2.setName("Ecka"); p2.setId(2); p2.setAge(25);

        //add person
        System.out.println("Add Person Status=" + ps.addPerson(p1));
        System.out.println("Add Person Status=" + ps.addPerson(p2));

        //get person
        System.out.println("Get person id=1: " + ps.getPerson(1));

        //get all persons
        System.out.println("Get all persons: " + Arrays.asList(ps.getAllPersons()));

        //delete person
        System.out.println("Delete Person id=2, status=" + ps.deletePerson(2));

        //get all persons
        System.out.println("Get all persons: " + Arrays.asList(ps.getAllPersons()));
    }
}
