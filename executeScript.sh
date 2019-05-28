#!/bin/bash

echo SCRIPT STARTING
pwd

whoami

java -jar /PixelsFreshStart/target/PixelsFreshStart-0.1.0.jar --port=8081 & 

MyPID=$!                        # You sign it's PID
echo $MyPID                     # You print to terminal

echo "echo $MyPID" > stopScript.sh
