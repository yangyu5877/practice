package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by yangyou on 2018/9/19.
 */
public class FoldTest {
    public static void main(String[] args) {
//        test();
        test2();
    }
    public static void test() {
        //所有数相加
        List<Integer> nums = Arrays.asList(23, 455, 666, 123, 1, 3);
        Optional<Integer> i = nums.stream().reduce(Integer::divideUnsigned);
        i.ifPresent(j -> {
            System.out.println(j);
        });
}
    public static void test2() {
        //算出流中有多少道菜
        List<Dish> menu = Arrays.asList(
                new Dish("pork", true, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.FISH),
                new Dish("chicken", false, 400, Dish.Type.OTHER),
                new Dish("rice", false, 350, Dish.Type.OTHER),
                new Dish("pizza", false, 550, Dish.Type.OTHER)

        );
        System.out.println(menu.stream().count());
        System.out.println(menu.stream().map(d -> 1).reduce(0, (a,b) -> a+b));
        System.out.println(menu.stream().map(d -> 1).reduce(Integer::sum).get()f);
}
}
