package PP13_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * BackTrackSolution is a recursive solution of type BackTrack as it voids dead-ends and
 * efficiently finds the exit
 * @author Jonathan Dang || Zaojia Zhao
 *
 */
public class BackTrackSolution {
	private static int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	
	/**
	 * Holder/Frame in which recursion will begin.
	 * @param maze The unsolved-maze
	 * @return A list of Coordinates that either has the solution to said Maze or an empty list
	 * 			Signifying that there is no possible solution.
	 */
	 public List<Coordinate> solve(Maze maze) {
	        LinkedList<Coordinate> possibleMoves = new LinkedList<>();
	        Coordinate start = maze.getEnterence();
	        possibleMoves.add(start);

	        while (!possibleMoves.isEmpty()) {
	            Coordinate coord = possibleMoves.remove();

	            if (!maze.isValid(coord.getXCoord(), coord.getYCoord()) 
	            		|| maze.isVisited(coord.getXCoord(), coord.getYCoord())) 
	            {
	                continue;
	            }

	            if (maze.isWall(coord.getXCoord(), coord.getYCoord())) 
	            {
	                maze.setVisited(coord.getXCoord(), coord.getYCoord(), true);
	                continue;
	            }

	            if (maze.isExit(coord.getXCoord(), coord.getYCoord())) 
	            {
	                return backtrackPath(coord);
	            }

	            for (int[] direction : DIRECTIONS) 
	            {
	                Coordinate coordinate = new Coordinate(coord.getXCoord() +
	                		direction[0], coord.getYCoord() + direction[1], coord);
	                possibleMoves.add(coordinate);
	                maze.setVisited(coord.getXCoord(), coord.getYCoord(), true);
	            }
	        }
	        return Collections.emptyList();
	    }
	 
	 	/**
	 	 * Recursion function in which will backtrack through levels to figure out the solution
	 	 * @param coord The Coordinate in question
	 	 * @return The Path taken from the start
	 	 */
	    private List<Coordinate> backtrackPath(Coordinate coord) 
	    {
	        List<Coordinate> path = new ArrayList<Coordinate>();
	        Coordinate iter = coord;

	        while (iter != null) {
	            path.add(iter);
	            iter = iter.getParent();
	        }

	        return path;
	    }
}
