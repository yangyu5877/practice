package reflect;

/**
 * Created by yangyou on 2018/10/24.
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException {
        test();
    }




    public static void test() throws ClassNotFoundException {
        Class<User> userClass = User.class;
        User user = new ReflectTest().new User();
        Class<? extends User> userClass1 = user.getClass();

        Class<?> userClass2 = Class.forName("reflect.ReflectTest$User");

        System.out.println("name :" + userClass.getName());
        System.out.println("canonicalName :" + userClass1.getCanonicalName());
        System.out.println("simpleName :" + userClass2.getSimpleName());

        System.out.println(userClass == userClass1);
        System.out.println(userClass == userClass2);
        System.out.println(userClass1 == userClass2);

    }



    class User {

        private String name;

        private int age;

        private Address address;
    }


    class Address {

        private String location;

    }

}
