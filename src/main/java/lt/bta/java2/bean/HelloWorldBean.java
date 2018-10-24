package lt.bta.java2.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="helloWorldBean")
@RequestScoped
public class HelloWorldBean {

    private String msg;

    private String name = "Jonas";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    private void init() {
        msg = "I am JSF example :)";
    }
}
