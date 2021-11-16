package tasks;

public class CountingSortTask {
    public static int[] count(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }

        }
        int[] count = new int[max + 1];
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i) {
                    count[i]++;
                }

            }
        }
        return count;

    }

    public static int[] restore(int[] array) {
        int[] restore = new int[array.length - 1];
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                restore[length] = i;
                length++;

            }
        }

        return restore;

    }
}
