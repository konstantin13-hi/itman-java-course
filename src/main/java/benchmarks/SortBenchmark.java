package benchmarks;

import entities.Event;
import utils.ArrayUtils;

import java.util.Random;

public class SortBenchmark {
    /**
     * Create array with random elements and length.
     *
     * @param n   the first term
     * @param min the second term
     * @param max the third term
     * @return array with random elements and length
     * @cpu O(n)
     * @ram O(n)
     */
    public static int[] randomArray(int n, int min, int max) {
        int diff = max - min;
        Random random = new Random(1);
        int[] randomArray = new int[n];
        for (int i = 0; i < n; i++) {
            randomArray[i] =
                    random.nextInt(diff) + min;

        }
        return randomArray;


    }

    /**
     * Create array with random elements and length.
     *
     * @param n   the first
     * @param min the second term
     * @param max the third term
     * @return array with random elements and length
     * @cpu O(n)
     * @ram O(n)
     */
    public static Event[] randomEvents(int n, int min, int max) {
        Event[] events = new Event[n];
        Random random = new Random(1);
        int diff = max - min;
        for (int i = 0; i < n; i++) {
            long number = random.nextLong();
            String name = Long.toString(number);
            int year = random.nextInt(diff) + min;
            int month = random.nextInt(11 + 1) + 1;
            int day = random.nextInt(30 + 1) + 1;
            events[i] = new Event(year, month, day, name);
        }
        return events;
    }

