package corejava;

import java.util.Objects;

/**
 * Created by yangyou on 2018/10/12.
 */
public class ReferenceTest {

    public static void main(String[] args) {
        String a = null;

        String b = a;

        b = new String("");

        System.out.println(Objects.isNull(a));
    }

}
