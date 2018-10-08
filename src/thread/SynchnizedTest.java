package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by yangyou on 2018/9/30.
 */
public class SynchnizedTest {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);
        SumMethod sumMethod = new SumMethod();
        IntStream.range(0, 1000).forEach(a -> service.submit(sumMethod::addIByonePerStep));
        service.awaitTermination(10000, TimeUnit.MILLISECONDS);
        System.out.println(sumMethod.getI());
    }


    static class SumMethod {
        private  AtomicInteger i = new AtomicInteger(0);

        public void addIByonePerStep() {
            setI(new AtomicInteger(getI().getAndAdd(1)));
        }


        public AtomicInteger getI() {
            return i;
        }

        public void setI(AtomicInteger i) {
            this.i = i;
        }
    }
}
