package pro.sky.course2lesson14testinghomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void hintTest() {
        String expected = "<b>Hi! <br><br>Welcome to simple <a href=\"http://localhost:8080/calculator/\">Calculator</a>!";
        assertEquals(expected, calculatorService.hint());
    }

    @Test
    public void welcomeTest() {
        String expected = "<b>Welcome to simple calculator!</b><br><br><a href=\"http://localhost:8080/calculator/plus/?num1=5&num2=5\"> Plus </a> | <a href=\"http://localhost:8080/calculator/minus/?num1=5&num2=5\"> Minus </a> | <a href=\"http://localhost:8080/calculator/multiply/?num1=5&num2=5\"> Multiply </a> | <a href=\"http://localhost:8080/calculator/divide/?num1=5&num2=5\"> Divide </a>";
        String actual = calculatorService.welcome();
        assertEquals(expected, actual);
    }

    @Test
    public void plusTest() {

        assertEquals(10, calculatorService.plus(5, 5));
        assertEquals(30, calculatorService.plus(15, 15));

    }

    @Test
    public void divideTest() {
        assertEquals(1, calculatorService.divide(5, 5));
        assertEquals(1, calculatorService.divide(15, 15));
    }

    @Test
    public void divideByZeroTest() {
        Assertions.assertThrows(DivByZeroException.class, () -> calculatorService.divide(5, 0), "Division by zero");
    }

    @Test
    public void minusTest() {
        assertEquals(0, calculatorService.minus(5, 5));
        assertEquals(14, calculatorService.minus(15, 1));
    }

    @Test
    public void multiplyTest() {
        assertEquals(25, calculatorService.multiply(5, 5));
        assertEquals(225, calculatorService.multiply(15, 15));
    }
}
