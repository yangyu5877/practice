package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangyou on 2018/9/17.
 */
public class FilterTest {

    public static void main(String[] args) {
        filter1();
    }


    public static void filter1() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.FISH),
                new Dish("chicken", false, 400, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("pizza", false, 550, Dish.Type.OTHER)

        );
        List<Dish> dishs = menu.stream().filter(d -> !d.isVegetarian()).skip(1).distinct().collect(Collectors.toList());
        dishs.stream().map(Dish::getName).forEach(System.out::println);
    }
}
