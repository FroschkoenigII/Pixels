#!/bin/bash

echo SCRIPT STARTING

BUILD_ID=dontKillMe

java -Dserver.port=8081 -jar PixelsFreshStart/target/PixelsFreshStart-0.1.0.jar &

sleep 5
