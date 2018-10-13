package stream.groupByAndPartition;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by yangyou on 2018/10/12.
 */
public class PartitionTest {

    public static void main(String[] args) {

        System.out.println(isPrime(2));
        System.out.println(isPrime(10));
        System.out.println(isPrime(7));
        System.out.println(isPrime(18));
        System.out.println(isPrime(101));
        System.out.println("=====");

        System.out.println(isPrime2(2));
        System.out.println("=====");

        IntStream.range(10, 1).boxed().forEach(a -> System.out.println(a));
        Stream<Integer> a = Stream.empty();
        a.forEach(n -> System.out.println(n));
    }

    // 按菜品 素食与非素食 分区

    // 分区的优势，   1， 素食与非素食中， 热量最高的菜品，   2   二级map  分区后再分组


    //将数字分为 质数与非质数

    //isPrime

    public static boolean isPrime(int number) {
        Long booleanNum = IntStream.range(2, number).boxed().map(a ->
                number % a != 0).distinct().count();
        return booleanNum == 1 ? true : false;
    }


    public static boolean isPrime2(int number) {
        return !IntStream.range(2, number).anyMatch(i -> number % i == 0);
    }



    //优化的isPrime

    //将前n个自然数分为质数与非质数


}
