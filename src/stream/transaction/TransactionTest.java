package stream.transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by yangyou on 2018/10/8.
 */
public class TransactionTest {
    private static List<Transaction> transactions;

    static {
        Trader raoul = new Trader("raoul", "cambridge");
        Trader mario = new Trader("mario", "milan");
        Trader alan = new Trader("alan", "cambridge");
        Trader brian = new Trader("brian", "cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();

    }

    //找出2011年发生的所有交易，并按交易额排序
    public static void test1() {
        List<Transaction> trans = transactions.stream().filter(a -> a.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue).reversed()).collect(Collectors.toList());
        System.out.println(trans.get(0).getValue());
    }

    //交易员都在哪些不同的城市工作过
    public static void test2() {
        List<String> locations = transactions.stream().map(Transaction::getTrader).map(Trader::getLocation).distinct().collect(Collectors.toList());
        System.out.println(locations.size());
        locations.stream().forEach(a -> System.out.println(a));
    }

    //查找所有来之剑桥的交易员，并按姓名排序
    public static void test3() {
        List<String> traders = transactions.stream().map(Transaction::getTrader).filter(a -> a.getLocation().equals("cambridge")).sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName).collect(Collectors.toList());
        System.out.println(traders.size());
        System.out.println(traders.get(0));
    }

    //打印生活在剑桥的交易员的所有交易额
    public static void test4() {
        Optional<Integer> sumValue = transactions.stream().filter(a -> a.getTrader().getLocation().equals("cambridge")).map(Transaction::getValue).reduce(Integer::sum);
        System.out.println(sumValue.get());
    }

    //找出最高的交易额
    public static void test5() {
        int maxValue = transactions.stream().max(Comparator.comparing(Transaction::getValue)).get().getValue();
        System.out.println(maxValue);
    }

}
