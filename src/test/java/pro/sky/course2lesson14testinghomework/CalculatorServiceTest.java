package pro.sky.course2lesson14testinghomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    TestData dataSet5_5 = new TestData(5, 5);
    TestData dataSet15_15 = new TestData(15, 15);
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

        String expected = "<b>Plus</b><br><br>5 + 5 = 10";
        assertEquals(expected, calculatorService.plus(5, 5));

        expected = "<b>Plus</b><br><br>15 + 15 = 30";
        assertEquals(expected, calculatorService.plus(15, 15));

    }

    @Test
    public void divideTest() {
        String expected = "<b>Division</b><br><br>5 / 5 = 1";
        assertEquals(expected, calculatorService.divide(5, 5));

        expected = "<b>Division</b><br><br>15 / 15 = 1";
        assertEquals(expected, calculatorService.divide(15, 15));
    }

    @Test
    public void divideByZeroTest() {
        Assertions.assertThrows(DivByZeroException.class, () -> calculatorService.divide(5, 0), "Division by zero");
    }

    @Test
    public void minusTest() {
        String expected = "<b>Minus</b><br><br>5 - 5 = 0";
        assertEquals(expected, calculatorService.minus(5, 5));

        expected = "<b>Minus</b><br><br>15 - 1 = 14";
        assertEquals(expected, calculatorService.minus(15, 1));
    }

    @Test
    public void multiplyTest() {
        String expected = "<b>Multiply</b><br><br>5 * 5 = 25";
        assertEquals(expected, calculatorService.multiply(5, 5));

        expected = "<b>Multiply</b><br><br>15 * 15 = 225";
        assertEquals(expected, calculatorService.multiply(15, 15));
    }

    class TestData {
        private Integer num1;
        private Integer num2;

        public TestData(int n1, int n2) {
            num1 = Integer.valueOf(n1);
            num2 = Integer.valueOf(n2);
        }

        public Integer getNum1() {
            return num1;
        }

        public Integer getNum2() {
            return num2;
        }
    }
}
