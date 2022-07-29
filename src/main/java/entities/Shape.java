package entities;

import java.util.ArrayList;
import java.util.List;

public interface Shape {
    static Shape minSquare(List list) {
        Shape shape = null;
        Shape result = null;
        double minSquare = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            shape = (Shape) list.get(i);
            double square = shape.calcSquare();
            if (minSquare > square) {
                minSquare = square;
                result = shape;
            }
        }
        return result;
    }

    static double averagePerimeters(List list) {
        Shape shape = null;
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            shape = (Shape) list.get(i);
            result += shape.calcPerimeter();
        }
        return Math.round(result);
    }


    double calcPerimeter();

    double calcSquare();

    String toString();

    boolean equals(Object object);


}
