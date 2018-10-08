package guava.eventbus;

/**
 * Created by yangyou on 2018/10/8.
 */
public class EmptyEvent {

    private String message;

    public EmptyEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
