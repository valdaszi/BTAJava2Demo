package lt.bta.java2.jaxrs;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // jei nenorime kad į json patektų laukai, kurių reikšmė null
public class GenericResponse {

    private boolean status;

    private String message;

    private String errorCode;

    private Object data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GenericResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
