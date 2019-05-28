#!/bin/bash

echo SCRIPT STARTING
pwd

whoami
java -Dserver.port=8081 -jar PixelsFreshStart/target/PixelsFreshStart-0.1.0.jar
