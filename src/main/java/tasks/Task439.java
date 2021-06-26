package tasks;


import entities.Event;

public class Task439 {
    /**
     * Sort events of array .
     *
     * @cpu O(n)
     * @ram O(1)
     *
     * @param events the first term
     * @return  one element of array  which have the biggest date  .
     */

    public static Event findLast(Event[] events) {
        if (events.length == 0) {
            return null;
        }
        Event a = events[0];
        for (int i = 0; i < events.length; i++) {
            if (events[i].year > a.year) {
                a = events[i];
            } else if (events[i].year == a.year && events[i].month > a.month) {
                a = events[i];
            } else if (events[i].year == a.year && events[i].month == a.month && events[i].day > a.day) {
                a = events[i];
            } else if (events[i].year == a.year && events[i].month == a.month && events[i].day == a.day) {
                a = events[i];
            }

        }


        return a;

    }

}


