package stream;

import java.util.function.Supplier;

/**
 * Created by yangyou on 2018/10/11.
 */
public class FibSupplier implements Supplier<Integer> {
    private int first = 0;
    private int sec = 1;
    @Override
    public Integer get() {
        int tmp = first + sec;
        first = sec;
        sec = tmp;
        return tmp;
    }
}
