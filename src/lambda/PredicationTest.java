package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by yangyou on 2018/9/15.
 */
public class PredicationTest {

    public static void main(String[] args) {
        predicateTest();
    }


    public static void predicateTest() {
        Apple a = new Apple("yellow", 1);
        Apple b = new Apple("red", 110);
        Apple c = new Apple("green", 150);
        Apple d = new Apple("green", 12);
        List<Apple> inventary = new ArrayList<>();
        inventary.add(a);
        inventary.add(b);
        inventary.add(c);
        inventary.add(d);

        Predicate<Apple> redApple = (aa) -> aa.getColor().equals("red");


        for (Apple apple: inventary) {
            if (redApple.negate().and(cc -> cc.getWeight() > 10).test(apple)) {
                System.out.println(apple.getWeight());
            }
        }
    }
}
