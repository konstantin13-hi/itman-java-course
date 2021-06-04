package tasks;

public class Task406 {
    public static int findSecondMax(int[]array){
        int second=array[array.length-1];
        for(int i = 0; i<array.length;i++){
            int minIndex = i;
            for (int j=1;j<array.length;j++){
                if(array[minIndex]>array[j]){
                    minIndex= j;

                }
                    int t = array[minIndex];
                    array[minIndex] = array[i];
                    array[i]= t;
                }
            }


        return second;
    }



}
