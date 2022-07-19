package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class QueueManagementSystemUtilsTest {
    @Nested
    public class CalcTotalVisits {


        @Test
        public void shouldCountTotalVisitsWhenSystemIsNoEmpty() {
            QueueManagementSystem[] systems = new QueueManagementSystem[3];
            systems[0] = createTicketBetter("Bank", new int[]{3});
            systems[1] = createTicketBetter("Bank2", new int[]{3});
            systems[2] = createTicketBetter("Bank3", new int[]{2});
            Assertions.assertEquals(8, QueueManagementSystemUtils.calcTotalVisits(systems));
        }
    }

    @Nested
    public class CalcAverageVisits {
        @Test
        public void shouldCalcAverageVisitsWhenSystemIsNotEmpty() {
            QueueManagementSystem[] systems = new QueueManagementSystem[2];
            systems[0] = createTicketBetter("Bank", new int[]{3});
            systems[1] = createTicketBetter("Bank2", new int[]{3});
            Assertions.assertEquals(3, QueueManagementSystemUtils.calcAverageVisits(systems));
        }

        @Test
        public void shouldCalcAverageVisitsWhenDifferentVisits() {
            QueueManagementSystem[] systems = new QueueManagementSystem[3];
            systems[0] = createTicketBetter("Bank", new int[]{1});
            systems[1] = createTicketBetter("Bank2", new int[]{4});
            systems[2] = createTicketBetter("Bank3", new int[]{2});
            Assertions.assertEquals(7.0 / 3, QueueManagementSystemUtils.calcAverageVisits(systems));
        }
    }

    @Nested
    public class CalcMedianVisits {
        @Test
        public void shouldCalcMedianVisitsWhenSystemsIsNotEmpty() {
            QueueManagementSystem[] systems = new QueueManagementSystem[3];
            systems[0] = createTicketBetter("Bank", new int[]{1});
            systems[1] = createTicketBetter("Bank2", new int[]{4});
            systems[2] = createTicketBetter("Bank3", new int[]{2});
            Assertions.assertEquals(2.0, QueueManagementSystemUtils.calcMedianVisits(systems));

        }

        @Test
        public void shouldCalcMedianVisitsWhenAllBanksHaveZeroTickets() {
            QueueManagementSystem[] systems = new QueueManagementSystem[4];
            systems[0] = createTicketBetter("Bank", new int[]{0});
            systems[1] = createTicketBetter("Bank2", new int[]{0});
            systems[2] = createTicketBetter("Bank3", new int[]{0});
            systems[3] = createTicketBetter("Bank4", new int[]{0});
            Assertions.assertEquals(0.0, QueueManagementSystemUtils.calcMedianVisits(systems));
        }
    }

    @Nested
    public class CalcStatisticByDays {
        @Test
        public void shouldStatisticByDaysWhenAllBanksGaveEveryDayOneTicket() {
            QueueManagementSystem[] systems = new QueueManagementSystem[4];
            systems[0] = createTicketBetter("Bank", new int[]{1, 1, 1, 1});
            systems[1] = createTicketBetter("Bank2", new int[]{1, 1});
            systems[2] = createTicketBetter("Bank3", new int[]{1, 1, 1});
            systems[3] = createTicketBetter("Bank4", new int[]{1});
            int[] min = new int[]{1, 1, 1, 1};
            int[] max = new int[]{1, 1, 1, 1};
            double[] average = new double[]{1, 1, 1, 1};
            long[] count = new long[]{1, 2, 3, 4};
            double[] median = new double[]{1, 1, 1, 1};
            test(systems, min, max, average, count, median);
        }

        @Test
        public void shouldStatisticByDaysWhenBanksWorkedDifferentAmountDays() {
            QueueManagementSystem[] systems = new QueueManagementSystem[2];
            systems[0] = createTicketBetter("Bank", new int[]{10, 20});
            systems[1] = createTicketBetter("Bank2", new int[]{30});
            int[] min = new int[]{10, 20};
            int[] max = new int[]{10, 30};
            double[] average = new double[]{10, 25};
            long[] count = new long[]{10, 50};
            double[] median = new double[]{10, 25};
            test(systems, min, max, average, count, median);
        }

        @Test
        public void shouldStatisticByDaysWhenBanksWorkedSameDaysAndGaveSameAmountTickets() {
            QueueManagementSystem[] systems = new QueueManagementSystem[3];
            systems[0] = createTicketBetter("Bank", new int[]{1, 2, 3});
            systems[1] = createTicketBetter("Bank2", new int[]{1, 2, 3});
            systems[2] = createTicketBetter("Bank3", new int[]{1, 2, 3});
            int[] min = new int[]{1, 2, 3};
            int[] max = new int[]{1, 2, 3};
            double[] average = new double[]{1, 2, 3};
            long[] count = new long[]{3, 6, 9};
            double[] median = new double[]{1, 2, 3};
            test(systems, min, max, average, count, median);
        }

        @Test
        public void shouldStatisticByDaysWhenWorkedOneBank() {
            QueueManagementSystem[] systems = new QueueManagementSystem[1];
            systems[0] = createTicketBetter("Bank", new int[]{1, 2, 3});
            int[] min = new int[]{1, 2, 3};
            int[] max = new int[]{1, 2, 3};
            double[] average = new double[]{1, 2, 3};
            long[] count = new long[]{1, 2, 3};
            double[] median = new double[]{1, 2, 3};
            test(systems, min, max, average, count, median);

        }

        @Test
        public void shouldStatisticByDaysWhenOneBankDidNotGiveTicketInFirstDay() {
            QueueManagementSystem[] systems = new QueueManagementSystem[3];
            systems[0] = createTicketBetter("Bank", new int[]{1, 2, 3, 4});
            systems[1] = createTicketBetter("Bank2", new int[]{0, 1});
            systems[2] = createTicketBetter("Bank3", new int[]{5, 10, 7});
            int[] min = new int[]{1, 2, 0, 1};
            int[] max = new int[]{1, 5, 10, 7};
            double[] average = new double[]{1, 3.5, (double) 13 / 3, 4};
            long[] count = new long[]{1, 7, 13, 12};
            double[] median = new double[]{1, 3.5, 3, 4};
            test(systems, min, max, average, count, median);
        }

    }

    public static QueueManagementSystem createTicketBetter(String name, int[] days) {
        QueueManagementSystem systems = new QueueManagementSystem(name);
        for (int d = 0; d < days.length; d++) {
            for (int i = 0; i < days[d]; i++) {
                systems.getNextTicket();
            }
            if (d != days.length - 1) {
                systems.toNextWorkDay();
            }
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