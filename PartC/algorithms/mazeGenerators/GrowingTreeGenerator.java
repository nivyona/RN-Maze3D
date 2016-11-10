package algorithms.mazeGenerators;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class GrowingTreeGenerator extends AbstractMaze3DGenerator 
{
	private ArrayList<Position> cells;
	Scanner reader = new Scanner(System.in);

	@Override
	public Maze3D generate(int x, int y, int z) 
	{
		Maze3D maze3d = new Maze3D(x,y,z);
		maze3d.fillWalls();
		maze3d.createStartPosition();
		ArrayList<Position> cells = new ArrayList<Position>();
		cells.add(maze3d.getCurrent()); // add the first cell that chosen randomly
		System.out.println("if you want to random press 1, if you want the last cell press 2");
		int choose = reader.nextInt();

		Random rand = new Random(); 
		
		while (!cells.isEmpty())
		{
			if (choose == 2)
			{
				maze3d.setCurrent(cells.get(cells.size()-1));// Choose the last cell in  c 
			}
			else
			{
				maze3d.setCurrent(cells.get(rand.nextInt(cells.size()))); // choose randomly the next neighbor 
			}
			if (maze3d.unvisitedNeighbors())
			{
				while(!maze3d.createRandomPath()); 
				// Setting the path to next
				cells.add(maze3d.getCurrent());
			}
			else 
				cells.remove(maze3d.getCurrent());	
		}
		maze3d.createGoalPosition();
		maze3d.resetPosition();
		return  maze3d;
	}
	
	public void addRandomCell (Position p)
	{
		cells.add(p);
	}

	public ArrayList<Position> getCells() {
		return cells;
	}

	public void setMyList(ArrayList<Position> cells) {
		this.cells = cells;
	}
	
}
