package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
* The Maze3d program implements an application that create a maze 3d.
*
* @author  Niv Yona
* @version 1.0
* @since   01-08-2016 
*/

public class Maze3D  
{
	private int xAxis; // size of x axis
	private int yAxis; // size of y axis
	private int zAxis; // size of z axis

	
	protected int[][][] maze;
	Position start;
	Position goal;
	Position current;
	
	 /** 
	   * Maze 3D Constructor, gets 3 axis of the maze.
	   * @param x symbolize the floor.
	   * @param Y symbolize the y axis in mathematical graph.
	   * @param Z symbolize the x axis in mathematical graph.
	  */
	
	public Maze3D (int x, int y, int z)
	{		
		this.xAxis = x;
		this.yAxis = y*2+1;
		this.zAxis = z*2+1;
		this.maze = new int[this.getxAxis()][this.getyAxis()][this.getzAxis()];
		this.start = new Position();;
		this.goal = new Position();
		this.fillWalls();
	}
	
	
	/** 
	   * Fill maze with walls.
	  */
	public void fillWalls()
	{
		for (int i = 0; i <= this.getxAxis()-1; ++i)
			for (int j = 0; j <= this.getyAxis()-1; ++j)
				for (int k=  0; k <= this.getzAxis()-1; ++k)
				{
					this.maze[i][j][k] = 1;
				}
	}
	
	/** 
	   * Creating random path in the maze.
	  */
	public boolean createRandomPath() 
	{
			Random rand = new Random(); 
			int choose = rand.nextInt(6);	
					
				switch (choose) 
				{	
				case 0: // X axis
					if(this.moveUpFloor())
					{
						return true;
					}
					break;
				case 1:	// Y axis
					if(this.moveForward())
					{
						return true;
					}
					break;
				case 2:	// Z axis
					if(!this.moveRight())
					{
						return true;
					}
					break;
				case 3: // X axis
					if(this.moveDownFloor())
					{
						return true;
					}
					break;
				case 4:	// Y axis
					if(this.moveBackward())
					{
						return true;
					}
					break;
				case 5:	// Z axis
					if(this.moveLeft())
					{
						return true;
					}
					break;		
				}
				return false;
	}
	
	/** 
	   * Checking if the Up Floor is available.
	   * @return boolean return if executed.
	  */
	public boolean moveUpFloor()
	{
		Position p = new Position(this.getCurrent());
		p.setX(p.getX()+1);
		if (this.positionExists(p))
		{
			setPath(p);
			return true;
		}
		return false;			
	}
	
	/** 
	   * Checking if the Down Floor is available.
	   * @return boolean return if executed.
	  */
	public boolean moveDownFloor()
	{
		Position p = new Position(this.getCurrent());
		p.setX(p.getX()-1);
		if (this.positionExists(p))
		{
			setPath(p);
			return true;
		}
		return false;			
	}
	
	/** 
	   * Checking if the Moving Forward is available.
	   * @return boolean return if executed.
	  */
	public boolean moveForward()
	{
		Position p = new Position(this.getCurrent());
		Position w = new Position(this.getCurrent());
		p.setY(p.getY()+2);
		w.setY(w.getY()+1);
		if (this.positionExists(p))
		{
			setPath(w);
			setPath(p);
			return true;
		}	
		return false;			
	}

	/** 
	   * Checking if the Moving Backward is available.
	   * @return boolean return if executed.
	  */
	public boolean moveBackward()
	{
		Position p = new Position(this.getCurrent());
		Position w = new Position(this.getCurrent());
		p.setY(p.getY()-2);
		w.setY(w.getY()-1);
		if (this.positionExists(p))
		{
			setPath(w);
			setPath(p);
			return true;
		}	
		return false;			
	}
	
