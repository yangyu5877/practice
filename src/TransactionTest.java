import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
/**
 * Created by yangyou on 2018/9/10.
 */
public class TransactionTest {


    //查找交易额>500的货币交易
    public static void test1() {
        Transaction a = new Transaction("A", 100);
        Transaction b = new Transaction("B", 200);
        Transaction c = new Transaction("C", 300);
        Transaction d = new Transaction("D", 400);
        Transaction e = new Transaction("B", 700);
        Transaction f = new Transaction("B", 800);
        Transaction g = new Transaction("D", 400);
        List<Transaction> trans = new ArrayList<>();
        trans.add(a);
        trans.add(b);
        trans.add(c);
        trans.add(d);
        trans.add(e);
        trans.add(f);
        trans.add(g);
        Map<Transaction.Currency, List<Transaction>> values = getTransaction(trans);
        System.out.println(values.size());
    }
    private static Map<Transaction.Currency, List<Transaction>> getTransaction(List<Transaction> trans) {

        return trans.stream().filter((Transaction t) -> t.getPrice() > 500).collect(groupingBy(Transaction::getCurrency));
    }

    public static void main(String[] args) {
        test1();
    }
}
