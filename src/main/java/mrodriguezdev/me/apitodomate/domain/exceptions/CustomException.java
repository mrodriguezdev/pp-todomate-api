package mrodriguezdev.me.apitodomate.domain.exceptions;

public abstract class CustomException extends RuntimeException{
    private final ResponseWS<?> response;

    public CustomException(ResponseWS<?> response) {
        this.response = response;
    }

    public CustomException(String message, Throwable cause, ResponseWS<?> response) {
        super(message, cause);
        this.response = response;
    }

    public CustomException(String message, ResponseWS<?> response) {
        super(message);
        this.response = response;
    }

    public ResponseWS<?> getResponse() {
        return response;
    }
}