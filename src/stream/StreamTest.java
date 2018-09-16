package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangyou on 2018/9/15.
 */
public class StreamTest {
     static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.FISH),
            new Dish("chicken", false, 400, Dish.Type.OTHER),
            new Dish("rice", false, 350, Dish.Type.OTHER),
            new Dish("pizza", false, 550, Dish.Type.OTHER)

    );

    public static void main(String[] args) {
        getLowCalDishName().stream().forEach(aa -> System.out.println(aa));;
    }

    public static List<String> getLowCalDishName() {
        List<String> result = new ArrayList<>();
        result = menu.stream().filter(a -> a.getColories() < 700).sorted(Comparator.comparing(Dish::getColories)).map(Dish::getName).
                collect(Collectors.toList());
        return result;


    }


}
