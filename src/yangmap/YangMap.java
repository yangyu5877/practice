package yangmap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangyou on 2018/10/8.
 */
public interface YangMap<K, V> {

    // 一个key只能对应一个value， key不能重复， key可以为null

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V get(Object key);

    //返回的值是前一个与key值mapping的value， 如果没有，则返回null
    V put(K key, V value);

    V remove(Object key);

    void putAll(Map<? extends K, ? extends V> m);

    void clear();

    //   三个View视图， 包含key set， value collection， entry set

    Set<K> keySet();

    Collection<V> values();









}
