package tasks;

public class Task432 {
    public static long[] calcPrimeNumbers(long x) {
        int a=0;
        int a1=0;
        long []c=new long [1000];



        for (int i = 2; true; i++) {
            if (x % i == 0) {
                a++;
                c[a1]=i;
                a1++;
                for (int i1 = 0; true; i1++) {
                    if (x % i == 0) {
                        x = x / i;
                    } else {
                        break;
                    }

                }
            }
            if (x < i) {
                break;
            }
            if (i >20&a==0){
                return new long[]{x};
            }
        }
        long[]c1=new long[a];
        System.arraycopy(c, 0, c1, 0, c1.length);
        return c1;



    }
}
