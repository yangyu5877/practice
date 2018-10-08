package guava.eventbus;

import com.google.common.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

/**
 * Created by yangyou on 2018/10/8.
 */
public class CookieMailBoss implements HandleService {

    private EventBus eventBus;

    public CookieMailBoss(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void handleEvent(EmptyEvent emptyEvent) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(getClass().getName() + "receive message :" + emptyEvent.getMessage());
    }
}
