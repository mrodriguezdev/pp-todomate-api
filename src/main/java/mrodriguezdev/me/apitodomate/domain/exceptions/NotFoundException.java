package mrodriguezdev.me.apitodomate.domain.exceptions;

public class NotFoundException extends CustomException{
    public NotFoundException() {
        super("Not Found", new ResponseWS<>("Not Found", 404));
    }

    public NotFoundException(String message) {
        super(message, new ResponseWS<>(message, 404));
    }

    public NotFoundException(ResponseWS<?> response) {
        super(response);
    }
}
