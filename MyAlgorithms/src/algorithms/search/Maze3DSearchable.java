package algorithms.search;


import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3D;
import algorithms.mazeGenerators.Position;

/**Maze3D Searchable class defins Maze3D as a serachable object.*/

public class Maze3DSearchable implements Searchable 
{
	Maze3D maze;

	public Maze3DSearchable (Maze3D maze)
	{
		this.maze = maze;
	}
	/** Getting the initial state*/
	@Override
	public State getInitialState() 
	{
		Position start = new Position(this.maze.getStart());
		
		if(start.getY() == 0)
		{
			start.setY(1);
		}
		
		else if(start.getY() == this.maze.getyAxis()-1)
		{
			start.setY(start.getY()-1);
		}
		
		else if(start.getZ() == 0)
		{
			start.setZ(1);
		}
		else
		{
			start.setZ(start.getZ()-1);
		}
		return start.toState();
	}
	/** Getting the goal state*/
	@Override
	public State getGoalState() 
	{
		Position goal =new Position(this.maze.getGoal());
		
		if(goal.getY() == 0)
		{
			goal.setY(1);
		}
		
		else if(goal.getY() == this.maze.getyAxis()-1)
		{
			goal.setY(goal.getY()-1);
		}
		
		else if(goal.getZ() == 0)
		{
			goal.setZ(1);
		}
		else
		{
			goal.setZ(goal.getZ()-1);
		}		
		return goal.toState();
	}

	/** 
	 * Checking what are the possible next states
	 * @param state for the check
	 * @return list of the possible next states
	*/
	
	@Override
	public ArrayList<State> getAllPossibleStates(State s) 
	{
		ArrayList<Position> pos = this.getFreePositions(new Position(s));
		ArrayList<State> states = new ArrayList<State>();
		State temp;
		for(Position p : pos)
		{
			temp = p.toState();
			temp.setCameFrom(s);
			states.add(temp);
		}
		return states;
		
	}
	
	/** 
	 * Checking what are the free positions 
	 * @param position for the check
	 * @return list of the possible next positions
	*/
	
	//Getting all the free positions 
			public ArrayList<Position> getFreePositions(Position p)
			{
				Position upFloor = new Position(p);
				upFloor.setX(upFloor.getX()+1);
				Position downFloor = new Position(p);
				downFloor.setX(downFloor.getX()-1);
				Position forward = new Position(p);
				forward.setY(forward.getY()+2);
				Position backward = new Position(p);
				backward.setY(backward.getY()-2);
				Position right = new Position(p);
				right.setZ(right.getZ()+2);
				Position left = new Position(p);
				left.setZ(left.getZ()-2);
				
				// Creates an array thats symbolize the moves 
				ArrayList<Position> moves= new ArrayList<Position>();
				// Check if the the the next position is valid
				if (this.maze.cellFree(upFloor))
				{
					moves.add(upFloor);
		 		}
				if (this.maze.cellFree(downFloor))
				{
					moves.add(downFloor);
		 		}
				if (this.maze.cellFree(forward))
				{
					moves.add(forward);
		 		}
				if (this.maze.cellFree(backward))
				{
					moves.add(backward);
		 		}
				if (this.maze.cellFree(right))
				{
					moves.add(right);
		 		}
				if (this.maze.cellFree(left))
				{
					moves.add(left);
		 		}
				return moves;	
			}
		

}
