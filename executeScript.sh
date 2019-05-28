#!/bin/bash

echo Killing old Run 

pid=`ps aux | grep PixelsFreshStart | awk '{print $2}'`
kill -9 $pid

echo Starting new Run

BUILD_ID=dontKillMe

java -Dserver.port=8081 -jar PixelsFreshStart/target/PixelsFreshStart-0.1.0.jar &

sleep 5
