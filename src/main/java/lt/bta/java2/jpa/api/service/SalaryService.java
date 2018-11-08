package lt.bta.java2.jpa.api.service;

import javax.ws.rs.core.Response;

public interface SalaryService {

    Response get(int empNo);

}
