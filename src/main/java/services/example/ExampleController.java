package services.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleController {
    @GetMapping("/")
    /**
     * @cpu O(1)
     * @ram O(1)
     */
    public String index() {
        return "I'm your first web-service";
    }
    @GetMapping("/second")
    /**
     * @cpu O(1)
     * @ram O(1)
     */
    public String indexSecond() {
        return "I'm the second binding";
    }
    @PostMapping("/second")
    public String indexPost() {
        return "I'm post mapping";
    }
    @PutMapping("/second")
    public String indexPut() {
        return "I'm put mapping";
    }
    @PatchMapping("/second")
    public String indexPatch() {
        return "I'm patch mapping";
    }
    @DeleteMapping("/second")
    public String indexDelete() {
        return "I'm delete mapping";
    }
}