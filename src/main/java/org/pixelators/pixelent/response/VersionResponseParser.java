package org.pixelators.pixelent.response;

import org.pixelators.pixelent.PixelentClientConfig;
import org.pixelators.pixelent.PixelentException;

import java.nio.ByteBuffer;

public class VersionResponseParser implements ResponseParser<VersionResponse> {
    public VersionResponseParser() {
    }
    @Override
    public VersionResponse parse(PixelentClientConfig config, ByteBuffer buffer) throws PixelentException {
        byte status = buffer.get();
        if (status != (byte) 2) {
            short errorCode = buffer.getShort();
            byte[] messageBytes = new byte[buffer.remaining()];
            buffer.get(messageBytes);
            String message = new String(messageBytes);
            throw new PixelentException(errorCode, message);
        }
        short version = buffer.getShort();
        return new VersionResponse(version);
    }
}
