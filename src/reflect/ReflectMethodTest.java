package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yangyou on 2018/10/25.
 */
public class ReflectMethodTest {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        test();

        test2();

        test3();

        test4();
    }

    public static void test() throws ClassNotFoundException {
        Class<?> boyClazz = Class.forName("reflect.Boy");
        Method[] methods = boyClazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    public static void test2() throws ClassNotFoundException {
        Class<?> boyClazz = Class.forName("reflect.Boy");
        Method[] methods = boyClazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    public static void test3() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> boyClazz = Class.forName("reflect.Boy");
        Method getInfo = boyClazz.getDeclaredMethod("getInfo", String.class, int.class);
        String methodName = getInfo.getName();
        System.out.println(methodName);
        String info = (String)getInfo.invoke(boyClazz.newInstance(), "hello", 1);
        System.out.println(info);
    }

    public static void test4() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //获得私有方法的访问
        Class<?> boyClazz = Class.forName("reflect.Boy");
        Method sayHello = boyClazz.getDeclaredMethod("sayHello");
        sayHello.setAccessible(true);
        sayHello.invoke(boyClazz.newInstance());



    }






}
