import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by yangyou on 2018/9/10.
 */
public class AppleTest {

//    public List<Apple> filter(List<Apple> inventary, Predicate<Apple> p) {
//        List<Apple> results = new ArrayList<>();
//        for (Apple a : inventary) {
//            if (p.test(a)) {
//                results.add(a);
//            }
//        }
//        return results;
//    }


    public static void main(String[] args) {


    }

    public static void test1() {
        Apple a = new Apple("yellow", 1);
        Apple b = new Apple("red", 110);
        Apple c = new Apple("green", 150);
        Apple d = new Apple("green", 12);
        List<Apple> inventary = new ArrayList<>();
        inventary.add(a);
        inventary.add(b);
        inventary.add(c);
        inventary.add(d);
        AppleTest predicateTest = new AppleTest();
        //取超重苹果
        List<Apple> apples = predicateTest.filter(inventary, Apple::isHeavy);
        System.out.println(apples.size());
        List<Apple> apples2 = predicateTest.filter(inventary, (Apple i) -> i.getWeight() > 100);
        System.out.println(apples2.size());
        //可以猜出i的类型
        List<Apple> apples3 = predicateTest.filter(inventary, (i) -> i.getWeight() > 100);
        System.out.println(apples3.size());
    }

    public static void test2() {
        Apple a = new Apple("yellow", 1);
        Apple b = new Apple("red", 110);
        Apple c = new Apple("green", 150);
        Apple d = new Apple("green", 12);
        List<Apple> inventary = new ArrayList<>();
        inventary.add(a);
        inventary.add(b);
        inventary.add(c);
        inventary.add(d);

        List<Apple> apples = inventary.stream().filter(a1 -> a1.getWeight() > 150).collect(Collectors.toList());
        apples = inventary.parallelStream().filter(a1 -> a1.getWeight() > 150).collect(Collectors.toList());
    }

    public static void test3() {
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
        apples.sort((e1, e2) -> e1.getWeight().compareTo(e2.getWeight()));
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
