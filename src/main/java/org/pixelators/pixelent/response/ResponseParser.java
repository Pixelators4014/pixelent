package org.pixelators.pixelent.response;

import org.pixelators.pixelent.PixelentClientConfig;
import org.pixelators.pixelent.PixelentException;

import java.nio.ByteBuffer;

public interface ResponseParser<T> {
    public T parse(PixelentClientConfig config, ByteBuffer buffer) throws PixelentException;
}
