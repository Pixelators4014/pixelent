package org.pixelators.pixelent.response;

import org.pixelators.pixelent.PixelentClientConfig;
import org.pixelators.pixelent.PixelentException;
import org.pixelators.pixelent.object.Pose;

import java.nio.ByteBuffer;

public class GetPoseResponseParser implements ResponseParser<GetPoseResponse> {
    public GetPoseResponseParser() {
    }
    @Override
    public GetPoseResponse parse(PixelentClientConfig config, ByteBuffer buffer) throws PixelentException {
        byte status = buffer.get();
        if (status != (byte) 255) {
            short errorCode = buffer.getShort();
            byte[] messageBytes = new byte[buffer.remaining()];
            buffer.get(messageBytes);
            String message = new String(messageBytes);
            throw new PixelentException(errorCode, message);
        }
        float x = buffer.getFloat();
        float y = buffer.getFloat();
        float z = buffer.getFloat();
        float roll = buffer.getFloat();
        float pitch = buffer.getFloat();
        float yaw = buffer.getFloat();
        return new GetPoseResponse(new Pose(x, y, z, roll, pitch, yaw));
    }
}
