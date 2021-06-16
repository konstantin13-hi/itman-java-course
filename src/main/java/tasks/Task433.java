package tasks;

public class Task433 {
    public static long gcd(long x,long y){
        long c=0;
        for (int i= 1;i<x+1;i++){
            if (x%i==0 &&(y%i)==0){
                c=i;
            }
        }

        return c;
    }
}
