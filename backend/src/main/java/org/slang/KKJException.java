package org.slang;

public class KKJException  extends RuntimeException {
    public KKJException(String message) {
        super(message);
    }

    public KKJException(String message, Throwable cause) {
        super(message, cause);
    }

    public KKJException(Throwable cause) {
        super(cause);
    }
}
