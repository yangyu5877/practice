import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by yangyou on 2018/9/12.
 */
public class FucationTest {
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
        System.out.println(map(inventary, (e -> e.getWeight())));
    }
    public static <T,R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> results = new ArrayList<>();
        for (T t : list) {
            results.add(f.apply(t));
        }
        return results;

    }
}
