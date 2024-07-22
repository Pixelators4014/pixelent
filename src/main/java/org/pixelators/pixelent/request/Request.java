package org.pixelators.pixelent.request;

import org.pixelators.pixelent.PixelentClientConfig;

import java.nio.ByteBuffer;

public interface Request {
    ByteBuffer getBytes(PixelentClientConfig config);
}
