#include <iostream>
#include <thread>
#include <chrono>
#include "kissnet.h"

// Defaults
#define DEFAULT_IP "10.40.14.11"
#define DEFAULT_PORT 5800

using namespace std::chrono_literals;
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
    private:
        kn::udp_socket socket;
    public:
        PixelentClient(const std::string ip, const uint16_t port) : socket{kn::endpoint(ip, port)}  {
        }

        PixelentClient() : PixelentClient(DEFAULT_IP, DEFAULT_PORT) {
        }

        PixelentClient(const std::string ip) : PixelentClient(ip, DEFAULT_PORT) {
        }

        PixelentClient(const uint16_t port) : PixelentClient(DEFAULT_IP, port) {
        }

};