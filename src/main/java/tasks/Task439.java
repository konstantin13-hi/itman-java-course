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
            if ((events[i].getYear() > a.getYear()) ||
                    (events[i].getYear() == a.getYear() && events[i].getMonth() > a.getMonth()) ||
                    (events[i].getYear() == a.getYear() && events[i].getMonth() == a.getMonth() && events[i].getDay() > a.getDay()) ||
                    (events[i].getYear() == a.getYear() && events[i].getMonth() == a.getMonth() && events[i].getDay() == a.getDay())) {
                a = events[i];
            }
        }
        return a;
    }
}


