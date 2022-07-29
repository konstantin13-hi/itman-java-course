package entities;

import java.util.Objects;

public class Circle implements Shape {
    private double radius;
    private double PI = 3.14;

    public double getRadius() {
        return radius;
    }

    public double getPI() {
        return PI;
    }

    @Override
    public double calcPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public double calcSquare() {
        return Math.pow(radius, 2) * PI;
    }

    @Override
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        return Objects.equals(this, that);
    }

    public String toString(){
        return "";
    }

}
