package corejava;

import java.util.Objects;

/**
 * Created by yangyou on 2018/10/12.
 */
public class ReferenceTest {

    private String a;

    private int b;

    public static void main(String[] args) {
        String a = null;

        String b = a;

        b = new String("");

        System.out.println(Objects.isNull(a));
    }

    public ReferenceTest(String a, int b) {
        this.a = a;
        this.b = b;
    }
    public ReferenceTest(int b, String a) {
        this.a = a;
        this.b = b;
    }


}
