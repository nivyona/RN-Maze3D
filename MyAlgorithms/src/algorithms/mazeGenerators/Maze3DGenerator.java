package algorithms.mazeGenerators;
import algorithms.mazeGenerators.Maze3D;

public interface Maze3DGenerator
{

	/** 
	   *Generating New Maze3D 
	   * @param x - symbolize the floor
	   * @param y - symbolize the y axis
	   * @param z - symbolize the x axis in mathematical graph
	   * @return the time in milliseconds.
	  */
	public Maze3D generate (int x, int y , int z) ;
	/** 
	   * Checking how much time take to generate a maze
	   * @param x axis
	   * @param y axis
	   * @param z axis
	   * @return the time in milliseconds.
	  */
	public String measureAlgorithmTime (int x, int y,int z);
}
