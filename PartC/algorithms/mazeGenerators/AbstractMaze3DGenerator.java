package algorithms.mazeGenerators;

public abstract class AbstractMaze3DGenerator implements Maze3DGenerator{

	@Override
	public abstract Maze3D generate(int x, int y, int z);
	@Override
	public String measureAlgorithmTime(int x, int y,int z) 
	{
		long startTime = System.currentTimeMillis();
		generate(x, y, z);
		long endTime = System.currentTimeMillis();		
		long dif = endTime - startTime;
		String result = String.valueOf(dif);
	
		return "Takes " + result + " Mili Seconds";
	}
	 
}
