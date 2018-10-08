package guava.guavacache;

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangyou on 2018/10/8.
 */
public class CacheUtils {

    public static <K, V> LoadingCache<K, V> cached(CacheLoader<K, V> loader) {
        return CacheBuilder.newBuilder().maximumSize(2).expireAfterWrite(120, TimeUnit.SECONDS).weakKeys().softValues()
                .refreshAfterWrite(10, TimeUnit.SECONDS).removalListener(
//                        new RemovalListener<K, V>() {
//                            @Override
//                            public void onRemoval(RemovalNotification<K, V> rn) {
//                                System.out.println(rn.getCause().toString() + rn.getKey() + "被移除");
//                            }
//                        }
                        (rn) -> {
                            System.out.println(rn.getCause().toString() + rn.getKey() + "被移除");
                        }

                ).build(loader);
    }

    public static LoadingCache<String, String> commonCache(String key) {
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            @Override
            public String load(String k) throws Exception {
                System.out.println("first load");
                return "hell" + k;
            }
        };
        return cached(loader);
    }

    public static <K, V> Cache<K, V> callCached() {
        return CacheBuilder.newBuilder().weakKeys().softValues().expireAfterWrite(100000, TimeUnit.MILLISECONDS)
                .removalListener(new RemovalListener<K, V>() {
                    @Override
                    public void onRemoval(RemovalNotification<K, V> rn) {
                        System.out.println(rn.getCause().toString() + rn.getKey() + "被删除");
                    }
                }).build();
    }

    public static String getValue(String key) throws ExecutionException {
        Cache<String, String> cache = callCached();
        String vaule = cache.get(key, () -> {
            System.out.println("first loading");
            return "cache hello" + key;});
        return vaule;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        loadingCachetest();
        callcacheTest();

    }

    public static void loadingCachetest() throws ExecutionException {
        LoadingCache loadingCache = commonCache("hello");
        System.out.println(loadingCache.get("hello"));
        System.out.println(loadingCache.get("hello"));
        System.out.println(loadingCache.get("heiheihei"));
        System.out.println(loadingCache.get("heihei"));
    }

    public static void callcacheTest() throws ExecutionException, InterruptedException {
        System.out.println(getValue("heloo"));
        System.out.println(getValue("heloo"));
        System.out.println(getValue("sd"));

    }
}
