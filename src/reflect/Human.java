package reflect;

/**
 * Created by yangyou on 2018/10/24.
 */
public abstract class Human implements Animal {


    @Override
    public void breath() {
        System.out.println("human breath");
    }

    @Override
    public void move() {
        System.out.println("human move");

    }

    public abstract void speak();
}
