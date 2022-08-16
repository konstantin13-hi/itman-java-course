package services.calculation;

public class Calculation {
    protected Operators operators;
    private double termFirst;
    private double termSecond;

    /**
     *Creates enum class for Operators.
     */
    public enum Operators {
        PLUS {
            /**
             * Makes plus with x and y.
             *
             * @cpu O(1)
             * @ram O(1)
             *
             * @param x the first term
             * @param y the second term
             * @return result
             */
            public int action(int x, int y) {
                return x + y;
            }
        },
        MINUS {
            /**
             * Makes minus with x and y.
             *
             * @cpu O(1)
             * @ram O(1)
             *
             * @param x the first term
             * @param y the second term
             * @return result
             */
            public int action(int x, int y) {
                return x - y;
            }
        },
        MULTIPLY {
            /**
             * Makes multiply with x and y.
             *
             * @cpu O(1)
             * @ram O(1)
             *
             * @param x the first term
             * @param y the second term
             * @return result
             */
            public int action(int x, int y) {
                return x * y;
            }
        },
        DIVIDE {
            /**
             * Makes divide with x and y.
             *
             * @cpu O(1)
             * @ram O(1)
             *
             * @param x the first term
             * @param y the second term
             * @return result
             */
            public int action(int x, int y) {
                return x / y;
            }
        };

        /**
         * Makes operation with x and y.
         *
         * @cpu O(1)
         * @ram O(1)
         *
         * @param x the first term
         * @param y the second term
         * @return result
         */
        public abstract int action(int x, int y);
    }
}
