package tasks;

public class Task406 {
    public static int findSecondMax(int[]array){
        int a =0;
         int max= Integer.MIN_VALUE;
         for (int i = 0; i<array.length;i++){
            if (max<array[i]){
                max=array[i];
                a=i;

            }
         }
        int max1= Integer.MIN_VALUE;
         for (int i = 0; i<array.length;i++){
             if(max1<array[i]&& i!=a ) {
                 max1=array[i];

         }}




        return max1;
    }



}
