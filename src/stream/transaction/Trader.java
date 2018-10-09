package stream.transaction;

/**
 * Created by yangyou on 2018/10/8.
 */
public class Trader {

    private String name;
    private String location;

    public Trader(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
