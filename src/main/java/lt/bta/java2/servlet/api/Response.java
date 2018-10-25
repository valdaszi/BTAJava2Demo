package lt.bta.java2.servlet.api;

public class Response {

    private boolean success;

    private String error;

    private Object data;

    public static Response onSuccess(Object data) {
        Response response = new Response();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static Response onError(String error) {
        Response response = new Response();
        response.setSuccess(false);
        response.setError(error);
        return response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
