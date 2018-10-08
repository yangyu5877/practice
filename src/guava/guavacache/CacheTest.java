package guava.guavacache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by yangyou on 2018/10/8.
 */
public class CacheTest {

    private static final LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().build(
            new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    System.out.println("first load");
                    String strProValue = "hello" + key + "!";
                    return strProValue;
                }
            }
    );

    private static final Cache<String, String> cache = CacheBuilder.newBuilder().build();



    public static void main(String[] args) throws ExecutionException {
//        cacheLoaderTest();
        cacheCallTest();
    }


    public static void cacheLoaderTest() throws ExecutionException {
        //第一次如果没有，则缓存，第二次直接从缓存中获取
        System.out.println(loadingCache.get("hello"));
        System.out.println(loadingCache.get("hello"));
    }

    public static void cacheCallTest() throws ExecutionException {
//        System.out.println(cache.getIfPresent("hello"));
        String key = "cache";
        String cacheValue = cache.get(key, new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello" + key;
            }
        });
        String cacheValue2 = cache.get(key, () -> {return "hello" + key;});
        System.out.println(cacheValue2);
    }


}
