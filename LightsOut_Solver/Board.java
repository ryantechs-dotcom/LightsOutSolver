package p2;


import java.util.Random;

public class Board implements Comparable<Board> {
	private boolean[][] puzzle = new boolean[5][5];
	public boolean[][] getPuzzle()  {return puzzle;}
	private int hash = 0;
	/**
	 * Construct a puzzle board by beginning with a completely empty board and then
	 * making a number of non-repeating moves.
	 * 
	 * @param moveCount the number of moves to make when generating the board.
	 */
	
	
	
	public Board(int moveCount) {
		Random random = new Random();
		int[][] moves_made = new int[moveCount][2];
		boolean[][] b = {
				{false, false, false, false, false},
				{false, false, false, false, false},
				{false, false, false, false, false},
				{false, false, false, false, false},
				{false, false, false, false, false}
		};
		int row = 0; 
        int col = 0 ;
		Board x = new Board(b);
		for (int i = 0; i < moveCount; i++) {
            
            boolean moveFound = false;
            while (!moveFound) {
                row = random.nextInt(5); 
                col = random.nextInt(5); 
                moveFound = !isMoveMade(moves_made, i, row, col); 
            }
           
            moves_made[i][0] = row;
            moves_made[i][1] = col;
            
            x.move(row, col);
        }
		this.puzzle = x.puzzle;
    }

	
	
	private boolean isMoveMade(int[][] movesMade, int count, int row, int col) {
        for (int i = 0; i < count; i++) {
            if (movesMade[i][0] == row && movesMade[i][1] == col) {
                return true;
            }
        }
        return false;
    }

	/**
	 * Construct a puzzle board using a 2D array of booleans to indicate which cells
	 * are filled and which are empty.
	 * 
	 * @param b a 5x5 boolean array where true cells indicate that the corresponding
	 *          position in the puzzle board starts filled and false indicates the
	 *          position starts cleared.
	 */
	public Board(boolean[][] b) {
//		throw new RuntimeException("Not implemented");
		for(int i = 0; i<5; i++ ) {
			for(int j=0; j<b[i].length; j++) {
				puzzle[i][j] = b[i][j];
				}
			}
	}

	/**
	 * Makes a move on the board at position (row, col) on the board. This flips the
	 * state of the cell at that position from filled to clear or from clear to
	 * filled. It also flips the state of the cell above, below, to the left, and to
	 * the right, (if they exist).
	 * 
	 * @param row the row of the cell where the move is to be made
	 * @param col the column of the cell where the move is to be made
	 * 
	 * @return {@code true} if the row and col were valid (between 0 and 4) and
	 *         {@code false} otherwise.
	 */
	public boolean move(int row, int col) {
//		throw new RuntimeException("Not implemented");
		if(row > 4 || row < 0) {
			return false;
		}
		if(col > 4 || col < 0) {
			return false;
		}
		puzzle[row][col] = !(puzzle[row][col]);
		if(row < 4) {
			puzzle[row+1][col] = !(puzzle[row+1][col]) ;
		}
		if(row > 0) {
			puzzle[row-1][col] = !(puzzle[row-1][col]);
		}
		if(col < 4) {
			puzzle[row][col+1] = !(puzzle[row][col+1]) ;
		}
		if(col > 0) {
			puzzle[row][col-1] = !(puzzle[row][col-1]);
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		boolean[][] other_puzzle = other.puzzle;
		for(int i = 0; i<5; i++ ) {
			for(int j=0; j<other_puzzle[i].length; j++) {
				if(puzzle[i][j] != other_puzzle[i][j]) {
					return false;
					}
				}
			}
		return true;
		
	}

	/**
	 * Determines if the puzzle is solved.
	 * 
	 * @return the {@code true} if the board is clear and {@code false} otherwise.
	 */
	public boolean isSolved() {
		Board clean = new Board(0);
		if(this.equals(clean)){
			return true;
		}
		return false;
	}

	/**
	 * Returns {@code true} if a given cell of the board is filled and {@code false}
	 * otherwise.
	 * 
	 * @param row the row of the cell being querried
	 * @param col the column of the cell being querried
	 * @return {@code true} if the cell is filled and {@code false} otherwise.
	 */
	public boolean isFilled(int row, int col) {
		return puzzle[row][col];
	}
	
	
	@Override
	public int hashCode() {
		
		if(hash == 0) {
			for(int i = 0; i<5; i++) {
				for(int j = 0; j<5; j++) {
					hash = (hash << 1) ^ (puzzle[i][j] ? 1 : 0);
				}
			}
		}
		return hash;
	}
	
	 @Override
	  public int compareTo(Board other) {
	    for (int i = 0; i < 5; i++) {
	      for (int j = 0; j < 5; j++) {
	        if (this.puzzle[i][j] != other.puzzle[i][j]) {
	          return this.puzzle[i][j] ? 1 : -1; // Compare boolean values directly
	        }
	      }
	    }
	    return 0; // All elements are equal
	  }
	
	
		
	
	
	public String toString() {
        String result = "";

        // Display column numbers on top
        result += "   0 1 2 3 4\n";
        result += "  +-+-+-+-+-+\n";

        // Display rows and board state
        for (int i = 0; i < 5; i++) {
            result += i + " ";
            for (int j = 0; j < 5; j++) {
                if (puzzle[i][j]) {
                    result += "|*";
                } else {
                    result += "| ";
                }
            }
            result += "|\n";
            // Add line between rows
            if (i < 4) {
                result += "  +-+-+-+-+-+\n";
            }
        }
        
        result += "  +-+-+-+-+-+";

        return result;
    }
}
