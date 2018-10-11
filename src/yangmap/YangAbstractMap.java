package yangmap;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by yangyou on 2018/10/10.
 */
public abstract class YangAbstractMap<K, V> implements YangMap<K, V> {
    // TODO: 2018/10/11 由子类invoke???
    protected YangAbstractMap() {}

    @Override
    public boolean containsValue(Object value) {
        Iterator<Entry<K, V>> iterator = entrySet().iterator();
        if (null == value) {
            while(iterator.hasNext()) {
                Entry<K, V> e = iterator.next();
                if (null == e.getValue()) {
                    return true;
                }
            }
        }else {
            while(iterator.hasNext()) {
                Entry<K, V> e = iterator.next();
                if (value.equals(e.getValue())) {
                    return true;
                }
            }

        }
        return false;
    }

    // TODO: 2018/10/10 为什么用的是object而不是K
    //从比较值的角度，如果使用泛型，则违反了equals的精神，不同的类型也不能相等
    public V get(Object key) {
        Iterator<Entry<K, V>> i = entrySet().iterator();
        if (null == key) {
            while(i.hasNext()) {
                Entry<K, V> e = i.next();
                if (null == e.getKey()) {
                    return e.getValue();
                }
            }
        }else {
            while(i.hasNext()) {
                Entry<K, V> e = i.next();
                if (key.equals(e.getKey())) {
                    return e.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public V remove(Object key) {
        Iterator<Entry<K, V>> i = entrySet().iterator();
        Entry<K, V> correctEntry = null;
        if (null == key) {
            while(i.hasNext() && null == correctEntry) {
                Entry<K, V> e = i.next();
                if (null == e.getKey()) {
                    correctEntry = e;
                }
            }

        }else {
            while(i.hasNext() && null == correctEntry) {
                Entry<K, V> e = i.next();
                if (key.equals(e.getKey())) {
                    correctEntry = e;
                }
            }
        }
        V oldValue = null;
        if (null != correctEntry) {
            oldValue = correctEntry.getValue();
            // TODO: 2018/10/11 为什么删除iterator就可以将entry删除？
            // entrySet是抽象的，由子类实现，如 hashmap Override这个方法，并在该方法中重写了remove()方法
            i.remove();
        }
        return oldValue;
    }

    public abstract Set<Entry<K, V>> entrySet();
}
