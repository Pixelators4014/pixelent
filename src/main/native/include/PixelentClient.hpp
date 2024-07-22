#pragma once

#include "kissnet.hpp"
#define DEFAULT_SERVER_TARGET_IP "10.40.14.11"
#define DEFAULT_SERVER_TARGET_PORT 5800
#define BUFFER_SIZE 512

namespace kn = kissnet;

struct Pose {
    float x;
    float y;
    float z;
    float roll;
    float pitch;
    float yaw;
};

class PixelentClient {
//    private:
//        kn::udp_socket socket;
//        string server_ip;
//        uint16_t server_port;
//        kn::buffer<1> send_buffer;
//        kn::buffer<BUFFER_SIZE> receive_buffer;
//    public:
//        PixelentClient();
//        PixelentClient(string server_ip, uint16_t server_port);
//        Pose getPose();
};