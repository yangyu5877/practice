package lambda;

/**
 * Created by yangyou on 2018/9/10.
 */
public class Apple extends MethodReferenceTest.Fruit {

    private String color;

    private Integer weight;

    public Apple() {}

    public Apple(String _color, Integer _weight) {
        this.color = _color;
        this.weight = _weight;
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public static boolean isHeavy(Apple a) {
        return a.getWeight() > 100 ? true : false;
    }
}
