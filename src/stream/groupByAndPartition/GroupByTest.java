package stream.groupByAndPartition;

import stream.Dish;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static stream.Dish.Type.*;

/**
 * Created by yangyou on 2018/10/12.
 */
public class GroupByTest {

    private enum CalLevel {DIET, NORMAL, FAT};

    public static void main(String[] args) {

        Dish dish1 = new Dish("fish", false, 100, FISH);
        Dish dish2 = new Dish("meat", false, 500, MEAT);
        Dish dish3 = new Dish("veg", true, 30, OTHER);
        Dish dish4 = new Dish("bread", true, 390, OTHER);
        Dish dish5 = new Dish("fish", false, 900, FISH);
        List<Dish> menu = Arrays.asList(dish1, dish2, dish3, dish4, dish5);
        GroupByTest groupByTest = new GroupByTest();
        System.out.println("=== case1 =====");
        System.out.println(groupByTest.test1(menu));
        System.out.println("=== case2 =====");
        System.out.println(groupByTest.getMulGroup(menu));
        System.out.println("=== case3 =====");
        System.out.println(groupByTest.dishTypeCount(menu));
        System.out.println("=== case4 =====");
        groupByTest.highCalInDishType(menu).forEach( (a1, a2) -> System.out.println(a1 + "  " + a2.get()));
        System.out.println("=== case5 =====");

    }

    //按热量分组， 400 以下一组   400-700 一组   700以上一组   每组对应一个enum

    public Map<CalLevel, List<Dish>> test1(List<Dish> menu) {
        //还是定义一个私有方法比较好
        return menu.stream().collect(Collectors.groupingBy(a -> getCalLevel(a)));
    }

    public Map<CalLevel, List<Dish>> test11(List<Dish> menu) {
        return menu.stream().collect(Collectors.groupingBy(a -> {
            if (a.getColories() > 100)
                return CalLevel.FAT;
            else return CalLevel.DIET;
        }));
    }

    private CalLevel getCalLevel(Dish dish) {
        int colories = dish.getColories();
        if (colories < 100) {
            return CalLevel.DIET;
        }else if (colories > 700) {
            return CalLevel.FAT;
        }else {
            return CalLevel.NORMAL;
        }
    }

//    多级分组， 菜品类型， 热量类型
    public Map<Dish.Type, Map<CalLevel, List<Dish>>> getMulGroup(List<Dish> menu) {
        return  menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.groupingBy(a -> getCalLevel(a))));
    }


    //按子组搜集数据 //数数菜单中每类菜有多少个
    public Map<Dish.Type, Long> dishTypeCount(List<Dish> menu) {
        return menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        }

    //每组菜品类型-热量最高的菜品
    public Map<Dish.Type, Optional<Dish>> highCalInDishType(List<Dish> menu) {
        return menu.stream().collect(Collectors.groupingBy(
                Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getColories))
        ));
    }

    //把收集器的结果转换为另一种类型  CollectingAndThen
    public Map<Dish.Type, Dish> highCalInDishType2(List<Dish> menu) {
        return menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getColories)), a -> a.get())));
    }

    //与groupingBy联合使用的其他收集器的例子  groupingBy 与 mapping的结合   ，  对于每种类型的Dish，菜单中都有哪些热量类型



}
