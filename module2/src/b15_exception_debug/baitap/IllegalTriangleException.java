package b15_exception_debug.baitap;

public class IllegalTriangleException extends Throwable {
    IllegalTriangleException() {
        super("Exception: Invalid Triangle Side Numbers");
    }
}
