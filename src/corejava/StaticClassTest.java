package corejava;

/**
 * Created by yangyou on 2018/10/10.
 */
public class StaticClassTest {
    int a;
    private static int b;

    public static void main(String[] args) {
        new StaticClass();
        StaticClass.haha();
        aaa();
    }



    static class StaticClass {

        public void hah() {

        }
        public static void haha() {

        }
    }

    public static void aaa() {

    }
}
