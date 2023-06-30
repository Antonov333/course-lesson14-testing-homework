package pro.sky.course2lesson14testinghomework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator/")
public class CalculatorController {

    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int MULTIPLY = 2;
    public static final int DIVIDE = 3;


    private final CalculatorService calculatorService = new CalculatorService();

    @GetMapping()
    public String welcome() {
        return calculatorService.welcome();
    }

    @GetMapping(path = "/plus/")
    public String plus(@RequestParam(name = "num1", required = false) Integer userNum1,
                       @RequestParam(name = "num2", required = false) Integer userNum2) {
        return ResultToString.maker(PLUS, userNum1, userNum2, calculatorService.plus(userNum1, userNum2));
    }

    @GetMapping(path = "/divide/")
    public String divide(@RequestParam(name = "num1", required = false) Integer userNum1,
                         @RequestParam(name = "num2", required = false) Integer userNum2) {
        return ResultToString.maker(DIVIDE, userNum1, userNum2, calculatorService.divide(userNum1, userNum2));
    }

    @GetMapping(path = "/minus/")
    public String minus(@RequestParam(name = "num1", required = false) Integer num1,
                        @RequestParam(name = "num2", required = false) Integer num2) {
        return ResultToString.maker(MINUS, num1, num2, calculatorService.minus(num1, num2));
    }

    @GetMapping(path = "/multiply/")
    public String multiply(@RequestParam(name = "num1", required = false) Integer num1,
                           @RequestParam(name = "num2", required = false) Integer num2) {
        return ResultToString.maker(MULTIPLY, num1, num2, calculatorService.multiply(num1, num2));
    }

}
