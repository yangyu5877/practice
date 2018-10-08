package guava.eventbus;

import com.google.common.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

/**
 * Created by yangyou on 2018/10/8.
 */
public class CookieEventTest {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        CookieContainer container = new CookieContainer(eventBus);
        container.setCookieCount(3);
        CookieSeller seller = new CookieSeller(eventBus);
        CookieMailBoss boss = new CookieMailBoss(eventBus);
        eventBus.register(seller);
        eventBus.register(boss);
        container.sellCookie();
        container.sellCookie();
        container.sellCookie();
        System.out.println("trigger event receive");
        Long start = System.currentTimeMillis();
        container.sellCookie();
        Long end = System.currentTimeMillis();
        System.out.println("spend time :  " + (end - start));
    }
}
