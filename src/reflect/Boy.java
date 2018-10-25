package reflect;

import javax.annotation.Resource;
import javax.annotation.WillClose;

/**
 * Created by yangyou on 2018/10/25.
 */

@WillClose
public class Boy extends Man {


    public Boy() {}

    private Boy(String schoola) {
        this.school = schoola;
    }



    public Boy(String school, int height, int age) {
        this.school = school;
        this.age = age;
        this.height = height;
    }


    private String school;

    private int height;

    private int age;



    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }


    public String getInfo(String school, int age) {


        System.out.println("getInfo start .....");

        String info = school + "I am " + age + "years old";

        return info;
    }


    private void sayHello() {
        this.breath();
        this.move();
    }

    public void sayHello2() {
        sayHello();
    }


}
