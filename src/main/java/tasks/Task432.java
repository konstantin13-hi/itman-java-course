package tasks;

public class Task432 {
    /**
     * Find prime divisors in ascending .
     *
     * @param x the first term
     * @return new array of prime divisors in ascending.
     * @cpu O(n)
     * @ram O(1)
     */
    public static long[] calcPrimeNumbers(long x) {

        long sqrtTermX = (long) Math.sqrt(x);
        long duplicateForCycle = x;
        long[] arrayThatStores1000EmptyElements = new long[1000];
        if (x < 5) {
            return new long[]{x};
        }
        int indexForArrayThatStores1000EmptyElements = 0;//variable indicates the dimension of the array с
        int indexForArrayOfPrimeDivisorsInAscending = 0;
        for (int i = 2; i < duplicateForCycle; i++) {
            if (x % i == 0) {
                indexForArrayOfPrimeDivisorsInAscending++;
                arrayThatStores1000EmptyElements[indexForArrayThatStores1000EmptyElements] = i;
                indexForArrayThatStores1000EmptyElements++;
                for (int i1 = 0; i1 < x; i1++) { //5 =1
                    if (x % i == 0) {
                        x = x / i;
                    }
                }
            }
            if (i >= sqrtTermX && indexForArrayOfPrimeDivisorsInAscending == 0) {
                return new long[]{x};
            }

        }
        long[] arrayOfPrimeDivisorsInAscending = new long[indexForArrayOfPrimeDivisorsInAscending];
        System.arraycopy(arrayThatStores1000EmptyElements, 0, arrayOfPrimeDivisorsInAscending, 0, arrayOfPrimeDivisorsInAscending.length);
        return arrayOfPrimeDivisorsInAscending;
    }
}
