package tasks;


import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task439Tests {

    @Test
    public void findTheElementOfArrayWhichHaveTheBiggestDate() {


        Event[] events = new Event[]{
                new Event(1994, 11, 12, "sae1"),
                new Event(1994, 2, 4, "sa3"),
                new Event(31, 3, 5, "rew")
        };
        Event actual = Task439.findLast(events);
        assert actual != null;
        Assertions.assertEquals( "sae1", actual.name);
        Assertions.assertEquals( 12, actual.day);
        Assertions.assertEquals( 11, actual.month);
        Assertions.assertEquals( 1994, actual.year);
    }

    @Test
    public void findTheElementOfArrayWhichHaveTheBiggestDateWhenTwoNameSame(){
        Event[] events = new Event[]{
                new Event(2000, 11, 12, "Day of City in Gomel"),
                new Event(1424, 9, 8, "Day of City in Minsk"),
                new Event(231, 2, 6, "Day of City in Vitebsk"),
                new Event(314, 7, 15, "Day of City in Borisow"),
                new Event(2031, 11, 13, "Day of City in Minsk")
        };
        Event actual = Task439.findLast(events);
        assert actual != null;
        Assertions.assertEquals( 2031, actual.year);
        Assertions.assertEquals( 13, actual.day);
        Assertions.assertEquals( 11, actual.month);
        Assertions.assertEquals( "Day of City in Minsk", actual.name);
    }
    @Test
    public void findTheElementOfArrayWhichHaveTheBiggestDateIfArrayEmpty() {
        Event[] events = new Event[0];
        Event actual = Task439.findLast(events);
        Assertions.assertNull(actual);
    }
}