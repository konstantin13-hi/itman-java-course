package tasks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task408Tests {

    @Test
    public void sumPositiveValues() {

        Event[] actual = new Event[]{
                new Event(1994,11,12, "sae1"),
                new Event(1994,2,4,"sa3"),
                new Event(31,3,5,"rew")
        };
        Event expected =actual[0];
        Event expected1 =actual[2];

        Task408.sort(actual);
        Assertions.assertEquals(expected, actual[2]);
        Assertions.assertEquals(expected1, actual[0]);


    }
}
