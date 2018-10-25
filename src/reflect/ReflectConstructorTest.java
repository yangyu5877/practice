package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yangyou on 2018/10/25.
 */
public class ReflectConstructorTest {


    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        test1();
        test2();
        test3();
        test4();
    }


    public static void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Boy> boyClass = Boy.class;
        Constructor<Boy> boyConstructor = boyClass.getConstructor();
        Boy boy = boyConstructor.newInstance();
        boy.setAge(21);
        int age = boy.getAge();
        System.out.println(age);
    }


    public static void test2() {
        Class<Boy> clazz = Boy.class;

        //获得类的所有构造函数，包括父类的构造函数 ??
        Constructor<?>[] cs = clazz.getConstructors();
        for (Constructor c : cs) {
            System.out.println(c);
        }
    }


    public static void test3() {
        Class<Boy> clazz = Boy.class;

        Constructor<?>[] cs = clazz.getDeclaredConstructors();

        for (Constructor c : cs) {
            System.out.println(c);
        }
    }

    public static void test4() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        Class<Boy> boyClazz = Boy.class;

        Constructor<Boy> constructor = boyClazz.getConstructor();
        Constructor<Boy> constructor2 = boyClazz.getDeclaredConstructor();


        // TODO: 2018/10/25 declaredConstructor 和 constructor 有什么区别？ 后者只返回public 的构造函数

        Constructor<Boy> constructor3 = boyClazz.getDeclaredConstructor(String.class, int.class, int.class);

        Constructor<Boy> constructor4 = boyClazz.getConstructor(String.class, int.class, int.class);


        //访问私有构造函数
        Class<?> boyClazz3 = Class.forName("reflect.Boy");
        Constructor<?> boy33Constructor = boyClazz3.getDeclaredConstructor(String.class);
        boy33Constructor.setAccessible(true);
        Boy boy33 = (Boy) boy33Constructor.newInstance("yangyu test");

        System.out.println("boy school : " + boy33.getSchool());


        Boy boy = constructor.newInstance();
//        Boy boy1 = constructor2.newInstance("yang", 1, 2); //illegal
        Boy boy3 = constructor3.newInstance("yangyu", 1, 2);
        Boy boy4 = constructor4.newInstance("yangyu", 1, 2);

        System.out.println(boy4.getAge());
        System.out.println(boy4.getSchool());

        System.out.println(boy3.getAge());
        System.out.println(boy3.getSchool());

    }









}
