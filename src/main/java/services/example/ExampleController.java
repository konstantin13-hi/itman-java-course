package services.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping("/")
    public String index() {
        return "I'm your first web-service";
    }
    @GetMapping("/second")
    public String indexSecond() {
        return "I'm the second binding";
    }
}