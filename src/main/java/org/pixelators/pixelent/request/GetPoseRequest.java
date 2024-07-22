package org.pixelators.pixelent.request;

import org.pixelators.pixelent.PixelentClientConfig;

import java.nio.ByteBuffer;

public class GetPoseRequest implements Request {
    public GetPoseRequest() {}

    @Override
    public ByteBuffer getBytes(PixelentClientConfig config) {
        ByteBuffer buffer = ByteBuffer.allocate(28);
        // Version (2 bytes)
        buffer.putShort(config.CLIENT_VERSION);
        // Command (1 byte)
        buffer.put((byte) 0);
        return buffer;
    }
}
