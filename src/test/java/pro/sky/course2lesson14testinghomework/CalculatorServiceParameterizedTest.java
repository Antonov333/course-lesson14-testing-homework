package pro.sky.course2lesson14testinghomework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @DisplayName("Parameterized test for plus(num1, num2) method")
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15})
    public void plusTestX5(int int1) {
        Integer num1 = Integer.valueOf(int1);
        Integer num2 = 5;
        Integer sum = num1 + num2;
        String expected = "<b>Plus</b><br><br>" + num1 + " + " + num2 + " = " + sum.toString();
        String actual = calculatorService.plus(num1, num2);
        assertEquals(expected, actual);
    }

    @DisplayName("Parameterized test for plus(num1, num2) method")
    @ParameterizedTest(name = "{index} => num1={0}, num2={1}")
    @MethodSource("numsProvider")
    public void plusTestWithStream(Integer num1, Integer num2) {
        Integer sum = num1 + num2;
        String expected = "<b>Plus</b><br><br>" + num1.toString() + " + " + num2.toString() + " = " +
                sum.toString();
        assertEquals(expected, calculatorService.plus(num1, num2));

    }

    private static Stream<Arguments> numsProvider() {
        Random r = new Random();
        return Stream.of(
                Arguments.of(r.nextInt(1, 1000), r.nextInt(1, 1000)),
                Arguments.of(r.nextInt(1, 1000), r.nextInt(1, 1000)),
                Arguments.of(r.nextInt(1, 1000), r.nextInt(1, 1000)));
    }

    @DisplayName("Parameterized test for minus(num1, num2) method")
    @ParameterizedTest(name = "{index} => num1={0}, num2={1}")
    @MethodSource("numsProvider")
    public void minusParameterizedTest(Integer num1, Integer num2) {
        Integer dif = num1 - num2;
        String expected = "<b>Minus</b><br><br>" + num1 + " - " + num2 + " = " +
                dif;
        assertEquals(expected, calculatorService.minus(num1, num2));
    }

    @DisplayName("Parameterized test for multiply(num1, num2) method")
    @ParameterizedTest(name = "{index} => num1={0}, num2={1}")
    @MethodSource("numsProvider")
    public void multiplyParameterizedTest(Integer num1, Integer num2) {
        Integer product = num1 * num2;
        String expected = "<b>Multiply</b><br><br>" + num1 + " * " + num2 + " = " + product;
    }

    @DisplayName("Parameterized test for divide(num1, num2) method")
    @ParameterizedTest(name = "{index} => num1={0}, num2={1}")
    @MethodSource("numsProvider")
    public void divideParameterizedTest(Integer num1, Integer num2) {
        Integer quotient = num1 / num2;
        String expected = "<b>Divide</b><br><br>" + num1 + " / " + num2 + " = " + quotient;
    }

}
