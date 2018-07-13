import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe{

    private static final int DEFAULT_WIDTH = 3;

    public static void main(String[] args) {

        int width = DEFAULT_WIDTH;

        if(args.length >= 1) {
            
            try {
                width = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e) {}
            
        }
		
		JFrame frame = new JFrame("Tic-Tac-Toe");
		frame.setName("Tic-Tac-Toe");
		frame.setTitle("Tic-Tac-Toe");
        TicTacToeModel model = new TicTacToeModel(width);
        TicTacToeView view = new TicTacToeView(model);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(view);
		frame.setSize(400,400);
		frame.setVisible(true);
		view.showNextMovePrompt();
		
    }
}