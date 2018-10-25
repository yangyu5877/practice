package reflect;

/**
 * Created by yangyou on 2018/10/24.
 */
public class Man extends Human {

    private String name;

    private int age;

    public Man() {}

    public Man(String name, int age) {
        this.age = age;
        this.name = name;
    }


    @Override
    public void speak() {
        System.out.println("man is speaking");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
