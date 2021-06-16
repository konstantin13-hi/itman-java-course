package tasks;

public class Task433 {
    public static long gcd(long x,long y){
        long c=0;
        for (long i= x;i!=0;i--){
            if (x%i==0 &&(y%i)==0){
                c=i;
                break;
            }
        }

        return c;
    }
}
