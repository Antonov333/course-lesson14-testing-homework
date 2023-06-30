package pro.sky.course2lesson14testinghomework;

public class DivByZeroException extends IllegalArgumentException {
    public DivByZeroException(String message) {
        super(message);
        System.out.println("Division by zero detected");
    }

    @Override
    public String toString() {
        return "DivByZeroException{}";
    }
}
