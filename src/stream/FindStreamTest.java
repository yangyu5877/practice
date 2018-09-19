package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by yangyou on 2018/9/19.
 */
public class FindStreamTest {
    public static void main(String[] args) {
//        test();
        test2();
    }

    public static void test() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", true, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.FISH),
                new Dish("chicken", false, 400, Dish.Type.OTHER),
                new Dish("rice", false, 350, Dish.Type.OTHER),
                new Dish("pizza", false, 550, Dish.Type.OTHER)

        );
        boolean anyMatch = menu.stream().anyMatch(Dish::isVegetarian);
        boolean noneMatch = menu.stream().noneMatch(Dish::isVegetarian);
        boolean allMatch = menu.stream().allMatch(Dish::isVegetarian);

        System.out.println(anyMatch);
        System.out.println(noneMatch);
        System.out.println(allMatch);
    }
    public static void test2() {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", true, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.FISH),
                new Dish("chicken", false, 400, Dish.Type.OTHER),
                new Dish("rice", false, 350, Dish.Type.OTHER),
                new Dish("pizza", false, 550, Dish.Type.OTHER)

        );
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(

                d -> {
                    System.out.println(d.getName());
                }
        );
        Predicate<Dish> p = Dish::isVegetarian;
        menu.stream().filter(p.negate()).findFirst().ifPresent(
                d -> {
                    System.out.println(d.getName());
                }
        );
    }
}
