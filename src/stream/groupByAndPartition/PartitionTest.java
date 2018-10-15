package stream.groupByAndPartition;

import com.google.common.collect.Maps;
import stream.collector.PrimeCollector;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
        System.out.println(isPrime2(3));
        System.out.println("=====");

        IntStream.range(10, 1).boxed().forEach(a -> System.out.println(a));
        Stream<Integer> a = Stream.empty();
        a.forEach(n -> System.out.println(n));


        partitionPrime(100).forEach((a1, a2) -> System.out.println( a1 + " " + a2));


        partitionPrime2(100).forEach((a1, a2) -> System.out.println( a1 + " " + a2));



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
        return IntStream.range(2, number).noneMatch(i -> number % i == 0);
    }


    //优化的isPrime

    //将前n个自然数分为质数与非质数

    public static Map<Boolean, List<Integer>> partitionPrime(int num) {
        Map<Boolean, List<Integer>> result = Maps.newHashMap();
        result = IntStream.range(2, num).boxed().collect(Collectors.partitioningBy(PartitionTest::isPrime2));
        return result;
    }

    public static Map<Boolean, List<Integer>> partitionPrime2(int num) {
        PrimeCollector primeCollector = new PrimeCollector();
        Map<Boolean, List<Integer>> result = Maps.newHashMap();
         result = IntStream.range(2, num).boxed().collect(primeCollector);
         return result;

    }


}
