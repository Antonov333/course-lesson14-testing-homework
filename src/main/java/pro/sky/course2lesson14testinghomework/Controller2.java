package pro.sky.course2lesson14testinghomework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

    private final CalculatorService calculatorService = new CalculatorService();

    @GetMapping()
    public String hint() {
        return calculatorService.hint();
    }
}
