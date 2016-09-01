package algorithms.mazeGenerators;

import algorithms.search.State;

public class Position 
{
	private int x;
	private int y;
	private int z;

	public Position(int x, int y, int z) 
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/** 
	   * Position Constructor
	  */
	public Position() 
	{
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	/** 
	   * Position Constructor
	   * copy position to a new pointer
	   * @param position
	  */
	public Position(Position p) 
	{
		this.x = p.getX();
		this.y = p.getY();
		this.z = p.getZ();
	}
	public Position(State s) 
	{
		String[] xyz = s.getState().split(",");
		String xStr = xyz[0];
		String yStr = xyz[1];
		String zStr = xyz[2];
		this.x = Integer.parseInt(xStr);
		this.y = Integer.parseInt(yStr);
		this.z = Integer.parseInt(zStr);
	}
	
	/** 
	   * Compare between 2 positions
	   * @return return the result
	  */
	
	public boolean equals(Position p)
	{
		if ((this.getX() == p.getX()) && this.getY() == p.getY() && this.getZ() == p.getZ())
		{
			return true;
		}
		return false;
		
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Position {"+x+","+y+","+z+"}";

	}
	public State toState()
	{
		State s = new State(this.getX()+","+this.getY()+","+this.getZ());
		s.setCost(10);
		return s;
	}

}
