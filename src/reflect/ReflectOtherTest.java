package reflect;

import javax.annotation.WillClose;
import java.lang.annotation.Annotation;

/**
 * Created by yangyou on 2018/10/25.
 */
public class ReflectOtherTest {


    public static void main(String[] args) throws ClassNotFoundException {
        test();
        test2();
    }

    public static void test() throws ClassNotFoundException {
        Class<?> boyClazz = Class.forName("reflect.Boy");
        Annotation[] annotations =  boyClazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
    }

    public static void test2() throws ClassNotFoundException {
        Class<?> boyClazz = Class.forName("reflect.Boy");
        WillClose w = boyClazz.getAnnotation(WillClose.class);
        System.out.println(w.getClass());
        Boy boy = new Boy();
        System.out.println(boy.getClass().getSimpleName());
    }

    //判断方法的参数是不是基础类型或数组





}
