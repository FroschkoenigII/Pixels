#!/bin/bash

echo SCRIPT STARTING

pwd

whoami

BUILD_ID=dontKillMe

java -Dserver.port=8081 -jar PixelsFreshStart/target/PixelsFreshStart-0.1.0.jar &

sleep 10

ps -a