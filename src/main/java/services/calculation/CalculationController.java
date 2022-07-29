package services.calculation;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {
    /**
     * Returns result of operation
     *
     * @cpu O(1)
     * @ram O(1)
     * @param firstVariable first number
     * @param secondVariable operator
     * @param thirdViable second number
     * @return result
     */

    @GetMapping("/calculation")
    public int operation(@RequestParam(name = "term1") int firstVariable,
                         @RequestParam(name = "operator") Calculation.Operators secondVariable,
                         @RequestParam(name = "term2") int thirdViable) {
        return secondVariable.action(firstVariable, thirdViable);

    }

    /**
     *Return all kind of operators
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return all kind of operators
     */

    @GetMapping("/operators")
    public Calculation.Operators[] returnOperators() {
        return Calculation.Operators.values();
    }
}
