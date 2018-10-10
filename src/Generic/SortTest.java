package Generic;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangyou on 2018/10/10.
 */
public class SortTest {
    public static void main(String[] args) {
        Apple a1 = new Apple(1);
        Apple a2 = new Apple(100);
        Apple a3 = new Apple(50);
        List<Apple> apples = Arrays.asList(a1, a2, a3);
        Collections.sort(apples);
        System.out.println(apples.get(1).getCalories());

    }
}
