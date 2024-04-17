package exception;

public class InvalidAnimalException extends RuntimeException {
    public InvalidAnimalException(String errorMessage) {
        super(errorMessage);
    }
}
