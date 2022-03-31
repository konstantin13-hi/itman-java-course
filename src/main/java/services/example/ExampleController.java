package services.example;


import utils.*;

import org.springframework.web.bind.annotation.*;
import utils.StringBuilder;

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
    @PostMapping("/extract/{pathVariable}/{second}")
    public String extract(@PathVariable String pathVariable,
                          @PathVariable(name = "second") int secondVariable,
                          @RequestParam String required,
                          @RequestParam(required = false) String optional,
                          @RequestParam(name = "default", defaultValue = "-1") int defaultValue,
                          @RequestBody String body) {
        return "pathVariable = " + pathVariable + "\n"
                + "second = " + secondVariable + "\n"
                + "required = " + required + "\n"
                + "optional = " + optional + "\n"
                + "default = " + defaultValue + "\n"
                + "body = " + body + "\n";
    }
    @GetMapping("/api/range")
    public String indexApi(@RequestParam(name = "from") int firstVariable,
                           @RequestParam(name = "to") int secondVariable){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = firstVariable; i < secondVariable; i++) {
            stringBuilder.append(i).append("\n");
        }
        return stringBuilder.toString();
    }

    @GetMapping("/api/range/{FROM}/{TO}")
    public String indexApiSecond(@PathVariable(name = "FROM") int firstVariable,
                                 @PathVariable(name = "TO") int secondVariable){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = firstVariable; i < secondVariable; i++) {
            stringBuilder.append(i).append("\n");
        }
        return stringBuilder.toString();
    }
}