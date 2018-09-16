package lambda;

import java.util.function.Function;

/**
 * Created by yangyou on 2018/9/15.
 */
public class LetterTest {

    public static void main(String[] args) {
        Function<String, String> f1 = LetterTest::addHeader;
        Function<String, String> f2 = LetterTest::addFooter;
        Function<String, String> f3 = LetterTest::checkSpell;
        Function<String, String> f4 = f1.andThen(f3).andThen(f2);
        String ss = f4.apply("sdfdsf dsfdf 33f lamda");
        System.out.println(ss);
    }

    public static String addHeader(String s) {
        return "this is header" + "\n" + s + "\n";
    }

    public static String addFooter(String s) {
        return s + "this is footer" + "\n";
    }

    public static String checkSpell(String s) {
       return s.replace("lamda", "lambda");
    }


}
