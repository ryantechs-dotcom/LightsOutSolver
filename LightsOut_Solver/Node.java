
package p2;
//import edu.princeton.cs.algs4.*;

public class Node {
    public final Board board;
    public final int[] move;

    public Node(Board board, int[] move) {
        this.board = board;
        this.move = move;
    }


    public Board getBoard() {
        return board;
    }

    public int[] getMove() {
        return move;
    }
    
}