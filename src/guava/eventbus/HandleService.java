package guava.eventbus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * Created by yangyou on 2018/10/8.
 */
public interface HandleService {
//
//    @AllowConcurrentEvents
//     void handleEvent(EmptyEvent emptyEvent) throws InterruptedException;
    @Subscribe
     void handleEvent(EmptyEvent emptyEvent) throws InterruptedException;
}
