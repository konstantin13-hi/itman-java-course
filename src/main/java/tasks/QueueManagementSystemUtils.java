package tasks;

import collections.ArrayList;
import entities.Statistic;
import tasks.QueueManagementSystem;
import utils.ArrayUtils;

public class QueueManagementSystemUtils {


    /**
     * Calculate total ticketsww
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
     * @cpu 0(nlog(n))
     * @ram 0(n)
     *
     * @param systems the first term
     * @return result median tickets
     */
    public static double calcMedianVisits(QueueManagementSystem[] systems) {
        if (systems.length == 0) {
            return 0;
        }
        int[] median = new int[systems.length];
        for (int i = 0; i < median.length; i++) {
            median[i] = systems[i].getTotalTickets();
        }
        ArrayUtils.mergeSort(median);
        double result;
        if (systems.length % 2 == 0) {
            result = ((double) median[(systems.length - 1) / 2] + median[((systems.length - 1) / 2) + 1]) / 2;
        } else {
            result = Math.round((double) calcTotalVisits(systems) / systems.length);
        }
        return result;
    }

    /**
     * n=amount of systems
     * m=amount of most business days
     *
     * @cpu 0(n*m)
     * @ram 0(m)
     *
     * @param
     * @return
     */
    private static int[] calcLevel(ArrayList[] arrayLists) {
        int[] arrayDays = new int[sizeForLength(arrayLists)];
        for (int j = 0; j < arrayLists.length; j++) {
            for (int i = 0; i < arrayDays.length; i++) {
                if (i >= arrayDays.length - arrayLists[j].size()) {
                    arrayDays[i] += 1;
                }
            }
        }
        return arrayDays;
    }

    /**
     *
     * n=amount of systems
     * m=amount of most business days
     *
     * @cpu 0(n*m)
     * @ram 0(m)
     *
     *
     * @return
     */
    private static int[] calcTicketsForDifferentDays(ArrayList[] arrayLists) {
        int[] arrayDaysWithTickets = new int[sizeForLength(arrayLists)];
        for (int j = 0; j < arrayLists.length; j++) {
            for (int i = 0; i < arrayDaysWithTickets.length; i++) {
                if (i >= arrayDaysWithTickets.length - arrayLists[j].size()) {
                    arrayDaysWithTickets[i] += arrayLists[j].get(arrayLists[j].size() - arrayDaysWithTickets.length + i);
                }
            }
        }
        return arrayDaysWithTickets;
    }

    /**
     *
     * n=amount of systems
     * m=amount of most business days
     *
     * @cpu 0(n)
     * @ram 0(1)
     *
     * @param arrayLists
     * @return
     */
    private static int sizeForLength(ArrayList[] arrayLists) {
        int max = 0;
        for (int i = 0; i < arrayLists.length; i++) {
            if (max < arrayLists[i].size()) {
                max = arrayLists[i].size();
            }
        }
        return max;
    }

    /**
     * n=amount of systems
     * m=amount of most business days
     *
     * @cpu 0(n*m)
     * @ram 0(m)
     *
     * @param
     * @return
     */
    private static double[] getAverage(ArrayList[] arrayLists) {
        int[] arrayAllTickets = calcTicketsForDifferentDays(arrayLists);
        int[] arrayDaysWithWorkingQueue = calcLevel(arrayLists);
        double[] array = new double[sizeForLength(arrayLists)];
        for (int i = 0; i < arrayAllTickets.length; i++) {
            array[i] = (double) arrayAllTickets[i] / arrayDaysWithWorkingQueue[i];
        }
        return array;
    }

    /**
     * @cpu 0 (n*m)
     * @ram 0(m)
     * @param
     * @return
     */

    private static int[] getMin(ArrayList[] arrayLists) {
        int[] arrayDaysMin = new int[sizeForLength(arrayLists)];
        for (int j = 0; j < arrayLists.length; j++) {
            for (int i = 0; i < arrayDaysMin.length; i++) {
                if (i >= arrayDaysMin.length - arrayLists[j].size()) {
                    int aaa = arrayLists[j].get(arrayLists[j].size() - arrayDaysMin.length + i);
                    if (arrayDaysMin[i] > aaa && arrayDaysMin[i] != 0) {
                        arrayDaysMin[i] = aaa;
                    } else if (arrayDaysMin[i] == 0 && j == 0) {
                        arrayDaysMin[i] = aaa;
                    }
                }
            }
        }
        return arrayDaysMin;
    }

    /**
     * @cpu 0 (n*m))
     * @ram 0(m)
     * @param
     * @return
     */
    private static int[] getMax(ArrayList[] arrayLists) {
        int[] arrayDaysMin = new int[sizeForLength(arrayLists)];
        for (int j = 0; j < arrayLists.length; j++) {
            for (int i = 0; i < arrayDaysMin.length; i++) {
                if (i >= arrayDaysMin.length - arrayLists[j].size()) {
                    int element = arrayLists[j].get(arrayLists[j].size() - arrayDaysMin.length + i);
                    if (arrayDaysMin[i] < element && arrayDaysMin[i] != 0) {
                        arrayDaysMin[i] = element;
                    } else if (arrayDaysMin[i] == 0 && j == 0) {
                        arrayDaysMin[i] = element;
                    }
                }
            }
        }
        return arrayDaysMin;
    }

    /**
     *
     * @cpu 0(nlog(n))
     * @ram 0(n)
     * @param array
     * @return
     */
    private static double sortTickets(int[] array) {
        double result;
        int[] median = array;
        ArrayUtils.mergeSort(median);
        if (array.length % 2 == 0) {
            result = ((double) median[(array.length - 1) / 2] + (double) median[((array.length - 1) / 2) + 1]) / 2;
        } else {
            result = median[(array.length - 1) / 2];
        }
        return result;
    }

    /**
     * @cpu 0(m*n^2)
     * @ram 0(m)
     * @param
     * @return
     */
    private static double[] getMedian(ArrayList[] arrayLists) {
        double[] arrayDays = new double[sizeForLength(arrayLists)];
        int[] arrayForMedian;
        int[] daysWithWorkingQueue = calcLevel(arrayLists);
        for (int i = 0; i < arrayDays.length; i++) {
            arrayForMedian = new int[daysWithWorkingQueue[i]];
            int index = 0;
            for (int j = 0; j < arrayLists.length; j++) {
                if (i >= arrayDays.length - arrayLists[j].size()) {
                    arrayForMedian[index] = arrayLists[j].get(arrayLists[j].size() - arrayDays.length + i);
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
     * @cpu 0(n*m+(n*m^2)=n*m^2
     * @ram 0(n*m)
     *
     * @param systems the first term
     * @return array of statistics all days
     */
    public static Statistic[] calcStatisticByDays(QueueManagementSystem[] systems) {
        ArrayList[] arrayList = new ArrayList[systems.length];
        for (int i = 0; i < arrayList.length; i++) {
            arrayList[i] = systems[i].getVisitsByDay();
        }
        int mostBusinessDays = sizeForLength(arrayList);
        int[] min = getMin(arrayList);
        int[] max = getMax(arrayList);
        int[] count = calcTicketsForDifferentDays(arrayList);
        double[] average = getAverage(arrayList);
        double[] median = getMedian(arrayList);
        Statistic[] calcStatisticByDays = new Statistic[mostBusinessDays];
        for (int i = 0; i < mostBusinessDays; i++) {
            calcStatisticByDays[i] = new Statistic(min[i], max[i], count[i], average[i], median[i]);
        }

        return calcStatisticByDays;
    }
}
