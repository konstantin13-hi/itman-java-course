package tasks;

import collections.IntArrayList;
import entities.Statistic;
import utils.ArrayUtils;

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
    private static int[] calcLevel(IntArrayList[] intArrayLists) {
        int[] arrayDays = new int[sizeForLength(intArrayLists)];
        for (int j = 0; j < intArrayLists.length; j++) {
            for (int i = 0; i < arrayDays.length; i++) {
                if (i >= arrayDays.length - intArrayLists[j].size()) {
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
    private static int[] calcTicketsForDifferentDays(IntArrayList[] intArrayLists) {
        int[] arrayDaysWithTickets = new int[sizeForLength(intArrayLists)];
        for (int j = 0; j < intArrayLists.length; j++) {
            for (int i = 0; i < arrayDaysWithTickets.length; i++) {
                if (i >= arrayDaysWithTickets.length - intArrayLists[j].size()) {
                    arrayDaysWithTickets[i] += intArrayLists[j].get(intArrayLists[j].size() - arrayDaysWithTickets.length + i);
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
     * @param intArrayLists
     * @return
     */
    private static int sizeForLength(IntArrayList[] intArrayLists) {
        int max = 0;
        for (int i = 0; i < intArrayLists.length; i++) {
            if (max < intArrayLists[i].size()) {
                max = intArrayLists[i].size();
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
    private static double[] getAverage(IntArrayList[] intArrayLists) {
        int[] arrayAllTickets = calcTicketsForDifferentDays(intArrayLists);
        int[] arrayDaysWithWorkingQueue = calcLevel(intArrayLists);
        double[] array = new double[sizeForLength(intArrayLists)];
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

    private static int[] getMin(IntArrayList[] intArrayLists) {
        int[] arrayDaysMin = new int[sizeForLength(intArrayLists)];
        for (int j = 0; j < intArrayLists.length; j++) {
            for (int i = 0; i < arrayDaysMin.length; i++) {
                if (i >= arrayDaysMin.length - intArrayLists[j].size()) {
                    int aaa = intArrayLists[j].get(intArrayLists[j].size() - arrayDaysMin.length + i);
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
    private static int[] getMax(IntArrayList[] intArrayLists) {
        int[] arrayDaysMin = new int[sizeForLength(intArrayLists)];
        for (int j = 0; j < intArrayLists.length; j++) {
            for (int i = 0; i < arrayDaysMin.length; i++) {
                if (i >= arrayDaysMin.length - intArrayLists[j].size()) {
                    int element = intArrayLists[j].get(intArrayLists[j].size() - arrayDaysMin.length + i);
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
     * @cpu 0(m*nlog(n))
     * @ram 0(m+n)
     * @param
     * @return
     */
    private static double[] getMedian(IntArrayList[] intArrayLists) {
        double[] arrayDays = new double[sizeForLength(intArrayLists)];
        int[] arrayForMedian;
        int[] daysWithWorkingQueue = calcLevel(intArrayLists);
        for (int i = 0; i < arrayDays.length; i++) {
            arrayForMedian = new int[daysWithWorkingQueue[i]];
            int index = 0;
            for (int j = 0; j < intArrayLists.length; j++) {
                if (i >= arrayDays.length - intArrayLists[j].size()) {
                    arrayForMedian[index] = intArrayLists[j].get(intArrayLists[j].size() - arrayDays.length + i);
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
     * n=amount of systems
     * m=amount of most business days
     *
     * @cpu 0(n*m+(m*nlog(n))=m*n*log(n)
     * @ram 0(n*m)
     *
     * @param systems the first term
     * @return array of statistics all days
     */
    public static Statistic[] calcStatisticByDays(QueueManagementSystem[] systems) {
        IntArrayList[] intArrayList = new IntArrayList[systems.length];
        for (int i = 0; i < intArrayList.length; i++) {
            intArrayList[i] = systems[i].getVisitsByDay();
        }
        int mostBusinessDays = sizeForLength(intArrayList);
        int[] min = getMin(intArrayList);
        int[] max = getMax(intArrayList);
        int[] count = calcTicketsForDifferentDays(intArrayList);
        double[] average = getAverage(intArrayList);
        double[] median = getMedian(intArrayList);
        Statistic[] calcStatisticByDays = new Statistic[mostBusinessDays];
        for (int i = 0; i < mostBusinessDays; i++) {
            calcStatisticByDays[i] = new Statistic(min[i], max[i], count[i], average[i], median[i]);
        }

        return calcStatisticByDays;
    }
}
