package tasks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task408Tests {

    @Test
    public void sumPositiveValues() {

        Event[] events = new Event[]{
                new Event(1994,11,12, "sae1"),
                new Event(1994,2,4,"sa3"),
                new Event(31,3,5,"rew")
        };
        Event expectedLink = events[0];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expectedLink, actual);


    }
}
