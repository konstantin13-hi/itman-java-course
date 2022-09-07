package services.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {
    /**
     * Returns result of operation.
     *
     * @param firstVariable  first number
     * @param secondVariable operator
     * @param thirdViable    second number
     * @return result
     * @cpu O(1)
     * @ram O(1)
     */

    @GetMapping("/calculation")
    public int operation(@RequestParam(name = "term1") int firstVariable,
                         @RequestParam(name = "operator") Calculation.Operators secondVariable,
                         @RequestParam(name = "term2") int thirdViable) {
        return secondVariable.action(firstVariable, thirdViable);

    }

    /**
     * Return all kind of operators.
     *
     * @return all kind of operators
     * @cpu O(1)
     * @ram O(1)
     */

    @GetMapping("/operators")
    public Calculation.Operators[] returnOperators() {
        return Calculation.Operators.values();
    }

}
