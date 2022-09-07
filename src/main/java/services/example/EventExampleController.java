package services.example;

import entities.Event;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventExampleController {

    public Event event;

    /**
     * Take an Event object with data.
     *
     * @param a a parameter that takes an Event object with data
     * @cpu 0(1)
     * @ram 0(1)
     */

    @PostMapping("/api/event")
    public void postA(@RequestBody Event a) {
        event = a;
    }

    /**
     * Return an Event object with data about it.
     *
     * @return an Event object with data about it
     * @cpu 0(1)
     * @ram 0(1)
     */
    @GetMapping("/api/event")
    public Event getA() {
        return event;
    }


}
