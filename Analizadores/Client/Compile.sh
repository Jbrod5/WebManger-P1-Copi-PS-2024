echo "Compilacion de JFlex - Client (Queries)"
java -jar /home/jbravo/Apps/jflex/jflex-1.9.1/lib/jflex-full-1.9.1.jar -d ../../WebManager_Client/src/main/java/com/jbrod/webmanager_client/app/stats/ ClientQueries.flex

echo " "
echo " "
echo " "
echo " "
echo " "
echo " "
echo " "
echo " "
echo " "
echo " "
echo " "
echo " "
echo "Compilacion de cup"

java -jar /home/jbravo/Apps/cup/cup-20160615/java-cup-11b.jar -parser QueriesParser ClientQueries.cup
mv QueriesParser.java ../../WebManager_Client/src/main/java/com/jbrod/webmanager_client/app/stats/
mv sym.java ../../WebManager_Client/src/main/java/com/jbrod/webmanager_client/app/stats/



mvn install:install-file \
   -Dfile=/home/jbravo/Apps/cup/cup-20160615/java-cup-11b.jar \
   -DgroupId=com.cup \
   -DartifactId=cup \
   -Dversion=0.11 \
   -Dpackaging=jar \
   -DgeneratePom=true