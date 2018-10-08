package lambda;

import java.util.concurrent.Callable;

/**
 * Created by yangyou on 2018/10/8.
 */
public class CallableTest {
    public static void main(String[] args) {

    }
    public static void callableTest1() {
        Callable c = () -> {return "hello";};
    }
}
