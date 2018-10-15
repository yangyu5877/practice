package stream.collector;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * Created by yangyou on 2018/10/15.
 */
public class PrimeCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        Map<Boolean, List<Integer>> map = Maps.newHashMap();
        //初始化map
        map.put(true, Lists.newArrayList());
        map.put(false, Lists.newArrayList());
        return () -> map;
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> map, Integer num) -> map.get(isPrime(num)).add(num) ;
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> m1, Map<Boolean, List<Integer>> m2) -> {
            m1.get(true).addAll(m2.get(true));
            m1.get(false).addAll(m2.get(false));
            return m1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {

//        finisher方法必须返回在累积过程的最后要调用的一个函数

//        return i -> i;
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Sets.immutableEnumSet(Characteristics.IDENTITY_FINISH);
    }


    private static boolean isPrime(int num) {
        return !IntStream.range(2, num).anyMatch(a -> num %a == 0);
    }
}
