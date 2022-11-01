package exceptions;

public class DriverNotSupportedException extends Exception {
    public DriverNotSupportedException(String browserName) {
        super(String.format("Browser %s not supported", browserName));
    }
}
