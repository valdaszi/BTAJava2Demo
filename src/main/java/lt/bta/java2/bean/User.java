package lt.bta.java2.bean;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class User {

    public static Map<String, String> users;

    static {
        users = new HashMap<>();
        users.put("Jonas", "123");
        users.put("petras", "petras");
        users.put("admin", "qwerty");
    }

    String name;

    LocalDateTime time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
