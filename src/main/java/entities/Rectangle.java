package entities;

import java.util.Objects;

public class Rectangle implements Shape {
    private double firstSide;
    private double secondSide;

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (firstSide + secondSide);
    }

    @Override
    public double calcSquare() {
        return firstSide * secondSide;
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
