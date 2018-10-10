package yangmap;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
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

    interface Entry<K, V> {

        K getKey();

        V getValue();
        //返回的V是 key关联的old value

        V setValue(K key);

        boolean equal();

        int hashCode();

        //java8中可以在接口中定义静态方法


        static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K, V>> comparingByKey() {
            // & 为新语法，需要满足两种类型， 不是与操作的意思
            return (Comparator<Map.Entry<K,V>> & Serializable)
                  (c1, c2) -> c1.getKey().compareTo(c2.getKey());
        }

        static <K, V extends Comparable<? super V> > Comparator<Map.Entry<K, V>> comparingByValue() {
            return (Comparator<Map.Entry<K,V>> & Serializable)
                    (c1, c2) -> c1.getValue().compareTo(c2.getValue());
        }

        static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
            return (Comparator<Map.Entry<K,V>> & Serializable)
                    (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
        }

    }







}
