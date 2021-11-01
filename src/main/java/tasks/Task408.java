package tasks;

import entities.Event;

public class Task408 {

    /**
     * Sort elements of array .
     *
     * @param events the first term.
     * @cpu O(n ^ 2)
     * @ram O(1)
     * @return
     */
    public static void sort(Event[] events) {
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
}