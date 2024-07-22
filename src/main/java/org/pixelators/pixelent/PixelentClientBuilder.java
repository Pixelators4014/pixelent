package org.pixelators.pixelent;

import java.net.InetAddress;

public class PixelentClientBuilder {
    private InetAddress address;
    private int port;

    public PixelentClientBuilder() {
        this.address = null;
        this.port = 0;
    }

    public PixelentClientBuilder address(InetAddress address) {
        this.address = address;
        return this;
    }

    public PixelentClientBuilder port(int port) {
        this.port = port;
        return this;
    }

    public PixelentClient build() {
        return new PixelentClient(new PixelentClientConfig(address, port));
    }
}
