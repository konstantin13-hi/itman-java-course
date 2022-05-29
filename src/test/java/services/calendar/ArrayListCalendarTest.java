package services.calendar;

import benchmarks.SortBenchmark;
import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListCalendarTest {

    @Test
    void addEvent() {
        ArrayListCalendar arrayListCalendar = new ArrayListCalendar();
        arrayListCalendar.addEvent(new Event(1,1,1,"d"));
        arrayListCalendar.addEvent(new Event(1,1,1,"d"));
        arrayListCalendar.addEvent(new Event(1,1,1,"d"));
        arrayListCalendar.addEvent(new Event(1,1,1,"d"));
        arrayListCalendar.addEvent(new Event(1,1,1,"d"));
        arrayListCalendar.addEvent(new Event(1,1,1,"d"));
        arrayListCalendar.addEvent(new Event(1,1,1,"d"));
        arrayListCalendar.addEvent(new Event(1,1,1,"d"));
        arrayListCalendar.addEvent(new Event(1,1,1,"d"));
        arrayListCalendar.addEvent(new Event(1,1,1,"d"));
        arrayListCalendar.addEvent(new Event(1,1,1,"d"));
        Assertions.assertEquals(arrayListCalendar.size(),11);
    }

    @Test
    void deleteEvent() {
        ArrayListCalendar arrayListCalendar = new ArrayListCalendar();
        Event[] events = new Event[]{
                new Event(1,11, 1, 1, "MINSK"),
                new Event(2,21, 2, 2, "VITEBS"),
                new Event(3,31, 3, 3, "DADA"),
                new Event(4,41, 4, 4, "jJOJ"),
                new Event(5,51, 5, 5, "lOLld"),
                new Event(6,61, 7, 6, "KIK"),
                new Event(7,71, 8, 7, "slel")};
        addEvents(arrayListCalendar,events);
        Event [] newEvent = new Event[6];
        newEvent[0]=arrayListCalendar.get(0);
        newEvent[1]=arrayListCalendar.get(2);
        newEvent[2]=arrayListCalendar.get(3);
        newEvent[3]=arrayListCalendar.get(4);
        newEvent[4]=arrayListCalendar.get(5);
        newEvent[5]=arrayListCalendar.get(6);
        arrayListCalendar.deleteEvent(2);
        Assertions.assertEquals(arrayListCalendar.size(),6);
        events= arrayListCalendar.toArray();
        checkEvents(events,newEvent);
        System.out.println(events[0].toString());
    }
     public void addEvents(ArrayListCalendar arrayListCalendar,Event[]events){
        for (int i= 0;i<events.length;i++){
            arrayListCalendar.addEvent(events[i]);
        }
     }
     public void checkEvents(Event[]actual,Event []expected){
        for (int i=0;i<expected.length;i++){
         Assertions.assertEquals(expected[i],actual[i]);}
     }


    @Test
    void changeEvent() {
        ArrayListCalendar arrayListCalendar = new ArrayListCalendar();
       Event[] events =new Event[]{new Event(1,1,1,"d"),
               new Event(1, 1, 1, "d"),
               new Event(1, 1, 1, "d"),
               new Event(1, 1, 1, "d"),
               new Event(1, 1, 1, "d"),
               new Event(1, 1, 1, "d")};
       addEvents(arrayListCalendar,events);

    }

    public Event[] createEvent(){
        return new Event[]{
                new Event(2001, 3, 13, "DOT"),
                new Event(2011, 3, 21, "dXD"),
                new Event(2013, 1, 14, "dDS"),
                new Event(2011, 4, 5, "dED"),
                new Event(2011, 7, 8, "dDX"),
                new Event(2011, 8, 7, "dDS"),
                new Event(2012, 9, 3, "DAE"),
                new Event(2001, 10, 11, "ddr"),
                new Event(2011, 11, 1, "DOG"),
                new Event(2013, 1, 1, "DAE"),
                new Event(2012, 2, 1, "JLS"),
                new Event(2001, 3, 1, "dsE"),
                new Event(2031, 1, 11, "WWs"),
                new Event(2001, 12, 1, "dDS"),
                new Event(2031, 1, 11, "wwS"),
                new Event(2011, 11, 1, "DOT"),
                new Event(2031, 1, 1, "dXXV"),
                new Event(2011, 11, 1, "DOTR"),
                new Event(2001, 3, 13, "DO"),
                new Event(2100, 9, 18, "dSAD"),
                new Event(2101, 1, 1, "dXD"),
                new Event(2100, 1, 17, "dSS"),
                new Event(2101, 9, 11, "dDDS"),
                new Event(2100, 1, 1, "dDS")
        };
    }

    @Test
    void returnEventsYear() {
        ArrayListCalendar arrayListCalendar = new ArrayListCalendar();
        addEvents(arrayListCalendar,createEvent());
    }

    @Test
    void returnEventsYearAndMonth() {
        ArrayListCalendar arrayListCalendar = new ArrayListCalendar();
        addEvents(arrayListCalendar,createEvent());
    }

    @Test
    void returnEventsYearAndMonthDay() {
        ArrayListCalendar arrayListCalendar = new ArrayListCalendar();
        addEvents(arrayListCalendar,createEvent());
    }

    @Test
    void mergeSortSpeedTest() {
        Event[] events = SortBenchmark.randomEvents(100_000, -1_000_000, 1_000_000);
        ArrayListCalendar.mergeSort(events);
    }
    @Test
    void mergeSort() {
        Event[] events =new Event[]{
                new Event(1,2001,12,26,"play"),
                new Event(2,2001, 11, 23, "Dinner"),
                new Event(3,2001, 9, 1, "Game"),
                new Event(4,2001, 9, 1, "Gama"),
                new Event(5,2001, 12, 11, "Cat"),
                new Event(6,2001, 1, 25, "Dog")};
        Event[] newEvent = new Event[6];
        newEvent[0]=events[5];
        newEvent[1]=events[3];
        newEvent[2]=events[2];
        newEvent[3]=events[1];
        newEvent[4]=events[4];
        newEvent[5]=events[0];
        ArrayListCalendar.mergeSort(events);
        checkEvents(events,newEvent);

    }
}