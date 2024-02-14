package alessandro.agheben.u5w2d3.exceptions;

public class NoFoundException extends RuntimeException {

    public NoFoundException(long id) {
        super("item with " + id + " not found.");
    }

}
