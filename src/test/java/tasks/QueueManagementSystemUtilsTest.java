package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueManagementSystemUtilsTest {

    @Test
    public void countQueue() {
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        int[] firstQueueDays = new int[]{3};
        int[] secondQueueDays = new int[]{3};
        int[] thirdQueueDays = new int[]{2};
        String nameForFirstQueue ="Bank" ;
        String nameForSecondQueue ="Bank2" ;
        String nameForThirdQueue ="Bank3" ;
        systems[0] = createTicketBetter(nameForFirstQueue,firstQueueDays);
        systems[1] = createTicketBetter(nameForSecondQueue,secondQueueDays);
        systems[2] = createTicketBetter(nameForThirdQueue,thirdQueueDays);
        Assertions.assertEquals(8, QueueManagementSystemUtils.calcTotalVisits(systems));
    }

    @Test
    public void calcAverageVisits() {
        int[] firstQueueDays = new int[]{3};
        int[] secondQueueDays = new int[]{3};
        String nameForFirstQueue ="Bank" ;
        String nameForSecondQueue ="Bank2" ;
        QueueManagementSystem[] systems = new QueueManagementSystem[2];
        systems[0] = createTicketBetter(nameForFirstQueue,firstQueueDays);
        systems[1] = createTicketBetter(nameForSecondQueue,secondQueueDays);
        Assertions.assertEquals(3, QueueManagementSystemUtils.calcAverageVisits(systems));
    }

    @Test
    public void calcAverage() {
        int[] firstQueueDays = new int[]{1};
        int[] secondQueueDays = new int[]{4};
        int[] thirdQueueDays = new int[]{2};
        String nameForFirstQueue ="Bank" ;
        String nameForSecondQueue ="Bank2" ;
        String nameForThirdQueue ="Bank3" ;
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0] = createTicketBetter(nameForFirstQueue,firstQueueDays);
        systems[1] = createTicketBetter(nameForSecondQueue,secondQueueDays);
        systems[2] = createTicketBetter(nameForThirdQueue,thirdQueueDays);
        Assertions.assertEquals(7.0 / 3, QueueManagementSystemUtils.calcAverageVisits(systems));
    }

    @Test
    public void calc() {
        int[] firstQueueDays = new int[]{1};
        int[] secondQueueDays = new int[]{4};
        int[] thirdQueueDays = new int[]{2};
        String nameForFirstQueue ="Bank" ;
        String nameForSecondQueue ="Bank2" ;
        String nameForThirdQueue ="Bank3" ;
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0] = createTicketBetter(nameForFirstQueue,firstQueueDays);
        systems[1] = createTicketBetter(nameForSecondQueue,secondQueueDays);
        systems[2] = createTicketBetter(nameForThirdQueue,thirdQueueDays);
        Assertions.assertEquals(2.0, QueueManagementSystemUtils.calcMedianVisits(systems));

    }

    @Test
    public void calcSecond() {
        int[] firstQueueDays = new int[]{1};
        int[] secondQueueDays = new int[]{2};
        int[] thirdQueueDays = new int[]{3};
        int[] fourthQueueDays = new int[]{4};
        String nameForFirstQueue ="Bank" ;
        String nameForSecondQueue ="Bank2" ;
        String nameForThirdQueue ="Bank3" ;
        String nameForFourthQueue ="Bank4" ;
        QueueManagementSystem[] systems = new QueueManagementSystem[4];
        systems[0] = createTicketBetter(nameForFirstQueue,firstQueueDays);
        systems[1] = createTicketBetter(nameForSecondQueue,secondQueueDays);
        systems[2] = createTicketBetter(nameForThirdQueue,thirdQueueDays);
        systems[3] = createTicketBetter(nameForFourthQueue,fourthQueueDays);
        Assertions.assertEquals(2.5, QueueManagementSystemUtils.calcMedianVisits(systems));
    }

    @Test
    public void calcTest() {
        int[] firstQueueDays = new int[]{1, 1, 1,1};
        int[] secondQueueDays = new int[]{1,1};
        int[] thirdQueueDays = new int[]{1,1,1};
        int[] fourthQueueDays = new int[]{1};
        String nameForFirstQueue ="Bank" ;
        String nameForSecondQueue ="Bank2" ;
        String nameForThirdQueue ="Bank3" ;
        String nameForFourthQueue ="Bank4" ;
        QueueManagementSystem[] systems = new QueueManagementSystem[4];
        systems[0] = createTicketBetter(nameForFirstQueue,firstQueueDays);
        systems[1] = createTicketBetter(nameForSecondQueue,secondQueueDays);
        systems[2] = createTicketBetter(nameForThirdQueue,thirdQueueDays);
        systems[3] = createTicketBetter(nameForFourthQueue,fourthQueueDays);
        int[] min = new int[]{1, 1, 1, 1};
        int[] max = new int[]{1, 1, 1, 1};
        double[] average = new double[]{1, 1, 1, 1};
        long[] count = new long[]{1, 2, 3, 4};
        double[] median = new double[]{1, 1, 1, 1};
        test(systems, min, max, average, count, median);
    }

    @Test
    public void calcTestSecond() {
        int[] firstQueueDays = new int[]{10, 20};
        int[] secondQueueDays = new int[]{30};
        String nameForFirstQueue ="Bank" ;
        String nameForSecondQueue ="Bank2" ;
        QueueManagementSystem[] systems = new QueueManagementSystem[2];
        systems[0] = createTicketBetter(nameForFirstQueue,firstQueueDays);
        systems[1] = createTicketBetter(nameForSecondQueue,secondQueueDays);
        int[] min = new int[]{10, 20};
        int[] max = new int[]{10, 30};
        double[] average = new double[]{10, 25};
        long[] count = new long[]{10, 50};
        double[] median = new double[]{10, 25};
        test(systems, min, max, average, count, median);
    }

    @Test
    public void calcTestThird() {
        int[] firstQueueDays = new int[]{1, 2, 3};
        int[] secondQueueDays = new int[]{1,2,3};
        int[] thirdQueueDays = new int[]{1,2,3};
        String nameForFirstQueue ="Bank" ;
        String nameForSecondQueue ="Bank2" ;
        String nameForThirdQueue ="Bank3" ;
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0] = createTicketBetter(nameForFirstQueue,firstQueueDays);
        systems[1] = createTicketBetter(nameForSecondQueue,secondQueueDays);
        systems[2] = createTicketBetter(nameForThirdQueue,thirdQueueDays);
        int[] min = new int[]{1, 2, 3};
        int[] max = new int[]{1, 2, 3};
        double[] average = new double[]{1, 2, 3};
        long[] count = new long[]{3, 6, 9};
        double[] median = new double[]{1, 2, 3};
        test(systems, min, max, average, count, median);
    }

    @Test
    public void calcTestFourth() {
        String nameForFirstQueue ="Bank" ;
        int[] firstQueueDays = new int[]{1, 2,3};
        QueueManagementSystem[] systems = new QueueManagementSystem[1];
        systems[0] = createTicketBetter(nameForFirstQueue,firstQueueDays);
        int[] min = new int[]{1, 2, 3};
        int[] max = new int[]{1, 2, 3};
        double[] average = new double[]{1, 2, 3};
        long[] count = new long[]{1, 2, 3};
        double[] median = new double[]{1, 2, 3};
        test(systems, min, max, average, count, median);

    }

    @Test
    public void calcTestFifth() {
        int[] firstQueueDays = new int[]{1, 2, 3,4};
        int[] secondQueueDays = new int[]{0,1};
        int[] thirdQueueDays = new int[]{5, 10,7};
        String nameForFirstQueue ="Bank" ;
        String nameForSecondQueue ="Bank2" ;
        String nameForThirdQueue ="Bank3" ;
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0] = createTicketBetter(nameForFirstQueue,firstQueueDays);
        systems[1] = createTicketBetter(nameForSecondQueue,secondQueueDays);
        systems[2] = createTicketBetter(nameForThirdQueue,thirdQueueDays);
        int[] min = new int[]{1, 2, 0, 1};
        int[] max = new int[]{1, 5, 10, 7};
        double[] average = new double[]{1, 3.5, (double) 13 / 3, 4};
        long[] count = new long[]{1, 7, 13, 12};
        double[] median = new double[]{1, 3.5, 3, 4};
        test(systems, min, max, average, count, median);
    }

    @Test
    public void calcTestSixth() {
        int[] firstQueueDays = new int[]{1, 2,3};
        int[] secondQueueDays = new int[]{1};
        String nameForFirstQueue ="Bank" ;
        String nameForSecondQueue ="Bank2" ;
        QueueManagementSystem[] systems = new QueueManagementSystem[2];
        systems[0]=createTicketBetter(nameForFirstQueue,firstQueueDays);
        systems[1]=createTicketBetter(nameForSecondQueue,secondQueueDays);
        int[] min = new int[]{1, 2, 1};
        int[] max = new int[]{1, 2, 3};
        double[] average = new double[]{1, 2, (double) 4 / 2};
        long[] count = new long[]{1, 2, 4};
        double[] median = new double[]{1, 2, 2};
        test(systems, min, max, average, count, median);
    }

    public static QueueManagementSystem createTicketBetter(String name, int[] days) {
        QueueManagementSystem systems = new QueueManagementSystem(name);
        for (int d = 0; d < days.length; d++) {
            for (int i = 0; i < days[d]; i++) {
                systems.getNextTicket();
            }
            if (d != days.length - 1)
                systems.toNextWorkDay();
        }
        return systems;
    }

    public static void test(QueueManagementSystem[] systems, int[] min, int[] max, double[] average, long[] count, double[] median) {
        for (int i = 0; i < min.length; i++) {
            Assertions.assertEquals(min[i], QueueManagementSystemUtils.calcStatisticByDays(systems)[i].getMin());
            Assertions.assertEquals(max[i], QueueManagementSystemUtils.calcStatisticByDays(systems)[i].getMax());
            Assertions.assertEquals(average[i], QueueManagementSystemUtils.calcStatisticByDays(systems)[i].getAverage());
            Assertions.assertEquals(count[i], QueueManagementSystemUtils.calcStatisticByDays(systems)[i].getCount());
            Assertions.assertEquals(median[i], QueueManagementSystemUtils.calcStatisticByDays(systems)[i].getMedian());
        }
    }
}