import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by yangyou on 2018/9/14.
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Apple a = new Apple("yellow", 1);
        Apple b = new Apple("red", 110);
        Apple c = new Apple("green", 150);
        Apple d = new Apple("green", 12);
        List<Apple> inventary = new ArrayList<>();
        inventary.add(a);
        inventary.add(b);
        inventary.add(c);
        inventary.add(d);

        inventary.sort(Comparator.comparing(Apple::getWeight));
        Supplier<Apple> s = Apple::new;
        Apple m = s.get();
    }

    public static void test2() {
        Map<String, Function<Integer, Fruit>> map = new HashMap<>();
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
        Orange dd = (Orange) map.get("orange").apply(10);
    }





    static class Orange extends Fruit {
        private int weight;

        public Orange(int weight) {
            this.weight = weight;
        }
    }

    static class Fruit{}


}
