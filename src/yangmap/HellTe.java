package yangmap;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

/**
 * Created by yangyou on 2018/10/13.
 */
public class HellTe {

    public static void main(String[] args) {
        Map<String, String> a = Maps.newHashMap();
        a.put("dsf", "aazfyy");
        a.put("123", "44422");
        a.put("345", "ss");
        System.out.println(a);
        Map<Object, String> b = Maps.newHashMap();
        b.put(b, "12");
        System.out.println(b);
    }

    class TestMap extends YangAbstractMap<String, String> {
        @Override
        public Set<Entry<String, String>> entrySet() {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public String put(String key, String value) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ? extends String> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }
    }
    TestMap testMap = new TestMap();

}
