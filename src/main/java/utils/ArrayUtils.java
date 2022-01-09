package utils;

import entities.Event;
import collections.ArrayList;

public class ArrayUtils {

    /**
     * Sort elements of array .
     *
     * @param events the first term.
     * @return
     * @cpu O(n ^ 2)
     * @ram O(1)
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
     * <p>
     * n=amount of elements
     *
     * @param array the first term
     * @cpu 0(n ^ 2)
     * @ram 0(1)
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
     * @param array
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
     * @param array
     * @return
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
            for (int k = 0, l = 0, b = 2; k < array.length; k++) {
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
     * @param array
     * @return
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
            //
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
                // 1, 2, 5, -10, 3, 2, 1, 4
                //-10 9 8 7 6 5 4 3 2 1 0 1 2 3 4 5
                // 1  0 0 0 0 0 0 0 0 0 0 2 2 0 1 1

            }
            return index + min;


        }
        return array.length;

    }
    /*

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
        for (int i = 0; i < events.length; i++) {
            events1[i] = events[i];

        }


        for (int i = 0, index = 0; i < arrayLists.length; i++) {
            int length = arrayLists[i].size();
            for (int j = 0; j < length; j++) {
                events[index] = events1[arrayLists[i].get(j)];
                index++;

            }
        }

    }
    // a = [100, 2, 4, 5, -7]
    // aFrom = 1
    // aTo = 4
    // b = [-7, 2, 3]
    // bFrom = 1
    // bTo = 3
    // r = [1, 1, 1, 1, 1, 1, 1, 1]
    // rFrom = 2

    //  результат:
    // r = [1, 1, 2, 2, 3, 4, 5, 1]
    public static void merge(int[] a, int aFrom, int aTo, int[] b, int bFrom, int bTo, int[] r, int rFrom) {
        int limit =  aTo - aFrom + bTo - bFrom;
        for (int i = 0, j = aFrom, k = bFrom; i < limit; i++) {
            if (aTo - aFrom == bTo - bFrom) {
                if (j < aTo && k < bTo) {
                    if (a[j] == b[k]) {
                        r[rFrom++] = a[j++];
                        r[rFrom++] = b[k++];
                        i++;
                    } else if (a[j] > b[k]) {
                        r[rFrom++] = b[k++];
                    } else {
                        r[rFrom++] = a[j++];
                    }
                } else if (j == aTo && k < bTo) {
                    r[rFrom++] = b[k++];
                } else if (j < aTo && k == bTo) {
                    r[rFrom++] = a[j++];
                }
            } else {
                if (j < aTo && k < bTo && a[j] == b[k] ) {
                    r[rFrom++] = a[j++];
                    r[rFrom++] = b[k++];
                    i++;
                } else if (j < aTo && k < bTo && a[j] != b[k]) {
                    if (a[j] > b[k]) {
                        r[rFrom++] = b[k++];
                    } else {
                        r[rFrom++] = a[j++];
                    }

                } else if (j < aTo && k == bTo) {
                    r[rFrom++] = a[j++];
                } else if (j == aTo && k < bTo) {
                    r[rFrom++] = b[k++];
                }

            }
        }


    }


    // 0 1 2 3 4 5 6 7 8
    // 4 1 3 3 1 3 4 5 1   (1) 1 3 5 7 9
    // 14  33 13  45 1     (2) 1 5 9
    // 1334 1345 1         (3) 1 7
    //  1133445 1          (4) 1
    // 11133445
    //

    // 0 1 2 3 4 5
    // 1 2 4 2 5 6  1
    //


    public static void mergeSort(int[] a) {
        int[] array = new int[a.length];
        for (int k = 1; k < a.length; k = k * 2) {
            for (int j = k; j - k < a.length; j += k * 2) {
                if (j < a.length && j + k <= a.length) {
                    ArrayUtils.merge(a, (j - k), j, a, j, (j + k), array, (j - k));
                } else if (j < a.length && j + k > a.length) {
                    ArrayUtils.merge(a, (j - k), j, a, j, array.length, array, (j - k));
                } else {
                    System.arraycopy(a, (j - k), array, (j - k),  k-(j-a.length));

                }


            }
            System.arraycopy(array, 0, a, 0, a.length);


        }



    }
    public static void mergeSort(Event[] events){
        Event[] t = new Event[events.length];
        for (int size = 1; size < events.length; size *= 2) {
            System.arraycopy(events, 0, t, 0, events.length);
            for (int l = 0; l + size < events.length; l += 2 * size) {
                int m = l + size;
                int r = m + size;
                if (r > events.length) {
                    r = events.length;
                }
                int i = l;
                int j = m;
                int k = l;
                while (i < m && j < r) {
                    events[k++] = t[i].compareTo(t[j])!=1 ? t[i++] : t[j++];
                }
                while (i < m) {
                    events[k++] = t[i++];
                }
                while (j < r) {
                    events[k++] = t[j++];
                }
            }
        }
    }

    public static void merge(Event[] a, int aFrom, int aTo, Event[] b, int bFrom, int bTo, Event[] r, int rFrom){
        int limit =  aTo - aFrom + bTo - bFrom;
        for (int i = 0, j = aFrom, k = bFrom; i < limit; i++) {
            if (aTo - aFrom == bTo - bFrom) {
                if (j < aTo && k < bTo) {
                    if (a[j].compareTo( b[k])==0) {
                        r[rFrom++] = a[j++];
                        r[rFrom++] = b[k++];
                        i++;
                    } else if (a[j].compareTo( b[k])==1) {
                        r[rFrom++] = b[k++];
                    } else {
                        r[rFrom++] = a[j++];
                    }
                } else if (j == aTo && k < bTo) {
                    r[rFrom++] = b[k++];
                } else if (j < aTo && k == bTo) {
                    r[rFrom++] = a[j++];
                }
            } else {
                if (j < aTo && k < bTo && a[j] == b[k] ) {
                    r[rFrom++] = a[j++];
                    r[rFrom++] = b[k++];
                    i++;
                } else if (j < aTo && k < bTo && a[j] != b[k]) {
                    if (a[j].compareTo( b[k])==1) {
                        r[rFrom++] = b[k++];
                    } else {
                        r[rFrom++] = a[j++];
                    }

                } else if (j < aTo && k == bTo) {
                    r[rFrom++] = a[j++];
                } else if (j == aTo && k < bTo) {
                    r[rFrom++] = b[k++];
                }

            }
        }


    }
  public static   void mergeSort(int[] array, int fromIndex, int toIndex){
          int[] t = new int[array.length];
          for (int size = 1; size < toIndex-fromIndex; size *= 2) {
              System.arraycopy(array, 0, t, 0, array.length);
              for (int l = fromIndex; l + size < toIndex; l += 2 * size) {
                  int m = l + size;
                  int r = m + size;
                  if (r > array.length) {
                      r = array.length;
                  }
                  int i = l;
                  int j = m;
                  int k = l;
                  while (i < m && j < r) {
                      array[k++] = t[i] <= t[j] ? t[i++] : t[j++];
                  }
                  while (i < m) {
                      array[k++] = t[i++];
                  }
                  while (j < r) {
                      array[k++] = t[j++];
                  }
              }
          }
      }

    public static   void mergeSort(Event[] array, int fromIndex, int toIndex){
        Event[] t = new Event[array.length];
        for (int size = 1; size < toIndex-fromIndex; size *= 2) {
            System.arraycopy(array, 0, t, 0, array.length);
            for (int l = fromIndex; l + size < toIndex; l += 2 * size) {
                int m = l + size;
                int r = m + size;
                if (r > array.length) {
                    r = array.length;
                }
                int i = l;
                int j = m;
                int k = l;
                while (i < m && j < r) {
                    array[k++] = t[i].compareTo(t[j])!=1 ? t[i++] : t[j++];
                }
                while (i < m) {
                    array[k++] = t[i++];
                }
                while (j < r) {
                    array[k++] = t[j++];
                }
            }
        }
    }
  }













