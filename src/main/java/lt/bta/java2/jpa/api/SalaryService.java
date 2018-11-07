package lt.bta.java2.jpa.api;

import javax.ws.rs.core.Response;

public interface SalaryService {

    Response get(int empNo);

}
