package pro.sky.course2lesson14testinghomework;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String hint() {
        System.out.println("<b>Hi! <br><br>Welcome to simple <a href=\"http://localhost:8080/calculator/\">Calculator</a>!");
        return
                "<b>Hi! <br><br>Welcome to simple <a href=\"http://localhost:8080/calculator/\">Calculator</a>!";
    }

    public String welcome() { // covered by test
        String string = "<b>Welcome to simple calculator!</b><br><br>" +
                "<a href=\"http://localhost:8080/calculator/plus/?num1=5&num2=5\"> Plus </a> | " +
                "<a href=\"http://localhost:8080/calculator/minus/?num1=5&num2=5\"> Minus </a> | " +
                "<a href=\"http://localhost:8080/calculator/multiply/?num1=5&num2=5\"> Multiply </a> | " +
                "<a href=\"http://localhost:8080/calculator/divide/?num1=5&num2=5\"> Divide </a>";
        return string;
    }

    public String plus(Integer num1, Integer num2) { // covered by test
        int code = checkParamsCode(num1, num2);
        String result = "<b>Plus</b><br><br>" + checkParamsString(code);
        if (code == 0) {
            result = result.concat(
                    num1 + " + " + num2 + " = " + (num1 + num2));
        }
        ;
        return result;
    }


    public String divide(Integer num1, Integer num2) { // covered by tests
        int code = checkParamsCode(num1, num2);
        String result = "<b>Division</b><br><br>" + checkParamsString(code);
        if (code == 0 && num2.intValue() == 0) {
            code = code + 1000;
//            result = result.concat(" -- ERROR: division by zero");
            throw new DivByZeroException("DivByZeroException");
        }
        if (code == 0) {
            result = result.concat(num1 + " / " + num2 + " = "
                    + num1 / num2);
        }
        return result;
    }

    public String minus(Integer num1, Integer num2) { // covered by test
        int code = checkParamsCode(num1, num2);
        String result = "<b>Minus</b><br><br>" + checkParamsString(code);
        if (code == 0) {
            result = result.concat(num1 + " - " + num2 + " = " + (num1 - num2));
        }
        return result;
    }

    public String multiply(Integer num1, Integer num2) { // covered by test
        int code = checkParamsCode(num1, num2);
        String result = "<b>Multiply</b><br><br>" + checkParamsString(code);
        if (code == 0) {
            result = result.concat(
                    num1 + " * " + num2 + " = " + num1 * num2);
        }
        return result;
    }

    private int checkParamsCode(Object p1, Object p2) {
        int c = 0;
        if (p1 == null) {
            c = 10;
        }
        if (p2 == null) {
            c += 100;
        }
        return c;
        // 0 - both params are OK
        //10 - first param is missing
        //100 - second param is missing
        //110 - both params are missing
    }

    private String checkParamsString(int code) {
        switch (code) {
            case 0:
                return "";
            case 10:
                return "ERROR: first parameter is missing";
            case 100:
                return "ERROR: second parameter is missing";
            case 110:
                return "ERROR: first and second parameters are missing";
        }
        return "checkParamsString went wrong";
    }

}
