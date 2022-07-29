package services.calculation;

public class Calculation {
    protected Operators operators;
    private double termFirst;
    private double termSecond;


    public enum Operators {
        PLUS {
            public int action(int x, int y) {
                return x + y;
            }
        },
        MINUS {
            public int action(int x, int y) {
                return x - y;
            }
        },
        MULTIPLY {
            public int action(int x, int y) {
                return x * y;
            }
        },
        DIVIDE {
            public int action(int x, int y) {
                return x / y;
            }
        };
        public abstract int action(int x, int y);
    }
}
