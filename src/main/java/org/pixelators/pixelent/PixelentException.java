package org.pixelators.pixelent;

public class PixelentException extends Exception {
    public short code;

    public PixelentException(short code, String message) {
        super(message);
        this.code = code;
    }

    public PixelentException(short code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
