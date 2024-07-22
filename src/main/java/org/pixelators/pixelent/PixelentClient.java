package org.pixelators.pixelent;

import org.pixelators.pixelent.object.Pose;
import org.pixelators.pixelent.request.GetPoseRequest;
import org.pixelators.pixelent.request.PingRequest;
import org.pixelators.pixelent.request.Request;
import org.pixelators.pixelent.request.SetPoseRequest;
import org.pixelators.pixelent.response.*;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;

public class PixelentClient {

    public static final int DEFAULT_PORT = 5800;
    public static final String DEFAULT_IP = "10.0.0.1";

    private DatagramSocket socket;
    private PixelentClientConfig config;

    public PixelentClient(PixelentClientConfig config) {
        try {
            socket = new DatagramSocket(4555);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifyVersion() throws IOException, PixelentException {
        VersionResponse version = send(new PingRequest(), new VersionResponseParser());
        return version.version() <= config.HIGHEST_SUPPORTED_VERSION && version.version() >= config.LOWEST_SUPPORTED_VERSION;
    }

    public <T> T send(Request request, ResponseParser<T> responseParser) throws IOException, PixelentException {
        byte[] bytes = request.getBytes(config).array();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, config.ip, config.port);
        socket.send(packet);
        byte[] buffer = new byte[512];
        DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(receivedPacket);
        return responseParser.parse(config, ByteBuffer.wrap(receivedPacket.getData()));
    }

    public Pose getPose() throws IOException, PixelentException {
        GetPoseResponse response = send(new GetPoseRequest(), new GetPoseResponseParser());
        return response.pose();
    }

    public void setPose(Pose pose) throws IOException, PixelentException {
        send(new SetPoseRequest(pose), new SuccessResponseParser());
    }

    public void close() {
        socket.close();
    }
}
