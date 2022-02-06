package utils;

import entities.Event;
import collections.ArrayList;

public class ArrayUtils {

    /**
     * Sort elements of array .
     *
     * n=amount of elements in array
     *
     * @cpu O(n^2)
     * @ram O(1)
     *
     * @param events the first term.
     *
     */
    public static void bubbleSort(Event[] events) {
        for (int i = 0; i < events.length; i++) {
            for (int j = 1; j < events.length; j++) {
                if ((events[j - 1].compareTo(events[j]) > 0)) {
                    Event t = events[j - 1];
                    events[j - 1] = events[j];
                    events[j] = t;
                }
            }
        }
    }

    /**
     * Sort elements in ascending order
     *
     * n=amount of elements in array
     *
     * @cpu O(n^2)
     * @ram O(1)
     *
     * @param array the first term
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

    }

    /**
     * Sort elements with method counting sort
     *
     * n=amount of elements in array
     * m=difference between the maximum minimum element in array
     *
     * @cpu O(n+m)
     * @ram O(m)
     *
     * @param array the first term
     */
    public static void countingSort(int[] array) {
        if (array.length != 0) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
                if (min > array[i]) {
                    min = array[i];
                }
            }
            int dif = max - min;
            int[] cnt = new int[dif + 1];
            for (int i = 0; i < array.length; i++) {
                cnt[array[i] - min]++;
            }

