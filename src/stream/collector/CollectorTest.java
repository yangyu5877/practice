package stream.collector;

import stream.transaction.Transaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yangyou on 2018/10/12.
 */
public class CollectorTest {

    public static void main(String[] args) {
        Transaction t1 = new Transaction("1");
        Transaction t2 = new Transaction("2");
        Transaction t3 = new Transaction("1");
        Transaction t4 = new Transaction("1");
        Transaction t5 = new Transaction("3");
        Transaction t6 = new Transaction("4");
        List<Transaction> trans = Arrays.asList(t1, t2, t3, t4, t5, t6);
        CollectorTest collectorTest = new CollectorTest();
        collectorTest.mapTrans(trans).forEach((s1, tt) -> System.out.println(s1 + "   " + tt.size()));
        trans.stream().map(Transaction::getCurrency).collect(Collectors.joining(", "));

//        规约与汇总
        //查找流中的元素数量
        long count1 = trans.stream().count();
        long count2 = trans.stream().collect(Collectors.counting());

        System.out.println(count1 + "   " + count2);

    //查找流中交易额最高的transaction  但凡要把流中所有的项目合并成一个结果就可以用collector
        Transaction tr1 = new Transaction(100);
        Transaction tr2 = new Transaction(10);
        Transaction tr3 = new Transaction(300);
        Transaction tr4 = new Transaction(1);

        List<Transaction> transs = Arrays.asList(tr1, tr2, tr3, tr4);
        Optional<Transaction> maxTans = transs.stream().max(Comparator.comparing(Transaction::getValue));
        IntSummaryStatistics statistics = transs.stream().collect(Collectors.summarizingInt(Transaction::getValue));
        System.out.println(statistics);
        System.out.println(maxTans.get().getValue());
//         注意区分归约成一个值，与汇总为一个值

        //所以交易的交易额总和
        int sumAmount = transs.stream().collect(Collectors.summingInt(Transaction::getValue));
        int sumAmount2 = transs.stream().map(a -> a.getValue()).reduce(0, Integer::sum);

        int sumAmount3 = transs.stream().collect(Collectors.reducing(0, Transaction::getValue, (i, j) -> i + j));
        System.out.println(sumAmount3);

    }

    public  Map<String, List<Transaction>> mapTrans(List<Transaction> trans) {
        Map<String, List<Transaction>> transByCurencies =  trans.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
        return transByCurencies;
    }

}
