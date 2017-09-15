package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeController {

    private TicTacToeModel model;
    private TicTacToeView view;
    private Scanner keyboard;
    
    /* CONSTRUCTOR */

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        
        /* Initialize model and view */

        this.model = model;
        this.view = view;
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);

    }

    public void controlModel() {
        
        /* Prompt player for next move using view's showNextMovePrompt() */
        
        view.showNextMovePrompt();
        
        /* Receive and validate input, which should be read at the keyboard as
           two integers, the row and the column (for example, "1 1" for the
           center square of a 3 x 3 grid).  Make mark if input is valid, or show
           error message using view's showInputError() if input is invalid. */
        
        /* INSERT YOUR CODE HERE */
		int[] choice = new int[2];
		for(int i = 0; i < choice.length; i++){
			choice[i] = keyboard.nextInt();
			System.out.println("CHOICE: " + choice[i]);
		}
		if(choice[0] > model.getWidth()-1 || choice[1] > model.getWidth()-1){
			view.showInputError();
		}
		else{
			model.makeMark(choice[0], choice[1]);
		}

        
    }

}