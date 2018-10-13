package yangmap;


import java.util.*;

/**
 * Created by yangyou on 2018/10/10.
 */
public abstract class YangAbstractMap<K, V> implements YangMap<K, V> {
    // TODO: 2018/10/11 由子类invoke???
    protected YangAbstractMap() {}



    public int size() {
        return entrySet().size();
    }



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


    transient Set<K> keySet;
    transient Collection<V> values;


    public Set<K> keySet() {
        Set<K> keys = keySet;
        if (null == keys) {
            keys = new AbstractSet<K>() {
                @Override
                public Iterator<K> iterator() {
                    return new Iterator<K>() {
                        @Override
                        public boolean hasNext() {
                            return entrySet().iterator().hasNext();
                        }

                        @Override
                        public K next() {
                            return entrySet().iterator().next().getKey();
                        }
                    };
                }

                @Override
                public int size() {
                    return YangAbstractMap.this.size();
                }

                @Override
                public boolean contains(Object o) {
                    return YangAbstractMap.this.containsKey(o);
                }

            };
        }
        keySet = keys;

        return keySet;


    }


    public Collection<V> values() {
        //先读到local variable 中，进行判断，而不是直接进行判断， 避免多线程情况出现不一致
        Collection<V> vals = values;
        if (null == vals) {
            vals = new AbstractCollection<V>() {
                @Override
                public Iterator<V> iterator() {
                    return new Iterator<V>() {
                        private Iterator<Entry<K, V>> i = entrySet().iterator();

                        @Override
                        public boolean hasNext() {
                            return i.hasNext();
                        }

                        @Override
                        public V next() {
                            return i.next().getValue();
                        }

                        @Override
                        public void remove() {
                            i.remove();
                        }
                    };
                }
                @Override
                public int size() {
                    //不能使用this.size()   因为this.size() 指的是这个匿名函数类
                    return YangAbstractMap.this.size();
                }

                @Override
                public boolean contains(Object o) {
                    return YangAbstractMap.this.containsValue(o);
                }
            };
            values = vals;
        }

        return values;
    }

    public abstract Set<Entry<K, V>> entrySet();



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Map))
            return false;

        Map<?,?> m = (Map<?,?>) o;
        if (m.size() != this.size())
            return false;

        Iterator<Entry<K, V>> i = entrySet().iterator();
        while(i.hasNext()) {
            Entry<K, V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            if (null == value) {
                if (!(m.get(key) == null && m.containsKey(key))) {
                    return false;
                }
            }else {
                if (!(m.containsKey(key) && value.equals(m.get(key)))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        Iterator<Entry<K, V>> i = entrySet().iterator();

        //只有if没有else情况，  不管前面的if是否成功， 后面的if都会执行， 如果if中有return 例外

        if (!i.hasNext()) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("{");

        while(i.hasNext()) {
            Entry<K, V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key == this ? "{thisMap}" : key);
            sb.append(":");
            sb.append(value == this ? "{thisMap}" : value);
            sb.append(",");
        }

        sb.append("}");
        return sb.toString();


    }


}
