package exceptions;

public class DriverNotExistsException extends Exception{
    public DriverNotExistsException(String browserName) {
        super(String.format("Browser %s not exists", browserName));
    }
}
