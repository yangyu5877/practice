package Generic;

/**
 * Created by yangyou on 2018/10/10.
 */
public class GenericTest {

//    public static void main(String[] args) {
//        test1();
//    }
//
//    public static void test1() {
//        Man m = new Man();
//        Woman w = new Woman();
//        Boy b = new Boy();
//        Girl g = new Girl();
//        Company<Person> c = new Company<>();
//        c.setHuman(m);
//        c.setHuman(w);
//        c.setHuman(b);
//        c.setHuman(g);
//    }
//
//    public static void test11() {
//        Man m = new Man();
//        Woman w = new Woman();
//        Boy b = new Boy();
//        Girl g = new Girl();
//        Company<?> c = new Company<>();
//        c.setHuman(m);
//        c.setHuman(w);
//        c.setHuman(b);
//        c.setHuman(g);
//    }
//
//    public static  <T> void test111() {
//        Man m = new Man();
//        Woman w = new Woman();
//        Boy b = new Boy();
//        Girl g = new Girl();
//        Company<T extends Person> c = new Company<>(); //illegal
//        Company<T> cc = new Company<T>();
//        c.setHuman((T) m);
//        c.setHuman((T) w);
//        c.setHuman(b);
//        c.setHuman(g);
//
//        cc.setHuman(m);
//        cc.setHuman(w);
//        cc.setHuman(b);
//        cc.setHuman(g);
//
//
//    }
//
//
//
//    public static void test2() {
//        Man m = new Man();
//        Woman w = new Woman();
//        Boy b = new Boy();
//        Girl g = new Girl();
//        Company<? extends Person> c = new Company<>();
//        c.setHuman(m);
//        c.setHuman(w);
//        c.setHuman(b);
//        c.setHuman(g);
//        Person p = c.getHuman();
//    }
//
//    public static void test22() {
//        Man m = new Man();
//        Woman w = new Woman();
//        Boy b = new Boy();
//        Girl g = new Girl();
//        Company<? super Person> c = new Company<>();
//        c.setHuman(m);
//        c.setHuman(w);
//        c.setHuman(b);
//        c.setHuman(g);
//        Person p =  c.getHuman(); //illegal
//        Person p = (Person) c.getHuman(); //强制类型转换
//    }
//
//
//    public static void test3() {
//        Man m = new Man();
//        Woman w = new Woman();
//        Boy b = new Boy();
//        Girl g = new Girl();
//        Company<? extends Man> c = new Company<>();
//        c.setHuman(m);
//        c.setHuman(w);
//        c.setHuman(b);
//        c.setHuman(g);
//    }
//
//    public static void test5() {
//        Man m = new Man();
//        Woman w = new Woman();
//        Boy b = new Boy();
//        Girl g = new Girl();
//        Company<? super Man> c = new Company<>();
//        c.setHuman(m);
//        c.setHuman(w);
//        c.setHuman(b);
//        c.setHuman(g);
//    }
//
//    public static void test4() {
//        Man m = new Man();
//        Woman w = new Woman();
//        Boy b = new Boy();
//        Girl g = new Girl();
//        Company<? extends Woman> c = new Company<>();
//        c.setHuman(m);
//        c.setHuman(w);
//        c.setHuman(b);
//        c.setHuman(g);
//    }
}
