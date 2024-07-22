#include "PixelentClient.hpp"

PixelentClient::PixelentClient(std::string server_ip, uint16_t server_port) {
    this->server_ip = server_ip;
    this->server_port = server_port;
    this->socket = kn::udp_socket(kn::endpoint(server_ip, server_port));
}

PixelentClient::PixelentClient() {
    PixelentClient(DEFAULT_SERVER_TARGET_IP, DEFAULT_SERVER_TARGET_PORT);
}

Pose PixelentClient::getPose() {
    send_buffer[0] = std::byte{0};
    socket.send(send_buffer);
    if (socket.bytes_available() >= 25) {
        // std::cout << "I see " << socket.bytes_available() << " avaliable bytes"
        //           << std::endl;
        const auto [data_size, status_code] = socket.recv(receive_buffer);
        // for (std::byte byte : static_buffer) {
        //   std::cout << static_cast<int>(byte) << ", ";
        // }
        // std::cout << std::endl;
        // if (static_buffer[0] != std::byte{255}) {
        //   std::cout << "Invalid response" << std::endl;
        //   return;
        // }
        Pose pose;
        float x;
        float y;
        float z;
        float roll;
        float pitch;
        float yaw;
        memcpy(&x, &receive_buffer[1], sizeof(float));
        memcpy(&y, &receive_buffer[5], sizeof(float));
        memcpy(&z, &receive_buffer[9], sizeof(float));
        memcpy(&roll, &receive_buffer[13], sizeof(float));
        memcpy(&pitch, &receive_buffer[17], sizeof(float));
        memcpy(&yaw, &receive_buffer[21], sizeof(float));
        pose.x = x;
        pose.y = y;
        pose.z = z;
        pose.roll = roll;
        pose.pitch = pitch;
        pose.yaw = yaw;
        return pose;
    }
    return Pose();
}
