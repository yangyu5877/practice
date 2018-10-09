package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by yangyou on 2018/10/8.
 */
public class TriplesTest {
    public static void main(String[] args) {
        getTriples().limit(5).forEach(a -> System.out.println(a[0] + " " + a[1] + " " + a[2]));
    }

    public static Stream<int[]> getTriples() {
        Stream<int[]> triples = IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).filter(
                b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed().map(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)}));
        return triples;
    }
}
