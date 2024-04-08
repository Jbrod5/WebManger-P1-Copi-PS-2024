echo "Compilacion de JFlex - Web Manager (Server)"
java -jar /home/jbravo/Apps/jflex/jflex-1.9.1/lib/jflex-full-1.9.1.jar -d ../../WebManager_Server/src/main/java/com/jbrod/webmanager_server/analyzer/ WebManager.flex

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
java -jar /home/jbravo/Apps/cup/cup-20160615/java-cup-11b.jar -parser WebParser WebManager.cup
mv WebParser.java ../../WebManager_Server/src/main/java/com/jbrod/webmanager_server/analyzer/
mv sym.java ../../WebManager_Server/src/main/java/com/jbrod/webmanager_server/analyzer/