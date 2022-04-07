package the.best.amazonclonebackend.exception;

public class AuthException extends RuntimeException {
    public AuthException(String exMessage) {
        super(exMessage);
    }
}

