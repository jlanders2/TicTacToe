package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeView extends JPanel implements ActionListener{

    private TicTacToeModel model;
	private JButton[][] board;
	private JLabel endResult;
	TicTacToeModel.Result result;
    
    /* CONSTRUCTOR */
    public TicTacToeView(TicTacToeModel model) {
        this.model = model;
		result = TicTacToeModel.Result.NONE;
		board = new JButton[model.getWidth()][model.getWidth()];
		setLayout(new GridLayout(4,3));
		for(int i = 0; i < model.getWidth(); i++){
			for(int j = 0; j < model.getWidth(); j ++){
				board[i][j] = new JButton();
				board[i][j].addActionListener(this);
				board[i][j].setName("Square" + Integer.toString(i) + Integer.toString(j));
				board[i][j].setText("-");
				board[i][j].setPreferredSize(new Dimension(64, 64));
				add(board[i][j]);
			}
		}
		endResult = new JLabel();
		endResult.setName("ResultLabel");
		add(endResult);
    }

    public void showNextMovePrompt() {
        /* Display a prompt for the player's next move (see examples) */
		if(model.isXTurn()){
			endResult.setText("Player 1 (X) Move:");
		}
		if(!model.isXTurn()){
			endResult.setText("Player 2 (O) Move:");
		}
    }

    public void showInputError() {
        /* Display an error if input is invalid (see examples) */
		endResult.setText("ERROR Input invalid!");
    }

    public void showResult(String r) {
        /* Display final winner */
		endResult.setText(r);
		for(int i = 0; i < model.getWidth(); i++){
			for(int j = 0; j < model.getWidth(); j ++){
				board[i][j].setEnabled(false);
			}
		}
		
    }
	
	public void actionPerformed(ActionEvent e){
		for(int i = 0; i < model.getWidth(); i++){
			for(int j = 0; j < model.getWidth(); j ++){
				if(e.getSource().equals(board[i][j])){
					if(model.isXTurn() == true){
						board[i][j].setText("X");
						model.makeMark(i,j);
						showNextMovePrompt();
						if(model.getResult() != TicTacToeModel.Result.NONE){
							showResult(model.getResult().toString());
						}
						
					}
					else{
						board[i][j].setText("O");
						model.makeMark(i,j);
						showNextMovePrompt();
						if(model.getResult() != TicTacToeModel.Result.NONE){
							showResult(model.getResult().toString());
						}
					}
				}
			}
		}
	}
}