import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by yangyou on 2018/9/12.
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Apple a = new Apple("yellow", 1);
        Apple b = new Apple("red", 110);
        Apple c = new Apple("green", 150);
        Apple d = new Apple("green", 12);
        List<Apple> inventary = new ArrayList<>();
        inventary.add(a);
        inventary.add(b);
        inventary.add(c);
        inventary.add(d);
        forEach(inventary, a1 -> System.out.println(a1.getWeight()));

    }
    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
