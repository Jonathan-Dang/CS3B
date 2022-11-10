package PP13_8;

import java.util.Arrays;
import java.util.List;

/**
 * Maze holds an unsolved maze in which could accept a list of Coordinates
 * that is the solution of the maze
 * @author Jonathan Dang || Zaojia Zhao
 *
 */
public class Maze {
	private int _maze[][];
	private int _height;
	private int _width;
	private Coordinate _enterence;
	private Coordinate _exit;
	public static final int WALL = 0;
	public static final int SPACE = 1;
	public static final int ENTERANCE = 2;
	public static final int EXIT = 3;
	public static final int SOLUTION = 4;
	private boolean[][] _visited;
	
	/**
	 * Constructs an empty Maze
	 * @param width The Width of the maze
	 * @param height The height of the maze
	 */
	public Maze(int width, int height)
	{
		_height = height;
		_width = width;
		_maze = new int[height][width];
		_visited = new boolean[height][width];
		for (int i = 0; i < _height; i++)
		{
			for (int t = 0; t < _width; t++)
			{
				_visited[i][t] = false;
			}
		}
	}
	
	/**
	 * Constructs a filled maze given a string
	 * @param maze The Maze in Symbols
	 */
	public Maze(String maze)
	{
		String[] lines = maze.split("[\r]?\n");
		this._maze = new int[lines.length][lines[0].length()];
		this._visited = new boolean[lines.length][lines[0].length()];
		_height = lines.length;
		_width = lines[0].length();
		for (int i = 0; i < _height; i++)
		{
			for (int t = 0; t < _width; t++)
			{
				_visited[i][t] = false;
			}
		}
		
		for(int i = 0 ; i < _height; i++)
		{
			for (int t = 0; t < _width; t++)
			{
				switch(lines[i].charAt(t))
				{
				case('#'):
					this._maze[i][t] = WALL;
					break;
				case(' '):
					this._maze[i][t] = SPACE;
					break;
				case('O'):
					this._maze[i][t] = ENTERANCE;
					_enterence = new Coordinate(t,i);
					break;
				case('X'):
					this._maze[i][t] = EXIT;
					_exit = new Coordinate(t,i);
					break;
				}
			}
		}
	}
	
	/**
	 * Sets the maze to a given int matrix
	 * @param maze The Maze
	 */
	public void setMaze(int[][] maze)
	{
		for (int i = 0; i < _height; i++)
		{
			for (int t = 0; t < _width; t++)
			{
				_maze[i][t] = maze[i][t];
				if (maze[i][t] == 2)
					_enterence = new Coordinate(i,t);
				if (maze[i][t] == 3)
					_exit = new Coordinate(i,t);
			}
		}
	}
	
	/**
	 * Returns the maze as an Int Matrix
	 * @return the maze
	 */
	public int[][] getMaze()
	{
		return _maze;
	}
	
	/**
	 * Returns the height
	 * @return height
	 */
	public int getHeight()
	{
		return _height;
	}
	
	/**
	 * Returns the width
	 * @return width
	 */
	public int getWidth()
	{
		return _width;
	}
	
	/**
	 * Returns the Coordinates of the Enterence
	 * @return the enterence
	 */
	public Coordinate getEnterence()
	{
		return _enterence;
	}
	
	/**
	 * Returns the Coordinates of the Exit
	 * @return exit
	 */
	public Coordinate getExit()
	{
		return _exit;
	}
	
	/**
	 * Set a certain position in the boolean matrix as the given boolean
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param valid The state of the position
	 */
	public void setVisited(int x, int y, boolean valid)
	{
		this._visited[y][x] = valid;
	}
	
	/**
	 * Checks if the given coordinate is the exit
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @return if Coordinate(x,y) == _exit -> True
	 */
	public boolean isExit(int x, int y)
	{
		return _exit.equals(new Coordinate(x,y));
	}
	
	/**
	 * Checks if the given coordinate is the enterence
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @return if Coordinate(x,y) == _enterence -> True
	 */
	public boolean isEnterence(int x, int y)
	{
		return _enterence.equals(new Coordinate(x,y));
	}
	
	/**
	 * Checks if the given coordinate is a wall
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @return if Coordinate(x,y) == WALL -> True
	 */
	public boolean isWall(int x, int y)
	{
		return _maze[y][x] == WALL;
	}
	
	/**
	 * Checks if the given coordinate is the exit
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @return if Coordinate(x,y); _visited -> True : Return true;
	 */
	public boolean isVisited(int x, int y)
	{
		return _visited[y][x];
	}
	
	/**
	 * Checks of the given position is valid on the maze
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @return if valid, return true
	 */
	public boolean isValid(int x, int y)
	{
		if (x < 0 || x > this.getHeight() || y < 0 || y > this.getWidth())
			return false;
		else
			return true;
	}
	
	/**
	 * Prints the Solution path, if any, to this maze
	 * @param path the solution
	 */
	public void printPath(List<Coordinate> path) 
	{
        int[][] tempMaze = Arrays.stream(_maze)
            .map(int[]::clone)
            .toArray(int[][]::new);
        for (Coordinate coordinate : path) {
            if (isEnterence(coordinate.getXCoord(), coordinate.getYCoord()) 
            		|| isExit(coordinate.getXCoord(), coordinate.getYCoord())) 
            {
                continue;
            }
            tempMaze[coordinate.getYCoord()][coordinate.getXCoord()] = SOLUTION;
        }
        System.out.println(toString(tempMaze));
    }
	
	/**
	 * Manual Override to the entire maze
	 */
	@Override
	public String toString()
	{
		String output = "";
		for(int i = 0; i < _height; i++)
		{
			for (int t = 0; t < _width; t++)
			{
				switch (_maze[i][t])
				{
				case(WALL):
					output += "#";
					break;
				case(SPACE):
					output += " ";
					break;
				case(EXIT): 
					output += "X";
					break;
				case(ENTERANCE):
					output += "O";
					break;
				case(SOLUTION):
					output += "*";
					break;
				}
			}
			output += "\n";
		}
		return output;
	}
	
	/**
	 * Prints an integer matrix as a maze
	 * @param maze The Integer matrix
	 * @return the String
	 */
	public String toString(int[][] maze)
	{
		String output = "";
		for(int i = 0; i < _height; i++)
		{
			for (int t = 0; t < _width; t++)
			{
				switch (maze[i][t])
				{
				case(WALL):
					output += "#";
					break;
				case(SPACE):
					output += " ";
					break;
				case(EXIT): 
					output += "X";
					break;
				case(ENTERANCE):
					output += "O";
					break;
				case(SOLUTION):
					output += "*";
					break;
				}
			}
			output += "\n";
		}
		return output;
	}
}
