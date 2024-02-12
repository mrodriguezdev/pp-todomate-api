package mrodriguezdev.me.apitodomate.domain.exceptions;

public class ResponseWS<T> {
    public int status;
    public T content;
    public String description;
    public String error;

    public ResponseWS() {
    }

    public ResponseWS(String description, String error, int status) {
        this.description = description;
        this.error = error;
        this.status = status;
    }

    public ResponseWS(T content, int status) {
        this.content = content;
        this.status = status;
    }

    public ResponseWS(T content, String description, String error, int status) {
        this.content = content;
        this.description = description;
        this.error = error;
        this.status = status;
    }
}
