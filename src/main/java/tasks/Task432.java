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
        long[] arrayThatStores1000Elements = new long[1000];
        if (x == 5||x==1||x==2) {
            return new long[]{x};
        }
        int indexForArrayThatStores1000Elements = 0;
        for (int i = 2; i < duplicateForCycle; i++) {
            if (x % i == 0) {
                arrayThatStores1000Elements[indexForArrayThatStores1000Elements] = i;
                indexForArrayThatStores1000Elements++;
                for (int i1 = 0; i1 < x; i1++) { //5 =1
                    if (x % i == 0) {
                        x = x / i;
                    }
                }
            }
            if (i >= sqrtTermX && indexForArrayThatStores1000Elements== 0) {
                return new long[]{x};
            }

        }
        long[] arrayOfPrimeDivisorsInAscending = new long[indexForArrayThatStores1000Elements];
        System.arraycopy(arrayThatStores1000Elements, 0, arrayOfPrimeDivisorsInAscending, 0, arrayOfPrimeDivisorsInAscending.length);
        return arrayOfPrimeDivisorsInAscending;
    }
}
