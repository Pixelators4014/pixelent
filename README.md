# Pixelent

## Layout

The build is split into 2 libraries. A java library is built. This has access to all of wpilib.

A native C++ library is built. This has access to all of wpilib. This should implement the standard wpilib interfaces.

## Building and editing

This uses gradle, and uses the same base setup as a standard GradleRIO robot project. This means you build with `./gradlew build`, and can install the native toolchain with `./gradlew installRoboRIOToolchain`. If you open this project in VS Code with the wpilib extension installed, you will get intellisense set up for both C++ and Java.

By default, this template builds against the latest WPILib development build. To build against the last WPILib tagged release, build with `./gradlew build -PreleaseMode`.