	/** 
	   * Checking if the Moving Right is available.
	   * @return boolean return if executed.
	  */
	public boolean moveRight()
	{
		Position p = new Position(this.getCurrent());
		Position w = new Position(this.getCurrent());
		p.setZ(p.getZ()+2);
		w.setZ(w.getZ()+1);
		if (this.positionExists(p))
		{
			setPath(w);
			setPath(p);
			return true;
		}	
		return false;			
	}
	
	/** 
	   * Checking if the Moving Left is available.
	   * @return boolean return if executed.
	  */
	public boolean moveLeft()
	{
		Position p = new Position(this.getCurrent());
		Position w = new Position(this.getCurrent());
		p.setZ(p.getZ()-2);
		w.setZ(w.getZ()-1);
		if (this.positionExists(p))
		{
			setPath(w);
			setPath(p);
			return true;
		}	
		return false;			
	}
	
	@Override
	public String toString() 
	{
		String print = " ";
		for (int i = 0; i <= this.getxAxis(); ++i)
		{
			for (int j = 0; j <= this.getyAxis(); ++j)
			{
				for (int k=  0; k <= this.getzAxis(); ++k)
				{
					print+=this.maze[i][j][k]+" ";
				}
				print+="\n";
			}
			print+="\n";
		}
		return print;
	}
	
	/** 
	   * Printing the maze.
	  */
	public void printMaze()
	{
		for (int i = 0; i < this.getxAxis(); ++i)
		{
			for (int j = 0; j < this.getyAxis(); ++j)
			{
				for (int k=  0; k < this.getzAxis(); ++k)
				{
					System.out.print(this.maze[i][j][k] + " ");
				}
				System.out.println("");
			}
			System.out.println("");
		}
		System.out.println("\n");
	}
	
	/** 
	   * Printing the 2d maze.
	   * @return boolean return if executed.
	  */
	
	public void print2dMaze(int[][] maze2d)
	{
		for (int[] row : maze2d)
		{
		    System.out.println(Arrays.toString(row));
		}
		System.out.println("");
	}
	
	/** 
	   * Checks what is the possible moves from a position 
	   * @param Position.
	   * @return ArrayList of available moves.
	  */
	
	//Getting all the possible moves from a position
	public ArrayList<String> getPossibleMoves(Position p)
	{
		Position upFloor = new Position(p);
		upFloor.setX(upFloor.getX()+1);
		Position downFloor = new Position(p);
		downFloor.setX(downFloor.getX()-1);
		Position forward = new Position(p);
		forward.setY(forward.getY()+2);
		Position backward = new Position(p);
		backward.setY(forward.getY()-2);
		Position right = new Position(p);
		right.setZ(right.getZ()+2);
		Position left = new Position(p);
		left.setZ(left.getZ()-2);
		
		// Creates an array thats symbolize the moves 
		ArrayList<String> moves= new ArrayList<String>();
		// Check if the the the next position is valid
		if (this.cellAvailable(upFloor))
		{
			moves.add("Floor Up ");
 		}
		if (this.cellAvailable(downFloor))
		{
			moves.add("Floor Down ");
 		}
		if (this.cellAvailable(forward))
		{
			moves.add("Forward ");
 		}
		if (this.cellAvailable(backward))
		{
			moves.add("Backward ");
 		}
		if (this.cellAvailable(right))
		{
			moves.add("Right ");
 		}
		if (this.cellAvailable(left))
		{
			moves.add("Left ");
 		}
		return moves;	
	}
	
	/** 
	   * Checks what is the possible moves from the current position
	   * @return ArrayList of available moves.
	  */
	
	public ArrayList<String> getPossibleMoves()
	{
		return this.getPossibleMoves(this.getCurrent());
	}
	
	/** 
	   * Checking if the position has unvisited neighbors
	  */

