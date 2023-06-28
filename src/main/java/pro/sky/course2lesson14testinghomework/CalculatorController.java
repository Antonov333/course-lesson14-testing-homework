package pro.sky.course2lesson14testinghomework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService = new CalculatorService();

    @GetMapping
    public String hint() {
        return calculatorService.hint();
    }

    @GetMapping(path = "/calculator/")
    public String welcome() {
        return calculatorService.welcome();
    }

    @GetMapping(path = "/calculator/plus/")
    public String plus(@RequestParam(name = "num1", required = false) Integer userNum1,
                       @RequestParam(name = "num2", required = false) Integer userNum2) {
        return calculatorService.plus(userNum1, userNum2);
    }

    @GetMapping(path = "/calculator/divide/")
    public String divide(@RequestParam(name = "num1", required = false) Integer userNum1,
                         @RequestParam(name = "num2", required = false) Integer userNum2) {
        return calculatorService.divide(userNum1, userNum2);
    }

    @GetMapping(path = "/calculator/minus/")
    public String minus(@RequestParam(name = "num1", required = false) Integer num1,
                        @RequestParam(name = "num2", required = false) Integer num2) {
        return calculatorService.minus(num1, num2);
    }

    @GetMapping(path = "/calculator/multiply/")
    public String multiply(@RequestParam(name = "num1", required = false) Integer num1,
                           @RequestParam(name = "num2", required = false) Integer num2) {
        return calculatorService.multiply(num1, num2);
    }


}
