package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    public enum Mark {
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        } 
    };
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    public enum Result {
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    public TicTacToeModel() {
        /* No arguments (call main constructor; use default size) */
        this(DEFAULT_WIDTH);
    }
    
    /* CONSTRUCTOR */
    public TicTacToeModel(int width) {
        /* Initialize width; X goes first */
        this.width = width;
        xTurn = true;
        /* Create grid (width x width) as a 2D Mark array */
        grid = new Mark[width][width];
        /* Initialize grid by filling every square with empty marks */
        for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				grid[i][j] = Mark.EMPTY;
			}
		}
    }
	
    public boolean makeMark(int row, int col) {
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
		   boolean markMade = false;
		//Makes a mark for X
        if((isValidSquare(row,col) && !isSquareMarked(row,col)) && xTurn == true){
			grid[row][col] = Mark.X;
			xTurn = false;
			markMade = true;
		}
		//Makes a mark for O
		else if((isValidSquare(row,col) && !isSquareMarked(row,col)) && xTurn == false){
			grid[row][col] = Mark.O;
			xTurn = true;
			markMade = true;
		}
		return markMade;
    }
	
    private boolean isValidSquare(int row, int col) {
        /* Return true if specified location is within grid bounds */
        if(0 <= row && row < getWidth()){
			if(0 <= col && col < getWidth()){return true;}
		}
		return false;
    }
	
    private boolean isSquareMarked(int row, int col) {
        /* Return true if square at specified location is marked */
		if((getMark(row,col)) == Mark.X || (getMark(row,col) == Mark.O)){return true;}
        else{return false;}  
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        if(isValidSquare(row, col)){return grid[row][col];}
        else{return null;}
    }
	
    public Result getResult() {
		/* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
		if(isMarkWin(Mark.X) == true){return Result.X;}
		else if(isMarkWin(Mark.O) == true){return Result.O;}
		else if(isTie() == true){return Result.TIE;}
		else{return Result.NONE;} /* remove this line! */
    }
	
    private boolean isMarkWin(Mark mark) {
        /* Check the squares of the board to see if the specified mark is the
           winner */
        //check row
		for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				if(getMark(i,j) != mark){break;}
				if(j == width-1){return true;}
			}
		}
		//check col
		for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				if(getMark(j,i) != mark){break;}
				if(j == width-1){return true;}
			}
		}
		//check right diag
		for(int i = 0; i < width; i++){
			if(getMark(i,i) != mark){break;}
			if(i == width-1){return true;}
		}
		//check left diag
		for(int i = 0; i < width; i++){
			if(getMark(i,(width-1)-i) != mark){break;}
			if(i == width-1){return true;}
		}
		return false;
    }
	
    private boolean isTie() {
        /* Check the squares of the board to see if the game is a tie */
		boolean isTied = false;
		int gridCounter = 0;
		for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				if(getMark(i,j) != Mark.EMPTY){
					gridCounter++;
				}
			}
		}
		if(gridCounter == width*width){
			isTied = true;
		}
        return isTied;
    }

    public boolean isGameover(){
        /* Return true if the game is over */
        return Result.NONE != getResult();
    }

    public boolean isXTurn(){
        /* Getter for xTurn */
		if(xTurn == true){
			//System.out.println("\nPlayer 1 (X) Move:");
		}
        return xTurn;
    }
	public void setXTurn(boolean tof){
		xTurn = tof;
	}

    public int getWidth(){
        /* Getter for width */
        return width;
    }
    
}