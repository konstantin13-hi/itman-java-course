package tasks;

import entities.Event;

public class Task408 {
    public static void sort(Event[] events) {
        for (int i = 0; i < events.length; i++) {
            for (int j = 1; j < events.length; j++) {
                if (events[j - 1].year > events[j].year) {
                    Event t = events[j - 1];
                    events[j - 1] = events[j];
                    events[j] = t;
                }
                else if (events[j - 1].year == events[j].year &&events[j - 1].month > events[j].month) {
                    Event t = events[j - 1];
                    events[j - 1] = events[j];
                    events[j] = t;
                }
                else if (events[j - 1].year == events[j].year &&events[j - 1].month == events[j].month&&events[j - 1].day > events[j].day) {
                    Event t = events[j - 1];
                    events[j - 1] = events[j];
                    events[j] = t;
                }
            }
        }
    }
}
