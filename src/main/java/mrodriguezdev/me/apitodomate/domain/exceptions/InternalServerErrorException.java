package mrodriguezdev.me.apitodomate.domain.exceptions;

public class InternalServerErrorException extends CustomException {
    public InternalServerErrorException() {
        super("Internal Server error", new ResponseWS<>("Internal Server error",500));
    }

    public InternalServerErrorException(String message) {
        super(message, new ResponseWS<>(message, 500));
    }

    public InternalServerErrorException(ResponseWS<?> response) {
        super(response);
    }
}