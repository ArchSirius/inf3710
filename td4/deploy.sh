find . -name "*.java" > sources.txt
tompath="/Library/Tomcat"
javac -d WEB-INF/classes/ -cp $tompath/lib/servlet-api.jar @sources.txt
jar cf tp4.war .
cp tp4.war $tompath/webapps/
$tompath/bin/shutdown.sh
$tompath/bin/startup.sh