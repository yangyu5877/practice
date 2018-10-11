package stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by yangyou on 2018/10/10.
 */
//打印斐波那契数列组 (0,1), (1,1), (1,2).. 打印20个
public class StreamFibTest {
    public static void main(String[] args) {
        test();
        FibSupplier fibSupplier = new FibSupplier();
        generateSteam();
        generateSteam2(fibSupplier);
    }


    public static void test() {
        Stream.iterate(new int[]{0,1}, t -> new int[] {t[1], t[0] + t[1]}).limit(20).forEach(a -> System.out.println("(" + a[0]  + ","+ a[1] + ")"));
    }

    public static void generateSteam() {
//        Stream.generate(() -> 2).limit(10).forEach(System.out::println);
        Stream.generate(() -> 2).limit(10).forEach(System.out::println);
    }
    public static void generateSteam2(Supplier supplier) {
//        Stream.generate(() -> 2).limit(10).forEach(System.out::println);
        Stream.generate(supplier).limit(20).forEach(System.out::println);
    }

}
