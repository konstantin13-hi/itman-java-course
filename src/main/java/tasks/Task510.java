package tasks;

import utils.ArrayUtils;

public class Task510 {
    public static int mostFrequent(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int result = 0;
        ArrayUtils.mergeSort(array);
        int count = 0;
        int element = array[array.length - 1];
        int secondCount = 0;
        for (int i = array.length - 1; 0 < i; i--) {

            if (array[i] == element) {
                count++;
                result=array[i];
            } else if (array[i] != element) {
               if (secondCount >= count) {
               result = array[i];}
                secondCount=count;
               count=1;
            }


        }
        if (secondCount >= count) {
            result = array[0];
        }

        return result;
    }
}