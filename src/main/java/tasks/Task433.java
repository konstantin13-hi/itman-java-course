package tasks;

public class Task433 {
    public static long gcd(long x,long y){
        long []a=new long[Math.toIntExact(x)];
        long []b=new long[Math.toIntExact(y)];
        int a1=0;
        int b1=0;
        long c=0;
        int h1=0;
        for(int i=1;i<x+1;i++){
            if(x%i==0){
                a[h1]=i;
                h1++;
                a1++;
            }
        }
        int h=0;
        for(int i=1;i<y+1;i++){
            if(y%i==0){
                b[h]=i;
                h++;
                b1++;
            }
        }
        long[]a3=new long[a1];
        long[]b3=new long[b1];
        for (int i=0;i<a3.length;i++ ){
            a3[i]=a[i];
        }
        for (int i=0;i<b3.length;i++ ){
            b3[i]=b[i];
        }
        for (int i=0;i<a3.length;i++){
            for (int j=0;j<b3.length;j++){
                if(a3[i]==b3[j]){
                    c=a3[i];
                }

        }}
        return c;
    }
}
