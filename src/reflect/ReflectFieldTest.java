package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by yangyou on 2018/10/25.
 */
public class ReflectFieldTest {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        test1();
        test2();

        test3();
    }


    public static void test1() {

        Boy boy = new Boy();
        Class<? extends Boy> boyClazz = boy.getClass();

        Field[] fs = boyClazz.getDeclaredFields();
        for (Field f : fs) {
            System.out.println(f);
        }

    }

    public static void test2() throws ClassNotFoundException {
    //只获得public field
        Class<?> boyClazz = Class.forName("reflect.Boy");
        Field[] fs = boyClazz.getFields();
        for (Field f : fs) {
            System.out.println(f);
        }
    }


    public static void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Boy> boyClass = Boy.class;

        Constructor<Boy> constructor = boyClass.getConstructor(String.class, int.class, int.class);

        Boy boy = constructor.newInstance("yaa", 123, 33);

        Field schoolField = boyClass.getDeclaredField("school");

        schoolField.setAccessible(true);

        System.out.println("field name :" + schoolField.getName());

        String value = (String) schoolField.get(boy);

        System.out.println("value : " + value);
    }





}
