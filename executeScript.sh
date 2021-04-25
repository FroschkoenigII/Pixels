echo Killing old Run 
pid=`ps aux | grep PixelsFreshStart | awk '{print $2}'`
echo Killing $pid
kill -9 $pid
echo Starting new Run
JENKINS_NODE_COOKIE=dontKillMe
java -jar PixelsFreshStart/target/PixelsFreshStart-0.1.0.jar &