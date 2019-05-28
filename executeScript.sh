#!/bin/bash

echo SCRIPT STARTING
pwd

whoami
java -Dserver.port=8081 -jar PixelsFreshStart/target/PixelsFreshStart-0.1.0.jar &

MyPID=$!                        # You sign it's PID
echo $MyPID                     # You print to terminal

disown

echo "kill $MyPID" > stopScript.sh