    // bsp1: 96ms
    // bsp2: 97ms
    // bsp3: 16317ms
    // bsp4: 16421ms
    // bso1: 770ms
    // bso2: 961ms
    // bso3: 94340ms
    // bso4: 108736ms
    // csp1: 3ms
    // csp2: OutOfMemory
    // csp3: 5ms
    // csp4: OutOfMemory
    // cso1: 15ms
    // cso2: OutOfMemory
    // cso3: 23ms
    // cso4: OutOfMemory
    // msp1: 4ms
    // msp2: 4ms
    // msp3: 50s
    // msp4: 72ms
    // mso1: 12ms
    // mso2: 14ms
    // mso3: 42ms
    // mso4: 94ms
    public static void main(String[] args) {
        int[] bsp1 = randomArray(10_000, -10_000, 10_000);
        long time = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp1);
        System.out.println(System.currentTimeMillis() - time);
        int[] bsp2 = randomArray(10_000, -1_000_000_000, 1_000_000_000);
        long time2 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp2);
        System.out.println(System.currentTimeMillis() - time2);
        int[] bsp3 = randomArray(100_000, -10_000, 10_000);
        long time3 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp3);
        System.out.println(System.currentTimeMillis() - time3);
        int[] bsp4 = randomArray(100_000, -1_000_000_000, 1_000_000_000);
        long time4 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp4);
        System.out.println(System.currentTimeMillis() - time4);
        Event[] bso1 = randomEvents(10_000, 2000, 2021);
        long time5 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso1, new Event.EventComparator());
        System.out.println(System.currentTimeMillis() - time5);
        Event[] bso2 = randomEvents(10_000, -1_000_000, 1_000_000);
        long time6 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso2, new Event.EventComparator());
        System.out.println(System.currentTimeMillis() - time6);
        Event[] bso3 = randomEvents(100_000, 2000, 2021);
        long time7 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso3, new Event.EventComparator());
        System.out.println(System.currentTimeMillis() - time7);
        Event[] bso4 = randomEvents(100_000, -1_000_000, 1_000_000);
        long time8 = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso4, new Event.EventComparator());
        System.out.println(System.currentTimeMillis() - time8);
        int[] csp1 = randomArray(10_000, -10_000, 10_000);
        long time9 = System.currentTimeMillis();
        ArrayUtils.countingSort(csp1);
        System.out.println(System.currentTimeMillis() - time9);
        int[] csp2 = randomArray(10_000, -1_000_000_000, 1_000_000_000);
        long time10 = System.currentTimeMillis();
        ArrayUtils.countingSort(csp2);
        System.out.println(System.currentTimeMillis() - time10);
        int[] csp3 = randomArray(100_000, -10_000, 10_000);
        long time11 = System.currentTimeMillis();
        ArrayUtils.countingSort(csp3);
        System.out.println(System.currentTimeMillis() - time11);
        int[] csp4 = randomArray(100_000, -1_000_000_000, 1_000_000_000);
        long time12 = System.currentTimeMillis();
        ArrayUtils.countingSort(csp4);
        System.out.println(System.currentTimeMillis() - time12);
        Event[] cso1 = randomEvents(10_000, 2000, 2021);
        long time13 = System.currentTimeMillis();
        ArrayUtils.countingSort(cso1, event -> event.getYear() * 372 + event.getMonth() * 31 + event.getDay());
        System.out.println(System.currentTimeMillis() - time13);
        Event[] cso2 = randomEvents(10_000, -1_000_000, 1_000_000);
        long time14 = System.currentTimeMillis();
        ArrayUtils.countingSort(cso2, event -> event.getYear() * 372 + event.getMonth() * 31 + event.getDay());
        System.out.println(System.currentTimeMillis() - time14);
        Event[] cso3 = randomEvents(100_000, 2000, 2021);
        long time15 = System.currentTimeMillis();
        ArrayUtils.countingSort(cso3, event -> event.getYear() * 372 + event.getMonth() * 31 + event.getDay());
        System.out.println(System.currentTimeMillis() - time15);
        Event[] cso4 = randomEvents(100_000, -1_000_000, 1_000_000);
        long time16 = System.currentTimeMillis();
        ArrayUtils.countingSort(cso4, event -> event.getYear() * 372 + event.getMonth() * 31 + event.getDay());
        System.out.println(System.currentTimeMillis() - time16);
        int[] msp1 = randomArray(10_000, -10_000, 10_000);
        long time17 = System.currentTimeMillis();
        ArrayUtils.mergeSort(msp1);
        System.out.println(System.currentTimeMillis() - time17);
        int[] msp2 = randomArray(10_000, -1_000_000_000, 1_000_000_000);
        long time18 = System.currentTimeMillis();
        ArrayUtils.mergeSort(msp2);
        System.out.println(System.currentTimeMillis() - time18);
        int[] msp3 = randomArray(100_000, -10_000, 10_000);
        long time19 = System.currentTimeMillis();
        ArrayUtils.mergeSort(msp3);
        System.out.println(System.currentTimeMillis() - time19);
        int[] msp4 = randomArray(100_000, -1_000_000_000, 1_000_000_000);
        long time20 = System.currentTimeMillis();
        ArrayUtils.mergeSort(msp4);
        System.out.println(System.currentTimeMillis() - time20);
        Event[] mso1 = randomEvents(10_000, 2000,
                2021);
        long time21 = System.currentTimeMillis();
        ArrayUtils.mergeSort(mso1, new Event.EventComparator());
        System.out.println(System.currentTimeMillis() - time21);
        Event[] mso2 = randomEvents(10_000, -1_000_000,
                1_000_000);
        long time22 = System.currentTimeMillis();
        ArrayUtils.mergeSort(mso2, new Event.EventComparator());
        System.out.println(System.currentTimeMillis() - time22);
        Event[] mso3 = randomEvents(100_000, 2000,
                2021);
        long time23 = System.currentTimeMillis();
        ArrayUtils.mergeSort(mso3, new Event.EventComparator());
        System.out.println(System.currentTimeMillis() - time23);
        Event[] mso4 = randomEvents(100_000, -1_000_000,
                1_000_000);
        long time24 = System.currentTimeMillis();
        ArrayUtils.mergeSort(mso4, new Event.EventComparator());
        System.out.println(System.currentTimeMillis() - time24);
    }

}
