package pro.sky.course2lesson14testinghomework;

public class ResultToString {
    private static OpNameAndSign[] operations = {new OpNameAndSign("Plus", " + "),
            new OpNameAndSign("Minus", " - "),
            new OpNameAndSign("Multiply", " * "),
            new OpNameAndSign("Divide", " / ")};

    public static String maker(int opNumber, Integer num1, Integer num2, Integer opResult) {


        String result = "<b>" + operations[opNumber].getName() + "</b><br><br>"
                + num1 + operations[opNumber].getSign() + num2 + " = " + opResult;

        return result;
    }
}

class OpNameAndSign {
    final String name;
    final String sign;

    public OpNameAndSign(String name, String sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }
}
