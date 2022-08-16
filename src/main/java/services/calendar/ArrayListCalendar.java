package services.calendar;

import entities.Event;

import java.util.Arrays;

public class ArrayListCalendar {
    private int logicalSize;
    private int id;
    private Event[] events;

    /**
     * Create array events with length equals 10
     *
     * @cpu O(1)
     * @ram O(1)
     */

    public ArrayListCalendar() {
        events = new Event[10];
    }

    /**
     * Create array events with length equals capacity
     * <p>
     * n=input number
     *
     * @param capacity the first term
     * @cpu O(1)
     * @ram O(n)
     */
    public ArrayListCalendar(int capacity) {
        events = new Event[capacity];
    }

    /**
     * Create array with special length
     * <p>
     * n=that.size
     *
     * @param that the first term
     * @cpu 0(n)
     * @ram 0(n)
     */
    public ArrayListCalendar(ArrayListCalendar that) {
        logicalSize = that.logicalSize;
        Event[] arraySecond = new Event[that.logicalSize];
        System.arraycopy(that.events, 0, arraySecond, 0, that.logicalSize);
        events = arraySecond;
    }

    /**
     * Add Event
     *
     * @param a the first term
     * @cpu O(1)
     * @ram O(1)
     */
    public void addEvent(Event a) {
        if (logicalSize == events.length) {
            Event[] newEvents = new Event[events.length * 2];
            System.arraycopy(events, 0, newEvents, 0, logicalSize);
            events = newEvents;
        }
        events[logicalSize++] = new Event(1 + id++, a.getYear(), a.getMonth(), a.getDay(), a.getName());
    }

    /**
     * Deleting an event by id
     * <p>
     * n=length array of events
     *
     * @param id the first term
     * @cpu O(n)
     * @ram O(1)
     */
    public void deleteEvent(int id) {
        for (int i = id; i < events.length; i++) {
            events[i - 1] = events[i];
        }
        logicalSize--;

    }

    /**
     * event replacement by id
     *
     * @param id id by which there will  change  event
     * @param a  event
     * @cpu O(1)
     * @ram O(1)
     */
    public void changeEvent(int id, Event a) {
        events[id] = new Event(id, a.getDay(), a.getMonth(), a.getYear(), a.getName());
    }

    /**
     * Returns a string containing all events in sorted order
     * return string contains event with parameters year, month ,day
     * n=logicalSize
     * f=amount of elements in the array
     * l=sum of two length name
     * k=length of string
     *
     * @return all events
     * @cpu O(n + f * log ( f)*k)=n*log(n)*k
     * @ram O(n + f * l)=n*l
     */
    public Event[] returnAllEvents() {
        Event[] newEvent = toArray();
        mergeSort(newEvent);
        return newEvent;
    }

    /**
     * return string contains event with parameters year
     * n=logicalSize
     * m=amount of elements with correct dates
     * f=amount of elements in the array
     * l=sum of two length name
     * k=length of string
     *
     * @param year the first term
     * @return string containing events with a year equal to the input parameter
     * @cpu O(n + m + f * log ( f)*k)=n*log(n)*k
     * @ram O(n + m + f * l)=n*l
     */
    public Event[] returnEventsYear(int year) {
        Event[] newEvent = toArray();
        int sum = 0;
        for (int i = 0; i < newEvent.length; i++) {
            if (newEvent[i].getYear() == year) {
                sum++;
            }
        }
        Event[] eventsYear = new Event[sum];
        int index = 0;
        for (int i = 0; i < newEvent.length; i++) {
            if (newEvent[i].getYear() == year) {
                eventsYear[index++] = newEvent[i];
            }
        }
        mergeSort(eventsYear);

        return eventsYear;

    }

    /**
     * return string contains event with parameters year, month ,day
     * n=logicalSize
     * m=amount of elements with correct dates
     * f=amount of elements in the array
     * l=sum of two length name
     * k=length of string
     *
     * @param year  the first term
     * @param month the second term
     * @return string contains event with parameters year, month
     * @cpu O(n + m + f * log ( f)*k)=n*log(n)*k
     * @ram O(n + m + f * l)=n*l
     */

    public Event[] returnEventsYearAndMonth(int year, int month) {
        Event[] newEvent = toArray();
        int sum = 0;
        for (int i = 0; i < newEvent.length; i++) {
            if (newEvent[i].getYear() == year && newEvent[i].getMonth() == month) {
                sum++;
            }
        }
        Event[] eventsYear = new Event[sum];
        int index = 0;
        for (int i = 0; i < newEvent.length; i++) {
            if (newEvent[i].getYear() == year && newEvent[i].getMonth() == month) {
                eventsYear[index++] = newEvent[i];
            }
        }
        mergeSort(eventsYear);
        return eventsYear;
    }

    /**
     * return string contains event with parameters year, month ,day
     * n=logicalSize
     * m=amount of elements with correct dates
     * f=amount of elements in the array
     * l=sum of two length name
     * k=length of string
     *
     * @param year  the first term says about which year need
     * @param month the second says about which month need
     * @param day   the third term says about which day need
     * @return string contains event with parameters year, month ,day
     * @cpu O(n + m + f * log ( f)*k)=n*log(n)*k
     * @ram O(n + m + f * l)=n*l
     */

    public Event[] returnEventsYearAndMonthDay(int year, int month, int day) {
        Event[] newEvent = toArray();
        int sum = 0;
        for (int i = 0; i < newEvent.length; i++) {
            if (newEvent[i].getYear() == year && newEvent[i].getMonth() == month && newEvent[i].getDay() == day) {
                sum++;
            }
        }
        Event[] eventsYear = new Event[sum];
        int index = 0;
        for (int i = 0; i < newEvent.length; i++) {
            if (newEvent[i].getYear() == year && newEvent[i].getMonth() == month && newEvent[i].getDay() == day) {
                eventsYear[index++] = newEvent[i];
            }
        }
        mergeSort(eventsYear);
        return eventsYear;
    }

