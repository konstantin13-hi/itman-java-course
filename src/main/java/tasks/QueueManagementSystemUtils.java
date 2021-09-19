package tasks;

import entities.Statistic;
import tasks.QueueManagementSystem;

public class QueueManagementSystemUtils {

    /**
     * Calculate total tickets
     *
     * @param systems the first term
     * @return result total tickets
     * @cpu 0(n)
     * @ram 0(1)
     */
    public static long calcTotalVisits(QueueManagementSystem[] systems) {
        long result = 0;
        for (int i = 0; i < systems.length; i++) {
            result = result + systems[i].getTotalTickets();
        }
        return result;
    }

    /**
     * Calculate average visits
     *
     * @param systems the first term
     * @return result average tickets
     * @cpu 0(n)
     * @ram 0(1)
     */
    public static double calcAverageVisits(QueueManagementSystem[] systems) {
        if (systems.length == 0) {
            return 0;
        }
        return (double) calcTotalVisits(systems) / systems.length;
    }

    /**
     * Calculate median tickets
     *
     * @cpu 0(n^2)
     * @ram 0(n)
     *
     * @param systems the first term
     * @return result median tickets
     */
    public static double calcMedianVisits(QueueManagementSystem[] systems) {
        if (systems.length == 0) {
            return 0;
        }
        double[] median = new double[systems.length];

        for (int i = 0; i < median.length; i++) {
            median[i] = systems[i].getTotalTickets();
        }
        for (int i = 0; i < median.length; i++) {
            for (int j = 1; j < median.length; j++) {
                if (median[j - 1] > median[j]) {
                    double temp = median[j - 1];
                    median[j - 1] = median[j];
                    median[j] = temp;
                }
            }

        }
        double result;
        if (systems.length % 2 == 0) {
            result = (median[(systems.length - 1) / 2] + median[((systems.length - 1) / 2) + 1]) / 2;
        } else {
            result = Math.round((double) calcTotalVisits(systems) / systems.length);
        }
        return result;
    }


    private static int[] calcLevel(QueueManagementSystem[] systems) {
        int[] arrayDays = new int[sizeForLength(systems)];
        int[] forAmount = new int[sizeForLength(systems)];
        for (int i = 0, h = 0; i < systems.length; i++) {
            h = 0;
            for (int j = arrayDays.length - 1; j >= 0; j--) {
                forAmount[j] += 1;
                h++;
                if (systems[i].getVisitsByDay().size() == h) {
                    break;
                }
            }
        }
        return forAmount;
    }


    private static long[] calcTicketsForDifferentDays(QueueManagementSystem[] systems) {
        long[] arrayDays = new long[sizeForLength(systems)];
        for (int i = 0; i < arrayDays.length; i++) {
            for (int j = 0; j < systems.length; j++) {
                if (i >= arrayDays.length - systems[j].getVisitsByDay().size()) {
                    arrayDays[i] += systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size() + i - arrayDays.length);
                }
            }
        }

        return arrayDays;
    }

    private static int sizeForLength(QueueManagementSystem[] systems) {
        int max = 0;
        for (QueueManagementSystem system : systems)
            if (max < system.getVisitsByDay().size()) {
                max = system.getVisitsByDay().size();
            }
        return max;
    }

    private static double[] getAverage(QueueManagementSystem[] systems) {
        long[] arrayAllTickets = calcTicketsForDifferentDays(systems);
        double[] array = new double[sizeForLength(systems)];
        for (int i = 0; i < arrayAllTickets.length; i++) {
            array[i] = (double) arrayAllTickets[i] / calcLevel(systems)[i];
        }
        return array;
    }

    private static int[] getMin(QueueManagementSystem[] systems) {
        int[] arrayDaysMin = new int[sizeForLength(systems)];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arrayDaysMin.length; i++) {
            for (int j = 0; j < systems.length; j++) {
                if (i >= arrayDaysMin.length - systems[j].getVisitsByDay().size()) {
                    if (min > systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size() + i - arrayDaysMin.length)) {
                        min = systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size() + i - arrayDaysMin.length);
                        arrayDaysMin[i] = systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size() + i - arrayDaysMin.length);
                    }
                }
            }
            min = Integer.MAX_VALUE;
        }
        return arrayDaysMin;
    }

    private static int[] getMax(QueueManagementSystem[] systems) {
        int[] arrayDaysMin = new int[sizeForLength(systems)];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arrayDaysMin.length; i++) {
            for (int j = 0; j < systems.length; j++) {
                if (i >= arrayDaysMin.length - systems[j].getVisitsByDay().size()) {
                    if (max < systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size() + i - arrayDaysMin.length)) {
                        max = systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size() + i - arrayDaysMin.length);
                        arrayDaysMin[i] = systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size() + i - arrayDaysMin.length);
                    }

                }
            }
            max = Integer.MIN_VALUE;
        }
        return arrayDaysMin;
    }

    private static double sortTickets(int[] array) {
        double result;
        int[] median = array;
        for (int i = 0; i < median.length; i++) {
            for (int j = 1; j < median.length; j++) {
                if (median[j - 1] > median[j]) {
                    int temp = median[j - 1];
                    median[j - 1] = median[j];
                    median[j] = temp;
                }
            }

        }
        if (array.length % 2 == 0) {
            result = ((double) median[(array.length - 1) / 2] + (double) median[((array.length - 1) / 2) + 1]) / 2;
        } else {
            result = median[(array.length - 1) / 2];
        }


        return result;
    }

    private static double[] getMedian(QueueManagementSystem[] systems) {
        double[] arrayDays = new double[sizeForLength(systems)];
        int[] arrayForMedian;
        for (int i = 0; i < arrayDays.length; i++) {
            arrayForMedian = new int[calcLevel(systems)[i]];
            int index = 0;
            for (int j = 0; j < systems.length; j++) {
                if (i >= arrayDays.length - systems[j].getVisitsByDay().size()) {
                    arrayForMedian[index] = systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size() + i - arrayDays.length);
                    index++;
                }
            }

            arrayDays[i] = sortTickets(arrayForMedian);
        }

        return arrayDays;
    }

    /**
     * Calculate statistic days
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param systems the first term
     * @return array of statistics all days
     */

    public static Statistic[] calcStatisticByDays(QueueManagementSystem[] systems) {

        Statistic[] calcStatisticByDays = new Statistic[sizeForLength(systems)];
        for (int i = 0; i < sizeForLength(systems); i++) {
            calcStatisticByDays[i] = new Statistic(getMin(systems)[i], getMax(systems)[i], calcTicketsForDifferentDays(systems)[i], getAverage(systems)[i], getMedian(systems)[i]);
        }

        return calcStatisticByDays;
    }

}
