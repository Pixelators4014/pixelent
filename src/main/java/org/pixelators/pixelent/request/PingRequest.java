package org.pixelators.pixelent.request;

import org.pixelators.pixelent.PixelentClientConfig;

import java.nio.ByteBuffer;

public class PingRequest implements Request {
    public PingRequest() {}

    @Override
    public ByteBuffer getBytes(PixelentClientConfig config) {
        ByteBuffer buffer = ByteBuffer.allocate(28);
        // Version (2 bytes)
        buffer.putShort(config.CLIENT_VERSION);
        // Command (1 byte)
        buffer.put((byte) 255);
        return buffer;
    }
}
