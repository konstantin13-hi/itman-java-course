package entities;

import java.util.Objects;

public class Square implements Shape {
    public double getSide() {
        return side;
    }

    private double side;

    @Override
    public double calcPerimeter() {
        return side * 4;
    }

    @Override
    public double calcSquare() {
        return Math.pow(side, 2);
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
