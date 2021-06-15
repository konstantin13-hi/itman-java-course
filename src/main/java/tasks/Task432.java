package tasks;

public class Task432 {
    public static long[] calcPrimeNumbers(long x) {
        int a=0;
        int a1=0;
        long []c=new long [(int)x];



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
        }
        long[]c1=new long[a];
        for (int i=0;i<c1.length;i++){
            c1[i]=c[i];
        }
        return c1;



    }
}
