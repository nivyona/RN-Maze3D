package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMaze3dGenerator extends AbstractMaze3DGenerator {


	protected int[][][] mazeArr;
	
	@Override
	public Maze3D generate (int x, int y, int z) 
	{		
		Maze3D maze3d = new Maze3D(x,y,z); 
		maze3d.createStartPosition();
		Random rand = new Random();
		int moves = rand.nextInt(maze3d.getxAxis()*maze3d.getyAxis()*maze3d.getzAxis());
		for (int i = 0; i< moves; i++)
		{
			maze3d.createRandomPath();
		}
		maze3d.createGoalPosition();
		return maze3d;
	}
}

	