package tasks;

import entities.Statistic;
import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueManagementSystemUtilsTest {

    @Test
    public void countQueue() {
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        int ticketsFirst = 3;
        int ticketSecond = 3;
        int ticketsThird = 2;
        int[] firstQueueDays = new int[]{};
        int[] secondQueueDays = new int[]{};
        int[] thirdQueueDays = new int[]{};
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0], firstQueueDays, ticketsFirst);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1], secondQueueDays, ticketSecond);
        systems[2] = new QueueManagementSystem("Bank3");
        createTicket(systems[2], thirdQueueDays, ticketsThird);
        Assertions.assertEquals(8, QueueManagementSystemUtils.calcTotalVisits(systems));
    }

    @Test
    public void calcAverageVisits() {
        int ticketsFirst = 3;
        int ticketSecond = 3;
        int[] firstQueueDays = new int[]{};
        int[] secondQueueDays = new int[]{};
        QueueManagementSystem[] systems = new QueueManagementSystem[2];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0], firstQueueDays, ticketsFirst);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1], secondQueueDays, ticketSecond);
        Assertions.assertEquals(3, QueueManagementSystemUtils.calcAverageVisits(systems));
    }

    @Test
    public void calcAverage() {
        int ticketsFirst = 1;
        int ticketSecond = 4;
        int ticketsThird = 2;
        int[] firstQueueDays = new int[]{};
        int[] secondQueueDays = new int[]{};
        int[] thirdQueueDays = new int[]{};
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0], firstQueueDays, ticketsFirst);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1], secondQueueDays, ticketSecond);
        systems[2] = new QueueManagementSystem("Bank3");
        createTicket(systems[2], thirdQueueDays, ticketsThird);
        Assertions.assertEquals(7.0 / 3, QueueManagementSystemUtils.calcAverageVisits(systems));
    }

    @Test
    public void calc() {
        int ticketsFirst = 1;
        int ticketSecond = 4;
        int ticketsThird = 2;
        int[] firstQueueDays = new int[]{};
        int[] secondQueueDays = new int[]{};
        int[] thirdQueueDays = new int[]{};
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0], firstQueueDays, ticketsFirst);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1], secondQueueDays, ticketSecond);
        systems[2] = new QueueManagementSystem("Bank3");
        createTicket(systems[2], thirdQueueDays, ticketsThird);
        Assertions.assertEquals(2.0, QueueManagementSystemUtils.calcMedianVisits(systems));

    }

    @Test
    public void calcSecond() {
        int ticketsFirst = 1;
        int ticketSecond = 2;
        int ticketsThird = 3;
        int ticketsFourth = 4;
        int[] firstQueueDays = new int[]{};
        int[] secondQueueDays = new int[]{};
        int[] thirdQueueDays = new int[]{};
        int[] fourthQueueDays = new int[]{};
        QueueManagementSystem[] systems = new QueueManagementSystem[4];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0], firstQueueDays, ticketsFirst);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1], secondQueueDays, ticketSecond);
        systems[2] = new QueueManagementSystem("Bank3");
        createTicket(systems[2], thirdQueueDays, ticketsThird);
        systems[3] = new QueueManagementSystem("Bank3");
        createTicket(systems[3], fourthQueueDays, ticketsFourth);
        Assertions.assertEquals(2.5, QueueManagementSystemUtils.calcMedianVisits(systems));
    }

    @Test
    public void calcTest() {
        int ticketsFirst = 4;
        int ticketSecond = 2;
        int ticketsThird = 3;
        int ticketsFourth = 1;
        int[] firstQueueDays = new int[]{1, 2, 3};
        int[] secondQueueDays = new int[]{1};
        int[] thirdQueueDays = new int[]{1, 2};
        int[] fourthQueueDays = new int[]{};
        QueueManagementSystem[] systems = new QueueManagementSystem[4];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0], firstQueueDays, ticketsFirst);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1], secondQueueDays, ticketSecond);
        systems[2] = new QueueManagementSystem("Bank3");
        createTicket(systems[2], thirdQueueDays, ticketsThird);
        systems[3] = new QueueManagementSystem("Bank3");
        createTicket(systems[3], fourthQueueDays, ticketsFourth);
        int[] min = new int[]{1, 1, 1, 1};
        int[] max = new int[]{1, 1, 1, 1};
        double[] average = new double[]{1, 1, 1, 1};
        long[] count = new long[]{1, 2, 3, 4};
        double[] median = new double[]{1, 1, 1, 1};
        test(systems, min, max, average, count, median);
    }

    @Test
    public void calcTestSecond() {
        int[] firstQueueDays = new int[]{10};
        int[] secondQueueDays = new int[]{};
        int x = 30;
        int x1 = 30;
        QueueManagementSystem[] systems = new QueueManagementSystem[2];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0], firstQueueDays, x);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1], secondQueueDays, x1);
        int[] min = new int[]{10, 20};
        int[] max = new int[]{10, 30};
        double[] average = new double[]{10, 25};
        long[] count = new long[]{10, 50};
        double[] median = new double[]{10, 25};
        test(systems, min, max, average, count, median);
    }

    @Test
    public void calcTestThird() {
        int x = 6;
        int x1 = 6;
        int x2 = 6;
        int[] firstQueueDays = new int[]{1, 3};
        int[] secondQueueDays = new int[]{1, 3};
        int[] thirdQueueDays = new int[]{1, 3};
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0], firstQueueDays, x);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1], secondQueueDays, x1);
        systems[2] = new QueueManagementSystem("Bank3");
        createTicket(systems[2], thirdQueueDays, x2);
        int[] min = new int[]{1, 2, 3};
        int[] max = new int[]{1, 2, 3};
        double[] average = new double[]{1, 2, 3};
        long[] count = new long[]{3, 6, 9};
        double[] median = new double[]{1, 2, 3};
        test(systems, min, max, average, count, median);
    }

    @Test
    public void calcTestFourth() {
        int x = 6;
        int[] firstQueueDays = new int[]{1, 3};
        QueueManagementSystem[] systems = new QueueManagementSystem[1];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0], firstQueueDays, x);
        int[] min = new int[]{1, 2, 3};
        int[] max = new int[]{1, 2, 3};
        double[] average = new double[]{1, 2, 3};
        long[] count = new long[]{1, 2, 3};
        double[] median = new double[]{1, 2, 3};
        test(systems, min, max, average, count, median);

    }

    @Test
    public void calcTestFifth() {
        int[] firstQueueDays = new int[]{1, 3, 6};
        int[] secondQueueDays = new int[]{0};
        int[] thirdQueueDays = new int[]{5, 15};
        int x = 10;
        int x1 = 1;
        int x2 = 22;
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0], firstQueueDays, x);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1], secondQueueDays, x1);
        systems[2] = new QueueManagementSystem("Bank3");
        createTicket(systems[2], thirdQueueDays, x2);
        int[] min = new int[]{1, 2, 0, 1};
        int[] max = new int[]{1, 5, 10, 7};
        double[] average = new double[]{1, 3.5, (double) 13 / 3, 4};
        long[] count = new long[]{1, 7, 13, 12};
        double[] median = new double[]{1, 3.5, 3, 4};
        test(systems, min, max, average, count, median);
    }

    @Test
    public void calcTestSixth() {
        int[] firstQueueDays = new int[]{1, 3};
        int[] secondQueueDays = new int[]{};
        int x = 6;
        int x1 = 1;
        QueueManagementSystem[] systems = new QueueManagementSystem[2];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0], firstQueueDays, x);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1], secondQueueDays, x1);
        int[] min = new int[]{1, 2, 1};
        int[] max = new int[]{1, 2, 3};
        double[] average = new double[]{1, 2, (double) 4 / 2};
        long[] count = new long[]{1, 2, 4};
        double[] median = new double[]{1, 2, 2};
        test(systems, min, max, average, count, median);
    }

    public static void createTicket(QueueManagementSystem system, int[] expectedDays, int allTicketsForOneQueue) {
        for (int d = 0; d < allTicketsForOneQueue; d++) {
            for (int j = 0; j < expectedDays.length; j++) {
                if (expectedDays[j] == d) {
                    system.toNextWorkDay();
                    break;
                }
            }
            system.getNextTicket();
        }
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