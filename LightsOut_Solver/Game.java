package p1;

import java.util.HashSet;
import java.util.Scanner;

public class Game {
	private Board board = new Board(0);
    private Scanner scanner;
	private HashSet<Board> boards;
	
	public Game() {
        this.scanner = new Scanner(System.in);
        this.boards = new HashSet<Board>();
	}
	
	public void Difficulty(int difficulty) {
        this.board = new Board(difficulty);
    }
	
	public void play() {
        if (board == null) {
            System.out.println("Please select difficulty first.");
            return;
        }
        
        while (true) {
            System.out.println("Enter 2 numbers (0-4) seperated by a space for the row and column of your move: ");
            String[] input = scanner.nextLine().split(" ");
            try {
                int row = Integer.parseInt(input[0]);
                int col = Integer.parseInt(input[1]);
                board.move(row, col);
                if(board.isSolved()) {
                	System.out.println("You Win!");
                	break;
                }
                if(boards.contains(board)) {
                	System.out.println(" You repated a board position. You LOSE!");
                	break;
                }
                boolean[][] state_puzzle = board.getPuzzle();
                Board state = new Board(state_puzzle);
                boards.add(state);
                System.out.println(board);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please enter integers for row and column separated by space.");
            }
        }
    }
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("What difficulty do you want (1-9): ");
        int difficulty = scanner.nextInt();
        scanner.nextLine(); 
        Game game = new Game();
        game.Difficulty(difficulty);
        System.out.println(game.board);
        game.play();
        scanner.close();
	}
}
