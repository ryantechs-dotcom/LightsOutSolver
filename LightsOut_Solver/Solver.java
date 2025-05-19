package p2;

import java.util.Arrays;


public class Solver {
	private BreadthFirstPaths3 moves = new BreadthFirstPaths3();
	private int[] answer;
	
	/**
	 * Construct a solver object.  How much work this constructor does is completely up to you.
	 * It is here in case you want to initialize some fields or do some pre-processing before
	 * being asked to solve any puzzles.  This constructor will be called once to construct
	 * your Solver object and then the solve method will be called multiple times on that
	 * Solver object.
	 * 
	 * There are correct solutions to the project that don't include any code in this constructor.
	 * However, by adding some pre-processing in this constructor, it is possible for you to speed
	 * up your solution.
	 */
	public Solver() {
		Board clean = new Board(0);
		moves.bfs(clean);
		
	}


	/**
	 * Solve a given puzzle
	 * 
	 * @param b a 5-by-5 array of booleans representing the starting configuration of the puzzle.
	 * Filled in cells have value {@code true} and empty cells have value {@code false} just like
	 * the corresponding constructor of the {@code Board} class.
	 * @return an array {@code int} describing a shortest solution to the puzzle.  The row for move
	 * i is in slot 2i, and the column for move i is in slot 2i+1.  In other words, the first two
	 * slots are the row and column of the first move (move #0), the second two slots are the row and column
	 * of the second move (move #1), and so on.  An array of size 0 should be returned if the input array 
	 * represents a board that is already completely clear, and null should be returned if there
	 * is no solution to the given input board.
	 */
	public int[] solve(boolean[][] start) {
		Board clean = new Board(0);
		Board board = new Board(start);
		int[] zero =  {};
		
		if(board.isSolved() == true) {
			return zero;
		}
		
		int[] sol = moves.solution(clean, board);
		if(sol == null) {
			return null;
		}
		
		answer = new int[sol.length];
		
		for(int i = 0; i<answer.length; i++) {
			answer[i] = sol[i];
		}
		
		
		return answer;
	}
	

	
	// The sample code from the write-up that demonstrates how you can
	// call your solve method.  I will NOT be running main.  It is here
	// in case you want to run your code on a small example.
	public static void main(String[] args) {
		int[] answerArray;
	    Solver solver = new Solver();
	    
	    boolean[][] b =
	        {
	            {true, true,  false, false, false},
	            {true, false, false, false, false},
	            {false, false, false, false, false},
	            {false, false, false, false, false},
	            {false, false, false, false, false}
	        };
	    
	    answerArray = solver.solve(b);
	    System.out.println(Arrays.toString(answerArray));
	    
//	    boolean[][] a = 
//	    	 {
//	 	            {true, true, false, false, false},
//	 	            {true, false, false, false, false},
//	 	            {false, false, false, false, false},
//	 	            {false, false, false, false, false},
//	 	            {false, false, false, false, false}
//	 	        };
//	    	
//	    
//	    answerArray = solver.solve(a);
//	    System.out.println(Arrays.toString(answerArray));
//	    
	    
	    
	}

}
