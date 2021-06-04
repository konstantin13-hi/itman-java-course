package tasks;

public class Task406 {
    public static int findSecondMax(int[]array){
        for(int i = 0; i<array.length;i++){
            int minIndex = i;
            for (int j=i+1;j<array.length;j++){
                if(array[minIndex]>array[j]){
                    minIndex= j;
                }
            }
                    int t = array[minIndex];
                    array[minIndex] = array[i];
                    array[i]= t;

            }
        int second=array[array.length-2];


        return second;
    }



}
