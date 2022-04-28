package services.example;


import org.springframework.web.bind.annotation.*;
import utils.StringBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    /**
     * Return string with text:"I'm your first web-service"
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return string with text:"I'm your first web-service"
     */
    @GetMapping("/")
    public String index() {
        return "I'm your first web-service";
    }

    /**
     * Return string with text: "I'm the second binding"
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return string with text: "I'm the second binding"
     */
    @GetMapping("/second")
    public String indexSecond() {
        return "I'm the second binding";
    }

    /**
     * Return string with text:"I'm post mapping"
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return string with text:"I'm post mapping"
     */

    @PostMapping("/second")
    public String indexPost() {
        return "I'm post mapping";
    }

    /**
     * Return string with text:"I'm put mapping"
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return string with text:"I'm put mapping"
     */

    @PutMapping("/second")
    public String indexPut() {
        return "I'm put mapping";
    }

    /**
     * Return string with text:"I'm patch mapping"
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return string with text:"I'm patch mapping"
     */
    @PatchMapping("/second")
    public String indexPatch() {
        return "I'm patch mapping";
    }

    /**
     * Return string with text:"I'm delete mapping"
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return string with text:"I'm delete mapping"
     */
    @DeleteMapping("/second")
    public String indexDelete() {
        return "I'm delete mapping";
    }

    /**
     * Returns data from URI and request body
     *
     * n=amount of received data
     *
     * @cpu 0(n)
     * @ram 0(1)
     *
     * @param pathVariable contains some string
     * @param secondVariable contains some number
     * @param required contains some string
     * @param optional contains some string
     * @param defaultValue contains some number
     * @param body contains some string
     * @return data from URI and request body
     */
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

    /**
     * Return numbers from firstVariable to secondVariable
     *
     * n= difference between secondVariable and firstVariable
     *
     * @cpu 0(n)
     * @ram 0(n)
     * @param firstVariable the number from which the return of numbers begins
     * @param secondVariable the number up to which the numbers are returned
     * @return numbers from firstVariable to secondVariable
     */
    @GetMapping("/api/range")
    public String indexApi(@RequestParam(name = "from") int firstVariable,
                           @RequestParam(name = "to") int secondVariable) {
        return stringBuilder(firstVariable,secondVariable);
    }

    /**
     * Return numbers from firstVariable to secondVariable
     *
     * n= difference between secondVariable and firstVariable
     *
     * @cpu 0(n)
     * @ram 0(n)
     * @param firstVariable the number from which the return of numbers begins
     * @param secondVariable the number up to which the numbers are returned
     * @return numbers from firstVariable to secondVariable
     */
    @GetMapping("/api/range/{FROM}/{TO}")
    public String indexApiSecond(@PathVariable(name = "FROM") int firstVariable,
                                 @PathVariable(name = "TO") int secondVariable) {
        return stringBuilder(firstVariable,secondVariable);
    }

    public String stringBuilder(int firstParam,int secondParam){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = firstParam; i < secondParam; i++) {
            stringBuilder.append(i).append("\n");
        }
        return stringBuilder.toString();
    }
}