package stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yangyou on 2018/9/18.
 */
public class MapTest {
    public static void main(String[] args) {
        test2();
        test3();
        test4();
        test5();
    }

    //对于一张单词表，如何返回一张列表，列出里面各不相同的字符
//    ["hello","world"] 返回列表["h","e","l","o","w","r","d"]
    public static void test1() {
        List<String> dic = Arrays.asList("hello", "world");
        Set setDic = new HashSet<>();
        for(String s : dic) {
            String[] ss = s.split("");
            setDic.addAll(Arrays.asList(ss));
        }
        System.out.println(setDic);
    }
    public static void test2() {

        List<String> dic = Arrays.asList("hello", "world");
        List<String> s = dic.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(s);
    }

    public static void test3() {
        String[] aa = {"hello", "world"};
        List<String> s = Arrays.stream(aa).map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(s);

    }

    //给定一个数值列表，如何返回一个由平方根组成的列表
    //[1,4,6,7] [1,16,36,49]
    public static void test4() {
        int[] aa = {1,4,6,7};
        int[] cc = Arrays.stream(aa).map(num -> num * num).toArray();
        Arrays.stream(cc).forEach(num -> System.out.println(num));
        List<Integer> dd = Arrays.asList(1,4,6,7);
        List<Integer> ee = dd.stream().map(num -> num * num).collect(Collectors.toList());
        ee.stream().forEach(num -> System.out.println(num));
    }
    //给定两个数字列表，如何返回所有数对
    //[1,2,3] [4,5] 返回[1,4]，[1,5],[2,4],[2,5],[3,4],[3,5]
    public static void test5() {
        List<Integer> a1 = Arrays.asList(1,2,3);
        List<Integer> a2 = Arrays.asList(4,5);

        List<int[]> rr = a1.stream().flatMap(i -> a2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        rr.stream().forEach(a->
                System.out.println(a[0]));


    }



}
