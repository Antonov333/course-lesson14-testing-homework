package pro.sky.course2lesson14testinghomework;

public class DivByZeroException extends IllegalArgumentException {
    public DivByZeroException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "DivByZeroException{}";
    }
}
