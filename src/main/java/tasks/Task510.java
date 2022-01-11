package tasks;

import utils.ArrayUtils;

public class Task510 {
    public static int mostFrequent(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int []t =new int[array.length];
        System.arraycopy(array,0,t,0,array.length);
        int result = 0;
        ArrayUtils.mergeSort(t);
        int count = 0;
        int element = t[array.length - 1];
        int secondCount = 0;
        int finalCount=0;
        for (int i = array.length - 1; 0 < i; i--) {

            if (t[i] == element) {
                count++;
                result=t[i];
            } else if (t[i] != element) {
                element=t[i];
               if (finalCount<= count) {
                   finalCount=count;
               result = t[i+1];}
                count=1;


            }


        }
        if (finalCount <= count) {
            result = t[0];
        }

        return result;
    }
}