	public boolean unvisitedNeighbors()
	{
		ArrayList<String> neighbors = this.getPossibleMoves();
		if (neighbors.size()>0)
				return true;
		return false;
	}
	/** 
	   * Checking if position exits
	  */
		public boolean positionExists(Position p)
		{
			if (((p.getX()>this.getxAxis()-1) || (p.getX() < 0))
				|| (p.getY() > this.getyAxis()-1 || p.getY()< 0) || (p.getZ() > this.getzAxis()-1 || p.getZ() < 0)) 
				return false;
			return true;
		} 
	/** 
	   * Checking if a cell is available
	  */
		public boolean cellAvailable(Position p)
		{
			if (this.positionExists(p) &&  this.getMaze()[p.getX()][p.getY()][p.getZ()] == 1)
			{
				return true;
			}
			return false;
		}
		
		/** 
		   * Checking if a cell is free to move (zero)
		  */
			public boolean cellFree(Position p)
			{
				if (this.positionExists(p) &&  this.getMaze()[p.getX()][p.getY()][p.getZ()] == 0)
				{
					return true;
				}
				return false;
			}
		
		
	/** 
	   * Setting position to be path
	   * @param Position.
	  */	
	public boolean setPath(Position p)
	{
		if(positionExists(p))
		{
		this.maze[p.getX()][p.getY()][p.getZ()] = 0;
		this.setCurrent(p);
		return true;
		}
		return false;
	}
	/** 
	   * Setting position to be wall
	   * @param Position.
	  */
	public boolean setWall(Position p)
	{
		if(positionExists(p))
		{
		this.maze[p.getX()][p.getY()][p.getZ()] = 1;
		return true;
		}
		return false;
	}
	/** 
	   * Creates the start position
	  */
	public void createStartPosition()
	{
		Position p = new Position();
		Random rand = new Random();
		p.setX(0); // starts form the bottom
		do{
		p.setY(rand.nextInt(this.getyAxis()));// random the y axis
		p.setZ(rand.nextInt(this.getzAxis()));// random the z axis	
		} while (!(((p.getY() == 0 || p.getY() == this.getyAxis()-1) && p.getZ()%2!=0 ) || 
				((p.getZ() == 0 || p.getZ() == this.getzAxis()-1)  && p.getY()%2!=0)));
		setPath(p);
		this.setStart(p);
		p = new Position(p);
		if (p.getY()==0)
		{
			p.setY(p.getY()+1);
		}
		else if (p.getY()== this.getyAxis()-1)
		{
			p.setY(p.getY()-1);
		}
		
		else if (p.getZ()==0)
		{
			p.setZ(p.getZ()+1);
		}
		else if (p.getZ()== this.getzAxis()-1)
		{
			p.setZ(p.getZ()-1);
		}
		this.setPath(p);
	}
		
	/** 
	   * Checking if the current position is near exit
	  */
	public boolean nearExit()
	{
		if ((this.getCurrent().getX() == this.getxAxis()-1) &&
				((this.getCurrent().getY() == this.getyAxis()-2 || this.getCurrent().getY() == 1) || 
				(this.getCurrent().getZ() == this.getzAxis()-2 || this.getCurrent().getZ() == 1)))
		{
			return true;
		}
		return false;
	}
	
	/** 
	   * Creates the goal position
	  */
	public void createGoalPosition()
	{
		Position p = new Position();
		while (!this.nearExit())
		{
			this.createRandomPath();
		}
		if (this.getCurrent().getY() == this.getyAxis()-2)
		{
			p = this.getCurrent();
			p.setY(p.getY()+1);
			setPath(p);
			this.setGoal(p);
		}
		else if (this.getCurrent().getY() == 1)
		{
			p = this.getCurrent();
			p.setY(p.getY()-1);
			setPath(p);
			this.setGoal(p);
		}
		else if (this.getCurrent().getZ() == this.getzAxis()-2)
		{
			p = this.getCurrent();
			p.setZ(p.getZ()+1);
			setPath(p);
			this.setGoal(p);
		}
		else if (this.getCurrent().getZ() == 1)
		{
			p = this.getCurrent();
			p.setZ(p.getZ()-1);
			setPath(p);
			this.setGoal(p);
		}
	}
		
