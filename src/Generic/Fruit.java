package Generic;

/**
 * Created by yangyou on 2018/10/10.
 */
public class Fruit implements Comparable<Fruit> {

    private int calories;

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Fruit(int calories) {
        this.calories = calories;
    }

    @Override
    public int compareTo(Fruit o) {
        return this.calories - o.calories;
    }
}
