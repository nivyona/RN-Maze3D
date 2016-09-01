package algorithms.search;

import java.util.ArrayList;

/**Solution class creates the solution to the searchable object.*/

public class Solution 
{
	ArrayList<State> path;
	public Solution ()
	{
		this.path = new ArrayList<State>();
	}
	
	/** 
	 * Getting state and adding it to a list
	 * @param state
	*/
	
	public void addState(State s)
	{
		this.path.add(0,s);
	}
	
	/** 
	 * Printing the path
	*/
	public void Print()
	{
		for (int i = 0; i < path.size(); i++)
		System.out.println(this.path.get(i).getState());
	}
	
	public ArrayList<State> getPath() {
		return path;
	}
	public void setPath(ArrayList<State> path) {
		this.path = path;
	}
	
	
}
