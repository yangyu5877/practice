package guava.eventbus;

import com.google.common.eventbus.EventBus;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyou on 2018/10/8.
 */
public class CookieContainer {

    private AtomicInteger cookieCount = new AtomicInteger();

    private EventBus eventBus;

    public CookieContainer(EventBus _eventBus) {
        this.eventBus = _eventBus;
    }

    public void setCookieCount(int count) {
        cookieCount.set(count);
    }

    public void sellCookie() {
        if (cookieCount.get() <= 0) {
            //发送cookie empty 通知消息
            EmptyEvent emptyEvent = new EmptyEvent("container is empty");
            eventBus.post(emptyEvent);

        }else {
            System.out.println("selling one cookie");
            int remaintCount = cookieCount.decrementAndGet();
            System.out.println("remain cookie count :" + remaintCount);
        }

    }


}