            for (int i = 0, j = 0; i < cnt.length; i++) {
                for (int k = cnt[i]; k > 0; k--) {
                    array[j++] = i + min;
                }
            }
        }
    }

    /**
     * Find only unique elements in array
     *
     * n=amount of elements in array
     * m=difference between the maximum minimum element in array
     * l=the number of elements that are not repeated
     *
     * @cpu O(n*l+m)
     * @ram O(m+l)
     * @param array the first term
     *
     * @return array containing only unique elements
     */
    public static int[] distinct(int[] array) {
        if (array.length != 0) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
                if (min > array[i]) {
                    min = array[i];
                }
            }
            int dif = max - min;
            int[] cnt = new int[dif + 1];
            for (int i = 0; i < array.length; i++) {
                cnt[array[i] - min]++;
            }
            int sum = 0;
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] >= 1) {
                    sum++;
                }
            }
            int[] newArray = new int[sum];
            for (int k = 0, l = 0; k < array.length; k++) {
                if (k == 0) {
                    newArray[l++] = array[k];
                }
                if (k >= 1) {
                    int count = 0;
                    for (int i = 0; i < l; i++) {
                        if (array[k] != newArray[i]) {
                            count++;
                        }
                    }
                    if (count == l) {
                        newArray[l++] = array[k];
                    }
                }
            }
            return newArray;
        }
        return array;
    }

    /**
     * Find the number that occurs the most times
     *
     * n=amount of elements in array
     * m=difference between the maximum minimum element in array
     *
     * @cpu O(n+m)
     * @ram O(m)
     *
     * @param array the first term
     * @return the number that occurs the most times
     */
    public static int mostFrequent(int[] array) {
        if (array.length != 0) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
                if (min > array[i]) {
                    min = array[i];
                }
            }
            int dif = max - min;
            int[] cnt = new int[dif + 1];
            for (int i = 0; i < array.length; i++) {
                cnt[array[i] - min]++;
            }
            int secondMax = Integer.MIN_VALUE;
            int index = 0;
            for (int i = cnt.length - 1; 0 <= i; i--) {
                if (secondMax <= cnt[i]) {
                    secondMax = cnt[i];
                    index = i;
                }
            }
            return index + min;


        }
        return array.length;
    }

    /**
     * Find the number of elements that are contained simultaneously in two arrays
     *
     * a=amount of elements in array a
     * b=amount of elements in array b
     * k=difference between the maximum minimum element in array a
     * d=difference between the maximum minimum element in array b
     * @cpu 0(a+b+k)
     * @ram 0(k+d)
     *
     * @param a the first term
     * @param b the second term
     * @return the number of elements that are contained simultaneously in two arrays
     */
    public static int countEquals(int[] a, int[] b) {
        if (a.length != 0 && b.length != 0) {
            int max = Integer.MIN_VALUE;
            int maxSecond = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int minSecond = Integer.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                if (max < a[i]) {
                    max = a[i];
                }
                if (min > a[i]) {
                    min = a[i];
                }
            }
            for (int i = 0; i < b.length; i++) {
                if (maxSecond < b[i]) {
                    maxSecond = b[i];
                }
                if (minSecond > b[i]) {
                    minSecond = b[i];
                }
            }
            int dif = max - min;
            int result = 0;
            int[] cnt = new int[dif + 1];
            int[] cntSecond = new int[dif + 1];
            for (int i = 0; i < a.length; i++) {
                cnt[(a[i] - min)]++;
            }
            for (int i = 0; i < b.length; i++) {
                if (b[i] >= min && b[i] <= max) {
                    cntSecond[(b[i] - min)]++;
                }
            }
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] > cntSecond[i]) {
                    result += cntSecond[i];
                } else {
                    result += cnt[i];
                }
            }
            return result;
        }
        return a.length;
    }

    /**
     * Make a counting sort
     *
     * n=amount of elements in array
     * m=difference between the maximum minimum element in array
     * k= the largest repetition of events with the same index
     * 
     * @cpu O(n+m*k)=(n+m)
     * @ram O(n+m)
     *
     * @param events the first term
     */
    public static void countingSort(Event[] events) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < events.length; i++) {
            int days = (events[i].getYear() * 372 + events[i].getMonth() * 31 + events[i].getDay());
            if (max < days) {
                max = days;
            }
            if (min > days) {
                min = days;
            }
        }
        int dif = max - min;
        ArrayList[] arrayLists = new ArrayList[dif + 1];
        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList();
        }
        for (int i = 0; i < events.length; i++) {
            int days = (events[i].getYear() * 372 + events[i].getMonth() * 31 + events[i].getDay());
            arrayLists[days - min].add(i);
        }
        Event[] events1 = new Event[events.length];
        System.arraycopy(events, 0, events1, 0, events.length);
        for (int i = 0, index = 0; i < arrayLists.length; i++) {
            int length = arrayLists[i].size();
            for (int j = 0; j < length; j++) {
                events[index] = events1[arrayLists[i].get(j)];
                index++;
            }
        }
    }

    /**
     * Create merge
     *
     * @cpu O(n)
     * @ram O(1)
     *
     * @param a the first array variable
     * @param aFrom the index of the first array, indicating the start of the sort
     * @param aTo the index of the first array indicating the end of the sort
     * @param b the second array variable
     * @param bFrom the index of the second array, indicating the start of the sort
     * @param bTo the index of the second array indicating the end of the sort
     * @param r the third array variable,where the first two arrays are merged and the elements are sorted
     * @param rFrom the index of the third array, indicating the start of the sort
     *
     */
    public static void merge(int[] a, int aFrom, int aTo, int[] b, int bFrom, int bTo, int[] r, int rFrom) {
        int limit = aTo - aFrom + bTo - bFrom;
        for (int i = 0, j = aFrom, k = bFrom; i < limit; i++) {
            if (j < aTo && k < bTo) {
                r[rFrom++] = a[j] <= b[k] ? a[j++] : b[k++];
            } else if (j < aTo && k == bTo) {
                r[rFrom++] = a[j++];
            } else if (j == aTo && k < bTo) {
                r[rFrom++] = b[k++];
            }
        }
    }

    /**
     * Make merge
     * @cpu O(nlog(n))
     * @ram O(n)
     * @param a the first term
     */
    public static void mergeSort(int[] a) {
        int[] array = new int[a.length];
        for (int k = 1; k < a.length; k = k * 2) {
            for (int j = k; j - k < a.length; j += k * 2) {
                if (j < a.length && j + k <= a.length) {
                    ArrayUtils.merge(a, (j - k), j, a, j, (j + k), array, (j - k));
                } else if (j < a.length && j + k > a.length) {
                    ArrayUtils.merge(a, (j - k), j, a, j, array.length, array, (j - k));
                } else {
                    System.arraycopy(a, (j - k), array, (j - k), k - (j - a.length));
                }
            }
            System.arraycopy(array, 0, a, 0, a.length);
        }
    }

    /**
     * Make merge sort
     * @cpu O(nlog(n))
     * @ram O(n)
     * @param array the first array variable
     * @param fromIndex the index of the first array, indicating the start of the sort
     * @param toIndex the index of the first array indicating the end of the sort
     */
    public static void mergeSort(int[] array, int fromIndex, int toIndex) {
        int[] t = new int[array.length];
        int length = toIndex - fromIndex;
        for (int k = 1; k < length; k = k * 2) {
            for (int j = fromIndex;  j < toIndex; j += k * 2) {
                if (j+k < array.length && j+k*2 <= array.length) {
                    ArrayUtils.merge(array, j , j+k, array, j+k, j + k*2, t, j);
                } else if (j+k < array.length && j+k*2 > array.length) {
                    ArrayUtils.merge(array,j, j+k, array, j+k, array.length, t, j);
                } else {
                    System.arraycopy(array, j, t, j, k);
                }
            }
            System.arraycopy(t, fromIndex, array, fromIndex, length);
        }
    }


    /**
     * Make merge sort
     * @cpu O(nlog(n))
     * @ram O(n)
     * @param array the first array variable
     * @param fromIndex the index of the first array, indicating the start of the sort
     * @param toIndex the index of the first array indicating the end of the sort
     */
    public static void mergeSort(Event[] array, int fromIndex, int toIndex) {
        Event[] t = new Event[array.length];
        int length = toIndex - fromIndex;
        for (int k = 1; k < length; k = k * 2) {
            for (int j = fromIndex; j < toIndex; j += k * 2) {
                if (j + k < array.length && j + k * 2 <= array.length) {
                    ArrayUtils.merge(array, j, j + k, array, j + k, j + k * 2, t, j);
                } else if (j + k < array.length && j + k * 2 > array.length) {
                    ArrayUtils.merge(array, j, j + k, array, j + k, array.length, t, j);
                } else {
                    System.arraycopy(array, j, t, j, k);
                }
            }
            System.arraycopy(t, fromIndex, array, fromIndex, length);
        }
    }

    /**
     * Make merge
     *
     * @cpu O(nlog(n))
     * @ram O(n)
     *
     * @param events the first term
     */
    public static void mergeSort(Event[] events) {
        Event[] array = new Event[events.length];
        for (int k = 1; k < events.length; k = k * 2) {
            for (int j = k; j - k < events.length; j += k * 2) {
                if (j < events.length && j + k <= events.length) {
                    ArrayUtils.merge(events, (j - k), j, events, j, (j + k), array, (j - k));
                } else if (j < events.length && j + k > events.length) {
                    ArrayUtils.merge(events, (j - k), j, events, j, events.length, array, (j - k));
                } else {
                    System.arraycopy(events, (j - k), array, (j - k), k - (j - events.length));
                }
            }
            System.arraycopy(array, 0, events, 0, events.length);
        }
    }

    /**
     * Create merge
     *
     * @cpu O(n)
     * @ram O(1)
     *
     * @param a the first array variable
     * @param aFrom the index of the first array, indicating the start of the sort
     * @param aTo the index of the first array indicating the end of the sort
     * @param b the second array variable
     * @param bFrom the index of the second array, indicating the start of the sort
     * @param bTo the index of the second array indicating the end of the sort
     * @param r the third array variable,where the first two arrays are merged and the elements are sorted
     * @param rFrom the index of the third array, indicating the start of the sort
     *
     */
    public static void merge(Event[] a, int aFrom, int aTo, Event[] b, int bFrom, int bTo, Event[] r, int rFrom) {
        int limit = aTo - aFrom + bTo - bFrom;
        for (int i = 0, j = aFrom, k = bFrom; i < limit; i++) {
            if (j < aTo && k < bTo) {
                r[rFrom++] = a[j].compareTo(b[k]) < 1 ? a[j++] : b[k++];
            } else if (j < aTo && k == bTo) {
                r[rFrom++] = a[j++];
            } else if (j == aTo && k < bTo) {
                r[rFrom++] = b[k++];
            }
        }
    }
}

