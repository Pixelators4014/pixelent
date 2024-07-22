package org.pixelators.pixelent;

import java.net.InetAddress;

public class PixelentClientConfig {
    public final short LOWEST_SUPPORTED_VERSION = 1;
    public final short HIGHEST_SUPPORTED_VERSION = 1;

    public InetAddress ip;
    public int port;

    public PixelentClientConfig(InetAddress address, int port) {
        this.ip = address;
        this.port = port;
    }
}
