package utils;

import collections.ArrayList;
import collections.IntArrayList;
import entities.Event;

import java.util.Comparator;

public class ArrayUtils {

    /**
     * Sort elements of array.
     * n=amount of elements in array
     *
     * @cpu O(n ^ 2)
     * @ram O(1)
     *
     * @param elements the first term.
     * @param comparator the second term.
     * @param <T> describes my type parameter
     */
    public static <T> void bubbleSort(T[] elements, Comparator<T> comparator) {
        if (elements == null || comparator == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < elements.length; i++) {
            for (int j = 1; j < elements.length; j++) {
                if (comparator.compare(elements[j - 1], elements[j]) > 0) {
                    T t = elements[j - 1];
                    elements[j - 1] = elements[j];
                    elements[j] = t;
                }
            }
        }
    }

    /**
     * Sort elements in ascending order.
     * n=amount of elements in array
     *
     * @param array the first term
     * @cpu O(n ^ 2)
     * @ram O(1)
     */
    public static void bubbleSort(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
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
     * Sort elements with method counting sort.
     * n=amount of elements in array
     * m=difference between the maximum minimum element in array
     *
     * @param array the first term
     * @cpu O(n + m)
     * @ram O(m)
     */
    public static void countingSort(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
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
     * Make a counting sort.
     * n=amount of elements in array
     * m=difference between the maximum minimum element in array
     * k= the largest repetition of events with the same index
     *
     * @param events the first term
     * @cpu O(n + m)
     * @ram O(n + m)
     */

    public static void countingSort(Event[] events) {
        if (events == null) {
            throw new NullPointerException();
        }
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
            arrayLists[days - min].add(events[i]);
        }
        for (int i = 0, index = 0; i < arrayLists.length; i++) {
            int length = arrayLists[i].size();
            for (int j = 0; j < length; j++) {
                events[index] = (Event) arrayLists[i].get(j);
                index++;
            }
        }
    }

    /**
     * Find only unique elements in array.
     * n=amount of elements in array
     * m=difference between the maximum minimum element in array
     *
     * @param array the first term
     * @return array containing only unique elements
     * @cpu O(n)
     * @ram O(m + n)
     */
    public static int[] distinct(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        IntArrayList intArrayList = new IntArrayList();
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
            if (cnt[array[i] - min] < 1) {
                intArrayList.add(array[i]);
            }
            cnt[array[i] - min]++;
        }
        return intArrayList.toArray();
    }

