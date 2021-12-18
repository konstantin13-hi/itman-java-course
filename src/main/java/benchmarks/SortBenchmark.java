package benchmarks;

import entities.Event;
import tasks.Task408;

import java.util.Random;

public class SortBenchmark {
    public static int[] randomArray(int n, int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int[] randomArray = new int[n];
        for (int i = 0; i < n; i++) {
            randomArray[i] =
                    random.nextInt(diff ) + min;

        }
        return randomArray;


    }

    public static Event[] randomEvents(int n, int min, int max) {
        Event[] events = new Event[n];
        Random random = new Random();
        int diff = max - min;
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            long number= random.nextLong() * 20;
            strings[i]=Long.toString(number);
        //    int length = random.nextInt(21);
         ///   for (int j = 0; j <= length; j++) {
         //       strings[i] += (char) (Math.random() * 26 + 97);
         //   }

        }
        for (int i = 0; i < n; i++) {
            int year = random.nextInt(diff ) + min;
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
        Task408.bubbleSort(bsp1);
        System.out.println(System.currentTimeMillis() - time);
        long time2 = System.currentTimeMillis();
        Task408.bubbleSort(bsp2);
        System.out.println(System.currentTimeMillis() - time2);
        long time3 = System.currentTimeMillis();
        Task408.bubbleSort(bsp3);
        System.out.println(System.currentTimeMillis() - time3);
        long time4 = System.currentTimeMillis();
        Task408.bubbleSort(bsp4);
        System.out.println(System.currentTimeMillis() - time4);
        long time5 = System.currentTimeMillis();
        Task408.sort(bso1);
        System.out.println(System.currentTimeMillis() - time5);
        long time6 = System.currentTimeMillis();
        Task408.sort(bso2);
        System.out.println(System.currentTimeMillis() - time6);
        long time7 = System.currentTimeMillis();
        Task408.sort(bso3);
        System.out.println(System.currentTimeMillis() - time7);
        long time8 = System.currentTimeMillis();
        Task408.sort(bso4);
        System.out.println(System.currentTimeMillis() - time8);
        int []csp1 =randomArray(10_000, -10_000, 10_000);
        int []csp2 =randomArray(10_000, -1_000_000_000, 1_000_000_000);
        int []csp3 =randomArray(100_000, -10_000, 10_000);
        int []csp4 =randomArray(100_000, -1_000_000_000, 1_000_000_000);
        long time9 = System.currentTimeMillis();
        Task408.countingSort(csp1);
        System.out.println(System.currentTimeMillis() - time9);
        long time10 = System.currentTimeMillis();
        Task408.countingSort(csp2);
        System.out.println(System.currentTimeMillis() - time10);
        long time11 = System.currentTimeMillis();
        Task408.countingSort(csp3);
        System.out.println(System.currentTimeMillis() - time11);
        long time12 = System.currentTimeMillis();
        Task408.countingSort(csp4);
        System.out.println(System.currentTimeMillis() - time12);
        Event[] cso1 =randomEvents(10_000, 2000, 2021);
        Event[] cso2= randomEvents(10_000, -1_000_000, 1_000_000);
        Event[] cso3= randomEvents(100_000, 2000, 2021);
        Event[] cso4= randomEvents(100_000, -1_000_000, 1_000_000);
        long time13 = System.currentTimeMillis();
        Task408.countingSort(cso1);
        System.out.println(System.currentTimeMillis() - time13);
        long time14 = System.currentTimeMillis();
        Task408.countingSort(cso2);
        System.out.println(System.currentTimeMillis() - time14);
        long time15 = System.currentTimeMillis();
        Task408.countingSort(cso3);
        System.out.println(System.currentTimeMillis() - time15);
        long time16 = System.currentTimeMillis();
        Task408.countingSort(cso4);
        System.out.println(System.currentTimeMillis() - time16);
    }

}
