package tasks;

public class CountingSortTask {
   public static int[]  count(int[] array){
       int max =0;
       for (int i=0;i<array.length;i++){
           if (array[i]>max){
               max=array[i];
           }

       }
       int []count =new int[max+1];
       for (int i=0;i<count.length;i++){
           for (int j=1;j<count.length;j++){
               if (array[j-1]==i){
                   count[i]++;
               }

           }
       }
       return count;

    }
}
