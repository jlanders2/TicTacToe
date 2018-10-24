cd tictactoe
javac TicTacToe.java
jar cmvf manifest.mf ../TicTacToe.jar ./*.java ./*.class
cd ..
java -jar TicTacToe.jar
pause
