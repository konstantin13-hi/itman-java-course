package benchmarks;

import entities.Event;
import utils.ArrayUtils;

import java.util.Random;

public class SortBenchmark {
    public static int[] randomArray(int n, int min, int max) {
        int[] randomArray = new int[n];
        for (int i = 0; i < n; i++) {
            randomArray[i] = (int) (Math.random() *(Math.abs(min)+Math.abs(max)))+min;

        }
        return randomArray;


    }

    public static Event[] randomEvents(int n, int min, int max) {
        Event[] events = new Event[n];
        Random random = new Random();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            int length = random.nextInt(21);
            for (int j = 0; j <= length; j++) {
                strings[i] += (char) (Math.random() * 26 + 97);
            }

        }
        for (int i = 0; i < n; i++) {
            int year = (int) (Math.random() *(Math.abs(min)+Math.abs(max)))+min;
            int month = random.nextInt(11 + 1) + 1;
            int day = random.nextInt(30 + 1) + 1;
            String name = strings[i];
            events[i] = new Event(year, month, day, name);

        }
        return events;
    }

    public static void main(String[] args) {
        int[] bsp1 = randomArray(10_000, -10_000, 10_000);
        int[] bsp2 = randomArray(10_000, -1_000_000_000, 1_000_000_000);
        int[] bsp3 = randomArray(100_000, -10_000, 10_000);
        int[] bsp4 = randomArray(100_000, -1_000_000_000, 1_000_000_000);
        Event[] bso1 = randomEvents(10_000, 2000, 2021);
        Event[] bso2 = randomEvents(10_000, -1_000_000, 1_000_000);
        Event[] bso3 = randomEvents(100_000, 2000, 2021);
        Event[] bso4 = randomEvents(100_000, -1_000_000, 1_000_000);
        long time = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp1);
        System.out.println(System.currentTimeMillis() - time);
        long time2 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp2);
        System.out.println(System.currentTimeMillis() - time2);
        long time3 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp3);
        System.out.println(System.currentTimeMillis() - time3);
        long time4 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp4);
        System.out.println(System.currentTimeMillis() - time4);
        long time5 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso1);
        System.out.println(System.currentTimeMillis() - time5);
        long time6 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso2);
        System.out.println(System.currentTimeMillis() - time6);
        long time7 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso3);
        System.out.println(System.currentTimeMillis() - time7);
        long time8 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso4);
        System.out.println(System.currentTimeMillis() - time8);


    }

}
