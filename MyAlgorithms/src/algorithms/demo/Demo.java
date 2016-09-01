package algorithms.demo;

import algorithms.mazeGenerators.*;
import algorithms.search.*;

/** Demonstrates the 2 algorithms of searching: BFS and DFS. */
public class Demo 
{

	/** 
	   * Demonstrates the 2 algorithms of searching.
	   * Creats simple maze 3d, printing it and outputs how many nodes evalutes by each algorithm.
	  */
	public void run() 
	{
		SimpleMaze3dGenerator mg1= new SimpleMaze3dGenerator(); //Creates simple maze
		Maze3D simpleMaze = mg1.generate(5, 5, 5);  // generating the maze
		simpleMaze.printMaze(); // Printing the maze
		
		// Creating Searchable variable
		Searchable s = new Maze3DSearchable(simpleMaze);
		// Creating BFS algorithm search
		BFS bfsSol =new BFS();
		bfsSol.search(s);
		System.out.println("Bfs evalutes:" + bfsSol.getNodesEvaluated());
		
		// Creating DFS algorithm search
		DFS dfsSol =new DFS();
		dfsSol.search(s);
		System.out.println("Dfs evalutes:" + dfsSol.getNodesEvaluated());	
	}
	
}
