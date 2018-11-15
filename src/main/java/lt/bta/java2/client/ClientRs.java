package lt.bta.java2.client;

import lt.bta.java2.jpa.entities.Employee;
import lt.bta.java2.jpa.entities.Gender;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

public class ClientRs {

    public static void main(String[] args) {

        Client client = new ClientProducer().produceClient();

        WebTarget apiBase = client.target("http://localhost:8080/kokinori/api");
        WebTarget apiEmployee = apiBase.path("employee");
        WebTarget apiEmployeeById = apiEmployee.path("{empNo}");

        // create new employee

        Employee newEmployee = new Employee();
        newEmployee.setGender(Gender.F);
        newEmployee.setFirstName("Žiurkė");
        newEmployee.setLastName("Kūzė");
        newEmployee.setHireDate(LocalDate.of(2018, 11, 1));
        newEmployee.setBirthDate(LocalDate.of(1990, 12, 31));

        Employee newEmployeeRes = apiEmployee
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(newEmployee))
                .readEntity(Employee.class);

        int empNo = newEmployeeRes.getEmpNo();

        // read new created employee and print

        Response response = apiEmployeeById.resolveTemplate("empNo", empNo).request().get();
        Employee employee = response.readEntity(Employee.class);

        System.out.println(employee);

        // update employee info

        Employee updEmployee = new Employee();
        updEmployee.setGender(Gender.F);
        updEmployee.setFirstName("Ąžuolas");
        updEmployee.setLastName("Čiūžė");
        updEmployee.setHireDate(LocalDate.of(2018, 11, 1));
        updEmployee.setBirthDate(LocalDate.of(1990, 12, 31));

        response = apiEmployeeById
                .resolveTemplate("empNo", empNo)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(updEmployee));

        System.out.println("response status: " + response.getStatus());

        // read again and print

        employee = apiEmployeeById
                .resolveTemplate("empNo", empNo)
                .request(MediaType.APPLICATION_JSON)
                .get(Employee.class);

        System.out.println(employee);

    }

}
