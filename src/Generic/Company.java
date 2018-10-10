package Generic;

/**
 * Created by yangyou on 2018/10/10.
 */
public class Company<T> {

    private T human;


    public T getHuman() {
        return human;
    }

    public void setHuman(T human) {
        this.human = human;
    }

}
