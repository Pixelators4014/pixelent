package org.pixelators.pixelent.request;

import org.pixelators.pixelent.PixelentClientConfig;
import org.pixelators.pixelent.object.Pose;

import java.nio.ByteBuffer;

public class SetPoseRequest implements Request {
    Pose pose;

    public SetPoseRequest(Pose pose) {
        this.pose = pose;
    }

    @Override
    public ByteBuffer getBytes(PixelentClientConfig config) {
        ByteBuffer buffer = ByteBuffer.allocate(28);
        // Version (2 bytes)
        buffer.putShort(config.PROTOCOL_VERSION);
        // Command (1 byte)
        buffer.put((byte) 2);
        // Pose (24 bytes)
        buffer.putFloat(pose.x());
        buffer.putFloat(pose.y());
        buffer.putFloat(pose.z());
        buffer.putFloat(pose.roll());
        buffer.putFloat(pose.pitch());
        buffer.putFloat(pose.yaw());
        return buffer;
    }
}
