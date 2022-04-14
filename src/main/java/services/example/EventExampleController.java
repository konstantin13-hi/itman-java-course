package services.example;
import entities.Event;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventExampleController {

    public Event event;

    @PostMapping("/api/event")
    public void postA(@RequestBody Event a) { // JSON из тела сообщения десереализуется в объект и ссылка на объект положиться в переменную a.
       event=a;
    }

    @GetMapping("/api/event")
    public Event getA() {
        return event;
    }


}