	public Position getStartPosition() {
		return start;
	}

	public void setStart(Position start) {
		this.start=start;
	}

	public void setGoal(Position goal) {
		this.goal = goal;
	}
	public int[][] getCrossSectionByX(int n) throws IndexOutOfBoundsException
	{
		int[][] maze2d = new int[this.getyAxis()][this.getzAxis()];
		
			for (int j = 0; j < this.getyAxis(); ++j)
				for (int k=  0; k < this.getzAxis(); ++k)
				{
					maze2d[j][k] = this.getMaze()[n][j][k];
				}
		return maze2d;
	}
	
	public int[][] getCrossSectionByY(int n) throws IndexOutOfBoundsException
	{
		int[][] maze2d = new int[this.getxAxis()][this.getzAxis()];
		
			for (int j = 0; j < this.getxAxis(); ++j)
				for (int k=  0; k < this.getzAxis(); ++k)
				{
					maze2d[j][k] = this.getMaze()[j][n][k];
				}
		return maze2d;
	}
	
	public int[][] getCrossSectionByZ(int n) throws IndexOutOfBoundsException
	{
		int[][] maze2d = new int[this.getxAxis()][this.getyAxis()];
		
			for (int j = 0; j < this.getxAxis(); ++j)
				for (int k=  0; k < this.getyAxis(); ++k)
				{
					maze2d[j][k] = this.getMaze()[j][k][n];
				}
		return maze2d;
	}
	
	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public int getzAxis() {
		return zAxis;
	}

	public void setzAxis(int zAxis) {
		this.zAxis = zAxis;
	}

	public int[][][] getMaze() {
		return maze;
	}

	public void setMaze(int[][][] maze) {
		this.maze = maze;
	}

	public Position getStart() {
		return start;
	}

	public Position getGoal() {
		return goal;
	}	

	public Position getCurrent() {
		return current;
	}

	public void setCurrent(Position current) {
		this.current = current;
	}
	
	public byte[] toByteArray()
	{
		byte[] res = new byte[9+(this.getxAxis()*this.getyAxis()*this.getzAxis())];
		
		res[0] = (byte)this.getStartPosition().getX();
		res[1] = (byte)this.getStartPosition().getY();
		res[2] = (byte)this.getStartPosition().getZ();
		res[3] = (byte)this.getGoal().getX();
		res[4] = (byte)this.getGoal().getY();
		res[5] = (byte)this.getGoal().getZ();
		res[6] = (byte)this.getxAxis();
		res[7] = (byte)this.getyAxis();
		res[8] = (byte)this.getzAxis();
		int count = 9;
		for (int i = 0; i < this.getxAxis(); ++i)
		{
			for (int j = 0; j < this.getyAxis(); ++j)
			{
				for (int k=  0; k < this.getzAxis(); ++k)
				{
					res[count] = (byte)this.getMaze()[i][j][k];
					count++;
				}
			}
		}
		return res;
	}

	public Maze3D(byte[] mazeBytes)
	{
		this.setStart(new Position(mazeBytes[0],mazeBytes[1],mazeBytes[2]));
		this.setGoal(new Position(mazeBytes[3],mazeBytes[4],mazeBytes[5]));
		
		this.setxAxis(mazeBytes[6]);
		this.setyAxis(mazeBytes[7]);
		this.setzAxis(mazeBytes[8]);
		this.setMaze(new int[this.getxAxis()][this.getyAxis()][this.getzAxis()]);
		int count = 9;
		for (int i = 0; i < this.getxAxis(); ++i)
		{
			for (int j = 0; j < this.getyAxis(); ++j)
			{
				for (int k=  0; k < this.getzAxis(); ++k)
				{
					this.maze[i][j][k] = mazeBytes[count];
					count++;
				}
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maze3D other = (Maze3D) obj;
		if (!Arrays.deepEquals(maze, other.maze))
			return false;
		return true;
	}
	
}

