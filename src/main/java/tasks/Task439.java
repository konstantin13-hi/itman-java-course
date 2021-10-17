package tasks;


import entities.Event;

public class Task439 {
    /**
     * Find the element of array  which have the biggest date.
     *
     * @cpu O(n)
     * @ram O(1)
     *
     * @param events the first term
     * @return one element of array  which have the biggest date.
     */

    public static Event findLast(Event[] events) {
        if (events.length == 0) {
            return null;
        }
        Event a = events[0];
        for (int i = 0; i < events.length; i++) {
           if (a.compareTo(events[i])==-1){
               a = events[i];
           }
        }
        return a;
    }
}


