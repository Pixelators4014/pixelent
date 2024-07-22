package org.pixelators.pixelent.response;

import org.pixelators.pixelent.PixelentClientConfig;
import org.pixelators.pixelent.PixelentException;

import java.nio.ByteBuffer;

public class SuccessResponseParser implements ResponseParser<SuccessResponse> {
    public SuccessResponseParser() {
    }
    @Override
    public SuccessResponse parse(PixelentClientConfig config, ByteBuffer buffer) throws PixelentException {
        byte status = buffer.get();
        if (status != (byte) 0) {
            short errorCode = buffer.getShort();
            byte[] messageBytes = new byte[buffer.remaining()];
            buffer.get(messageBytes);
            String message = new String(messageBytes);
            throw new PixelentException(errorCode, message);
        }
        return new SuccessResponse();
    }
}
