/******************************************************************************
 *  Compilation:  javac BreadthFirstPaths.java
 *  Execution:    java BreadthFirstPaths G s
 *  Dependencies: Graph.java Queue.java Stack.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/41graph/tinyCG.txt
 *                https://algs4.cs.princeton.edu/41graph/tinyG.txt
 *                https://algs4.cs.princeton.edu/41graph/mediumG.txt
 *                https://algs4.cs.princeton.edu/41graph/largeG.txt
 *
 *  Run breadth first search on an undirected graph.
 *  Runs in O(E + V) time.
 *
 *  %  java Graph tinyCG.txt
 *  6 8
 *  0: 2 1 5 
 *  1: 0 2 
 *  2: 0 1 3 4 
 *  3: 5 4 2 
 *  4: 3 2 
 *  5: 3 0 
 *
 *  %  java BreadthFirstPaths tinyCG.txt 0
 *  0 to 0 (0):  0
 *  0 to 1 (1):  0-1
 *  0 to 2 (1):  0-2
 *  0 to 3 (2):  0-2-3
 *  0 to 4 (2):  0-2-4
 *  0 to 5 (1):  0-5
 *
 *  %  java BreadthFirstPaths largeG.txt 0
 *  0 to 0 (0):  0
 *  0 to 1 (418):  0-932942-474885-82707-879889-971961-...
 *  0 to 2 (323):  0-460790-53370-594358-780059-287921-...
 *  0 to 3 (168):  0-713461-75230-953125-568284-350405-...
 *  0 to 4 (144):  0-460790-53370-310931-440226-380102-...
 *  0 to 5 (566):  0-932942-474885-82707-879889-971961-...
 *  0 to 6 (349):  0-932942-474885-82707-879889-971961-...
 *
 ******************************************************************************/

package p2;
import edu.princeton.cs.algs4.*;
import java.util.HashMap;
import java.util.TreeMap;
//import java.util.Queue;

/**
 *  The {@code BreadthFirstPaths} class represents a data type for finding
 *  shortest paths (number of edges) from a source vertex <em>s</em>
 *  (or a set of source vertices)
 *  to every other vertex in an undirected graph.
 *  <p>
 *  This implementation uses breadth-first search.
 *  The constructor takes time proportional to <em>V</em> + <em>E</em>,
 *  where <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
 *  Each call to {@link #distTo(int)} and {@link #hasPathTo(int)} takes constant time;
 *  each call to {@link #pathTo(int)} takes time proportional to the length
 *  of the path.
 *  It uses extra space (not including the graph) proportional to <em>V</em>.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/41graph">Section 4.1</a>   
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class BreadthFirstPaths3 {
//11184811
    private HashMap<Board,Node> all_boards = new HashMap<Board,Node>(11184811);
//    private TreeMap<Board, Node> all_boards = new TreeMap<Board,Node>();
    private int[] answer;
    

  


    // breadth-first search from a single source
    public void bfs(Board start) {
    	Queue<Board> options;
    	all_boards.put(start, null);
        Queue<Board> q = new Queue<Board>();
        q.enqueue(start);
        
        while(q.isEmpty() == false) {
        	options = mnb(q.dequeue());
        	if(options.size() == 0) {
        		continue;
        	}
        	for(Board option: options) {
        		q.enqueue(option);
        	}
        	
        	
        }
        

        } 
    
    
    
//    make new boards
    public Queue<Board> mnb(Board board) {
    	Board original = new Board(board.getPuzzle());
    	Queue<Board> boards = new Queue<Board>();
    	
    	for(int i = 0; i<5; i++) {
    		for(int j = 0; j<5; j++) {
    			int[] move = new int[]{i,j};
    			original.move(i,j);
    			Board current = new Board(original.getPuzzle());
    			
    			if(!all_boards.containsKey(current) == true) {
    				boards.enqueue(current);
    				Node edge = new Node(board, move);
    				all_boards.put(current, edge);			
    			}
    			original.move(i, j);
    			
    		}
    	}
    	return boards;
    }
    
    
    
    
    
    
    public int[] solution(Board start, Board shuffled) {
    	Board temp = shuffled;
    	
//    	int[] none = new int[0];
    	if(all_boards.get(temp) == null) {
    		return null ;
    	}
    	 
    	int i = 0;
    	while(temp.equals(start) == false) {
    		temp = all_boards.get(temp).getBoard();
    		i += 1;
    		
    		
    	}
    	
    	int[] moves = new int[i*2];
    	temp = shuffled;
    	int j = 0;
    	while(temp.equals(start) == false) {
    		moves[j] = all_boards.get(temp).getMove()[0];
    		moves[j+1] = all_boards.get(temp).getMove()[1];
    		temp = all_boards.get(temp).getBoard();
    		j += 2;
    		
    		
    	}
    	
    	answer= moves;
    	
    	return answer;
    }

    
}

/******************************************************************************
 *  Copyright 2002-2018, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/
