find . -name "*.java" > sources.txt
tompath="/Library/Tomcat"
javac -encoding ISO-8859-1 -d WEB-INF/classes/ -cp $tompath/lib/servlet-api.jar @sources.txt
jar cf tp4.war .
cp tp4.war $tompath/webapps/
$tompath/bin/shutdown.sh
$tompath/bin/startup.sh