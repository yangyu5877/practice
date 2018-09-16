package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by yangyou on 2018/9/15.
 */
public class CompondFuncationTest {

    public static void main(String[] args) {
        compond();
    }

    public static void reverse() {
        Apple a = new Apple("yellow", 1);
        Apple b = new Apple("red", 110);
        Apple c = new Apple("green", 150);
        Apple d = new Apple("green", 12);
        List<Apple> inventary = new ArrayList<>();
        inventary.add(a);
        inventary.add(b);
        inventary.add(c);
        inventary.add(d);
        Comparator<Apple> cc = Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor);
        inventary.sort(cc);
    }

    public static void compond() {
        Apple a = new Apple("yellow", 1);
        Apple b = new Apple("red", 110);
        Apple c = new Apple("green", 150);
        Apple d = new Apple("green", 12);

        Function<Apple, Integer> f1 = aa -> a.getWeight();
        Function<Integer, Integer> f2 = aa -> aa + 1;
        Function<Apple, Integer> f3 = f1.andThen(f2);

        System.out.println(f3.apply(a));

    }



}
