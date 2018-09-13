import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by yangyou on 2018/9/12.
 */
public class PredicateTest {
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
        List<Apple> apples = filter(inventary, a1 -> a1.getColor() == "yellow");
        System.out.println(apples.size());
    }
    public static <T> List<T> filter(List<T> values, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : values) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

}