    /**
     * Find the number that occurs the most times.
     * n=amount of elements in array
     * m=difference between the maximum minimum element in array
     *
     * @param array the first term
     * @return the number that occurs the most times
     * @cpu O(n + m)
     * @ram O(m)
     */
    public static int mostFrequent(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
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

    /**
     * Find the number of elements that are contained simultaneously in two arrays.
     * a=amount of elements in array a
     * b=amount of elements in array b
     * k=difference between the maximum minimum element in array a
     * d=difference between the maximum minimum element in array b
     *
     * @param a the first term
     * @param b the second term
     * @return the number of elements that are contained simultaneously in two arrays
     * @cpu 0(a + b + k)
     * @ram 0(k + d)
     */
    public static int countEquals(int[] a, int[] b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
            if (min > a[i]) {
                min = a[i];
            }
        }
        int dif = max - min;
        int result = 0;
        int[] cnt = new int[dif + 1];
        for (int i = 0; i < a.length; i++) {
            cnt[(a[i] - min)]++;
        }

        for (int i = 0; i < b.length; i++) {
            if (b[i] >= min && b[i] <= max) {
                cnt[(b[i] - min)]--;
                if (cnt[(b[i] - min)] >= 0) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * Make merge sort.
     * n=amount of elements in the array
     *
     * @param a the first term
     * @cpu O(nlog ( n))
     * @ram O(n)
     */
    public static void mergeSort(int[] a) {
        ArrayUtils.mergeSort(a, 0, a.length);
    }

    /**
     * Make merge sort.
     * n=sum of index differences between start and end
     *
     * @param array     the first array variable
     * @param fromIndex the index of the first array, indicating the start of the sort
     * @param toIndex   the index of the first array indicating the end of the sort
     * @cpu O(nlog ( n))
     * @ram O(n)
     */
    public static void mergeSort(int[] array, int fromIndex, int toIndex) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (fromIndex < 0 || fromIndex > array.length) {
            throw new IllegalArgumentException();
        }
        if (toIndex < 0 || toIndex > array.length) {
            throw new IllegalArgumentException();
        }
        int[] t = new int[array.length];
        int length = toIndex - fromIndex;
        for (int k = 1; k < length; k = k * 2) {
            for (int j = fromIndex; j < toIndex; j += k * 2) {
                if (j + k < toIndex && j + k * 2 <= toIndex) {
                    ArrayUtils.merge(array, j, j + k, array, j + k, j + k * 2, t, j);
                } else if (j + k < toIndex && j + k * 2 > toIndex) {
                    ArrayUtils.merge(array, j, j + k, array, j + k, toIndex, t, j);
                } else {
                    System.arraycopy(array, j, t, j, array.length - j);
                }
            }
            System.arraycopy(t, fromIndex, array, fromIndex, length);
        }
    }


    /**
     * Make merge sort.
     * n=index differences between start and end
     *
     * @param array the first array variable
     * @param fromIndex the index of the first array, indicating the start of the sort
     * @param toIndex   the index of the first array indicating the end of the sort
     * @param <T> describes my type parameter
     * @param comparator an interface for sorting
     * @cpu O(nlog ( n))
     * @ram O(n)
     */
    public static <T> void mergeSort(T[] array, Comparator<? super T> comparator, int fromIndex, int toIndex) {
        if (array == null || comparator == null) {
            throw new NullPointerException();
        }
        if (fromIndex < 0 || fromIndex > array.length) {
            throw new IndexOutOfBoundsException("Index " + fromIndex +
                    " out of bounds for length " + array.length);
        }
        if (toIndex < 0 || toIndex > array.length) {
            throw new IndexOutOfBoundsException("Index " + fromIndex +
                    " out of bounds for length " + array.length);
        }
        T[] t = (T[]) new Object[array.length];
        int length = toIndex - fromIndex;
        for (int k = 1; k < length; k = k * 2) {
            for (int j = fromIndex; j < toIndex; j += k * 2) {
                if (j + k < toIndex && j + k * 2 <= toIndex) {
                    ArrayUtils.merge(array, j, j + k, array, j + k, j + k * 2, t, j, comparator);
                } else if (j + k < toIndex && j + k * 2 > toIndex) {
                    ArrayUtils.merge(array, j, j + k, array, j + k, toIndex, t, j, comparator);
                } else {
                    System.arraycopy(array, j, t, j, array.length - j);
                }
            }
            System.arraycopy(t, fromIndex, array, fromIndex, length);
        }
    }


    /**
     * Make merge sort.
     *
     * @param events  the first term
     * @param comparator an interface for sorting
     * @param <T> describes my type parameter
     * n=amount of elements in the array
     * @cpu O(nlog ( n))
     * @ram O(n)
     */
    public static <T> void mergeSort(T[] events, Comparator<? super T> comparator) {
        ArrayUtils.mergeSort(events, comparator, 0, events.length);
    }

    /**
     * Merge two arrays with sorted elements.
     * n=differences between start and end index of the first array
     * m=differences between start and end index of the second array
     *
     * @cpu O(n+m)
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
     * @param comparator an interface for sorting
     * @param <T> describes my type parameter
     */
    public static <T> void merge(T[] a, int aFrom, int aTo,
                                 T[] b, int bFrom, int bTo, T[] r,
                                 int rFrom, Comparator<? super T> comparator) {

        if (a == null || b == null || r == null || comparator == null) {
            throw new NullPointerException();
        }
        if (rFrom < 0 || rFrom > r.length) {
            throw new IndexOutOfBoundsException("Index " + rFrom +
                    " out of bounds for length " + r.length);
        }

        if (aFrom < 0 || aFrom > a.length) {
            throw new IndexOutOfBoundsException("Index " + aFrom +
                    " out of bounds for length " + a.length);
        }
        if (aTo < 0 || aTo > a.length) {
            throw new IndexOutOfBoundsException("Index " + aTo +
                    " out of bounds for length " + a.length);
        }
        if (bFrom < 0 || bFrom > b.length) {
            throw new IndexOutOfBoundsException("Index " + bFrom +
                    " out of bounds for length " + b.length);
        }
        if (bTo < 0 || bTo > b.length) {
            throw new IndexOutOfBoundsException("Index " + bTo +
                    " out of bounds for length " + b.length);
        }
        int limit = aTo - aFrom + bTo - bFrom;
        for (int i = 0, j = aFrom, k = bFrom; i < limit; i++) {
            if (j < aTo && k < bTo) {
                r[rFrom++] = comparator.compare(a[j], b[k]) < 1 ? a[j++] : b[k++];
            } else if (j < aTo && k == bTo) {
                r[rFrom++] = a[j++];
            } else if (j == aTo && k < bTo) {
                r[rFrom++] = b[k++];
            }
        }
    }

    /**
     * Merge two arrays with sorted elements.
     * n=differences between start and end index of the first array
     * m=differences between start and end index of the second array
     *
     * @param a     the first array variable
     * @param aFrom the index of the first array, indicating the start of the sort
     * @param aTo   the index of the first array indicating the end of the sort
     * @param b     the second array variable
     * @param bFrom the index of the second array, indicating the start of the sort
     * @param bTo   the index of the second array indicating the end of the sort
     * @param r     the third array variable,where the first two arrays are merged and the elements are sorted
     * @param rFrom the index of the third array, indicating the start of the sort
     * @cpu O(n + m)
     * @ram O(1)
     */
    public static void merge(int[] a, int aFrom, int aTo, int[] b, int bFrom, int bTo, int[] r, int rFrom) {
        if (a == null || b == null || r == null) {
            throw new NullPointerException();
        }
        if (rFrom < 0 || rFrom > r.length) {
            throw new IndexOutOfBoundsException("Index " + rFrom +
                    " out of bounds for length " + r.length);
        }

        if (aFrom < 0 || aFrom > a.length) {
            throw new IndexOutOfBoundsException("Index " + aFrom +
                    " out of bounds for length " + a.length);
        }
        if (aTo < 0 || aTo > a.length) {
            throw new IndexOutOfBoundsException("Index " + aTo +
                    " out of bounds for length " + a.length);
        }
        if (bFrom < 0 || bFrom > b.length) {
            throw new IndexOutOfBoundsException("Index " + bFrom +
                    " out of bounds for length " + b.length);
        }
        if (bTo < 0 || bTo > b.length) {
            throw new IndexOutOfBoundsException("Index " + bTo +
                    " out of bounds for length " + b.length);
        }
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
     * Merge two arrays with sorted elements.
     * n=differences between start and end index of the first array
     * m=differences between start and end index of the second array
     *
     * @param a     the first array variable
     * @param aFrom the index of the first array, indicating the start of the sort
     * @param aTo   the index of the first array indicating the end of the sort
     * @param b     the second array variable
     * @param bFrom the index of the second array, indicating the start of the sort
     * @param bTo   the index of the second array indicating the end of the sort
     * @param r     the third array variable,where the first two arrays are merged and the elements are sorted
     * @param rFrom the index of the third array, indicating the start of the sort
     * @cpu O(n + m)
     * @ram O(1)
     */

    public static void merge(Event[] a, int aFrom, int aTo, Event[] b, int bFrom, int bTo, Event[] r, int rFrom) {
        if (a == null || b == null || r == null) {
            throw new NullPointerException();
        }
        if (rFrom < 0 || rFrom > r.length) {
            throw new IndexOutOfBoundsException("Index " + rFrom +
                    " out of bounds for length " + r.length);
        }

        if (aFrom < 0 || aFrom > a.length) {
            throw new IndexOutOfBoundsException("Index " + aFrom +
                    " out of bounds for length " + a.length);
        }
        if (aTo < 0 || aTo > a.length) {
            throw new IndexOutOfBoundsException("Index " + aTo +
                    " out of bounds for length " + a.length);
        }
        if (bFrom < 0 || bFrom > b.length) {
            throw new IndexOutOfBoundsException("Index " + bFrom +
                    " out of bounds for length " + b.length);
        }
        if (bTo < 0 || bTo > b.length) {
            throw new IndexOutOfBoundsException("Index " + bTo +
                    " out of bounds for length " + b.length);
        }
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

