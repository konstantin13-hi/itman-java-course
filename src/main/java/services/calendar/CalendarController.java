package services.calendar;

import collections.ArrayList;
import entities.Event;
import org.springframework.web.bind.annotation.*;
import entities.Ticket;
import  services.calendar.ArrayListCalendar;

@RestController
public class CalendarController {
    private ArrayListCalendar arrayListCalendar;

    /**
     * Create arrayList
     *
     * @cpu O(1)
     * @ram O(1)
     */
    public CalendarController() {
        arrayListCalendar = new ArrayListCalendar();
    }

    /**
     * Add Event in calendar
     *
     * @cpu O(1)
     * @ram O(1)
     * @param a the event
     */

    @PostMapping("/calendar/addEvent")
    public void addEvent(@RequestBody Event a) {
        arrayListCalendar.addEvent(a);
    }

    /**
     *return events with  year,month,day
     * n=logicalSize
     * m=amount of elements with correct dates
     * f=amount of elements in the array
     * l=sum of two length name
     * k=length of string
     * @cpu O(n+m+f*log(f)*k)=n*log(n)*k
     * @ram O(n+m+f*l)=n*l
     * @param firstVariable keeps int year
     * @param secondVariable keeps int month
     * @param thirdViable keeps int day
     * @return events with  year,month,day
     */
    @GetMapping("/calendar/yearMonthDay")
    public Event[] indexApi(@RequestParam(name = "year") int firstVariable,
                           @RequestParam(name = "month") int secondVariable,
                           @RequestParam(name = "day") int thirdViable) {
        return arrayListCalendar.returnEventsYearAndMonthDay(firstVariable, secondVariable, thirdViable);
    }

    /**
     * return events with  year,month
     * n=logicalSize
     * m=amount of elements with correct dates
     * f=amount of elements in the array
     * l=sum of two length name
     * k=length of string
     * @cpu O(n+m+f*log(f)*k)=n*log(n)*k
     * @ram O(n+m+f*l)=n*l
     * @param firstVariable keeps int year
     * @param secondVariable keeps int month
     * @return events with year,month,day
     */
    @GetMapping("/calendar/yearMonth")
    public Event[] indexApi(@RequestParam(name = "year") int firstVariable,
                           @RequestParam(name = "month") int secondVariable) {
        return arrayListCalendar.returnEventsYearAndMonth(firstVariable, secondVariable);
    }

    /**
     * return events with  year
     * n=logicalSize
     * m=amount of elements with correct dates
     * f=amount of elements in the array
     * l=sum of two length name
     * k=length of string
     * @cpu O(n+m+f*log(f)*k)=n*log(n)*k
     * @ram O(n+m+f*l)=n*l
     * @param firstVariable keeps int year
     * @return events with  year
     */
    @GetMapping("/calendar/year")
    public Event[] indexApi(@RequestParam(name = "year") int firstVariable) {
        return arrayListCalendar.returnEventsYear(firstVariable);
    }

    /**
     * return all events
     * n=logicalSize
     * f=amount of elements in the array
     * l=sum of two length name
     * k=length of string
     * @cpu O(n+f*log(f)*k)=n*log(n)*k
     * @ram O(n+f*l)=n*l
     * @return all events
     */
    @GetMapping("/calendar/allEvents")
    public Event[] indexApi() {
        return arrayListCalendar.returnAllEvents();
    }

    /**
     * event replacement by id
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param firstVariable the number of id
     * @param a the event
     */
    @PatchMapping("/calendar/changeEvent")
    public void changeEvent(@RequestParam(name = "id") int firstVariable,
                            @RequestBody Event a) {
        arrayListCalendar.changeEvent(firstVariable, a);
    }

    /**
     * Deleting an event by id
     *
     * n=length array of events
     *
     * @cpu O(n)
     * @ram O(1)
     * @param firstVariable the number of id
     */
    @DeleteMapping("/calendar/deleteEvent")
    public void deleteEvent(@RequestParam(name = "id") int firstVariable) {
        arrayListCalendar.deleteEvent(firstVariable);
    }

}
