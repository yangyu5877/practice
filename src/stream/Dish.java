package stream;

import java.util.Objects;

/**
 * Created by yangyou on 2018/9/15.
 */
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int colories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int colories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.colories = colories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getColories() {
        return colories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {MEAT, FISH, OTHER};

    @Override
    public String toString() {
        return this.getName() + " " + this.getColories() + " " + this.isVegetarian() + " " + this.getType();
    }
}
