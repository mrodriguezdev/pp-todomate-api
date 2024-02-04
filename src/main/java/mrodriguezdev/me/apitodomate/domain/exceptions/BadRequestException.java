package mrodriguezdev.me.apitodomate.domain.exceptions;

public class BadRequestException extends CustomException {
    public BadRequestException() {
        super("Bad Request", new ResponseWS<>("Bad Request", 400));
    }

    public BadRequestException(String message) {
        super(message, new ResponseWS<>(message, 400));
    }

    public BadRequestException(ResponseWS<?> response) {
        super(response);
    }
}