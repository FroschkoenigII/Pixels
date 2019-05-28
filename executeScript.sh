#!/bin/bash



echo SCRIPT STARTING
pwd

whoami


java -Dserver.port=8081 -jar PixelsFreshStart/target/PixelsFreshStart-0.1.0.jar &

pid=`ps aux | grep PixelsFreshStart | awk '{print $2}'`

disown pid