    /**
     * Create array of numbers
     * <p>
     * n=logicalSize
     *
     * @return new array
     * @cpu 0(n)
     * @ram 0(n)
     */
    public Event[] toArray() {
        Event[] newEvent = new Event[logicalSize];
        System.arraycopy(events, 0, newEvent, 0, logicalSize);
        return newEvent;
    }

    /**
     * Make merge sort
     * <p>
     * n=amount of elements in the array
     * k=length of string
     * l=sum of two length name
     *
     * @param events the first term
     * @cpu O(nlog ( n)*k)
     * @ram O(n * l)
     */
    public static void mergeSort(Event[] events) {
        ArrayListCalendar.mergeSort(events, 0, events.length);
    }

    /**
     * Merge sort
     * n=index differences between start and end
     * k=length of string
     * l=sum of two length name
     *
     * @param array     the first array variable
     * @param fromIndex the index of the first array, indicating the start of the sort
     * @param toIndex   the index of the first array indicating the end of the sort
     * @cpu O(nlog ( n)*k)
     * @ram O(n * l)
     */
    public static void mergeSort(Event[] array, int fromIndex, int toIndex) {
        Event[] t = new Event[array.length];
        int length = toIndex - fromIndex;
        for (int k = 1; k < length; k = k * 2) {
            for (int j = fromIndex; j < toIndex; j += k * 2) {
                if (j + k < toIndex && j + k * 2 <= toIndex) {
                    ArrayListCalendar.merge(array, j, j + k, array, j + k, j + k * 2, t, j);
                } else if (j + k < toIndex && j + k * 2 > toIndex) {
                    ArrayListCalendar.merge(array, j, j + k, array, j + k, toIndex, t, j);
                } else {
                    System.arraycopy(array, j, t, j, array.length - j);
                }
            }
            System.arraycopy(t, fromIndex, array, fromIndex, length);
        }
    }

    /**
     * Merge two arrays with sorted elements
     * <p>
     * n=differences between start and end index of the first array
     * m=differences between start and end index of the second array
     * l=sum of two length name
     * k=length of string
     *
     * @param a     the first array variable
     * @param aFrom the index of the first array, indicating the start of the sort
     * @param aTo   the index of the first array indicating the end of the sort
     * @param b     the second array variable
     * @param bFrom the index of the second array, indicating the start of the sort
     * @param bTo   the index of the second array indicating the end of the sort
     * @param r     the third array variable,where the first two arrays are merged and the elements are sorted
     * @param rFrom the index of the third array, indicating the start of the sort
     * @cpu O(( n + m)k)
     * @ram O(l)
     */
    public static void merge(Event[] a, int aFrom, int aTo, Event[] b, int bFrom, int bTo, Event[] r, int rFrom) {
        int limit = aTo - aFrom + bTo - bFrom;
        for (int i = 0, j = aFrom, k = bFrom; i < limit; i++) {
            if (j < aTo && k < bTo) {
                int resultOfComparingTwoEvents = a[j].compareTo(b[k]);
                if (resultOfComparingTwoEvents == 0) {
                    r[rFrom++] = compareTo(a[j], b[k]) < 1 ? a[j++] : b[k++];
                } else {
                    r[rFrom++] = resultOfComparingTwoEvents < 1 ? a[j++] : b[k++];
                }
            } else if (j < aTo && k == bTo) {
                r[rFrom++] = a[j++];
            } else if (j == aTo && k < bTo) {
                r[rFrom++] = b[k++];
            }
        }
    }

    /**
     * Compares two string of  objects (a, b) given as parameters
     * It returns the value:
     * 0: if (firstName==secondName)
     * -1: if (firstName < secondName)
     * 1: if (firstName > secondName)
     * <p>
     * n=amount of leters of thirst event
     * m=amount of leters of second event
     *
     * @param a the first event
     * @param b the second event
     * @return result
     * @cpu O(n)
     * @ram O(n + m)
     */
    public static int compareTo(Event a, Event b) {
        //null
        char[] chars = a.getName().toCharArray();
        char[] that = b.getName().toCharArray();
        int result = 0;
        if (that.length < chars.length) {
            result = 1;
        }
        if ((that.length == chars.length) && !Arrays.equals(that, chars)) {
            for (int i = 0; i < chars.length; i++) {
                if (that[i] != chars[i]) {
                    if ((int) that[i] < (int) chars[i]) {
                        result = 1;
                    } else result = -1;
                }
            }
        }

        return result;
    }

    /**
     * Create a string
     * <p>
     * n=logicalSize
     * j=letetals in the string
     *
     * @return new string
     * @cpu 0(n * j)
     * @ram 0(n * j)
     */
    public String toString(Event[] a) {
        StringBuilder stringBuilder = new StringBuilder();
        if (a.length == 0) {
            return "[]";
        }
        stringBuilder.append("[");
        for (int i = 0; i < a.length; i++) {
            if (i != a.length - 1) {
                stringBuilder.append(a[i].toString()).append(",").append('\n');
            } else {
                stringBuilder.append(a[i].toString());
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * Find size
     *
     * @return size
     * @cpu 0(1)
     * @ram 0(1)
     */
    public int size() {
        return logicalSize;
    }


    /**
     * Get event
     *
     * @param index the first term
     * @return number from arraylist
     * @cpu 0(1)
     * @ram 0(1)
     */
    public Event get(int index) {
        return events[index];
    }

}
