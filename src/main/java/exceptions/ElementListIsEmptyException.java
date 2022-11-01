package exceptions;

public class ElementListIsEmptyException extends Exception {

    public ElementListIsEmptyException() {
        super("Element list has size = 0");
    }
}
