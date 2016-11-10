package algorithms.search;

import java.util.Comparator;
import java.util.PriorityQueue;

/** Common Searcher is a  class for all the common methods for searching algorithms.
 * The class contains priority queue that represents the open list and the number of nodes that the algorithm evalutes.
*/

public abstract class CommonSearcher implements Searcher
{
	private int nodesEvaluated;
	private PriorityQueue<State> openList;

	
	public CommonSearcher ()
	{
		openList = new PriorityQueue<State>(comparator);
		this.nodesEvaluated = 0;
		
	}
	
	/** 
	 * Comparator for the Priority Queue
	 * @param state
	 * @param state to compare to
	 * @return the result
	*/
	public static Comparator<State> comparator = new Comparator<State>() 
		{	
			@Override
			public int compare(State o1, State o2) 
			{
				return (int)(o1.getCost() - o2.getCost());
			}
		};
	
	 public abstract Solution search(Searchable s);
	
	@Override
	public int getNumberOfNodesEvaluated() 
	{
		return this.getNodesEvaluated();
	}
	
	/** Adding state to the open list*/
	public void addToOpenList(State s)
	{
		this.openList.add(s);
	}
	/**  Remove the last state from the open list and increment the number of nodes evaluated*/
	public State popOpenList()
	{
		this.nodesEvaluated++;
		return this.openList.poll();
	}
	
	/** 
	 * Checking if the queue contains the state
	 * @param state
	 * @param queue
	 * @return the state if the queue contains it
	*/
	public State contains(State s, PriorityQueue<State> p)
	{
		State result = null;
		State[] states = new State[p.size()];
		// Copy the Open List to a temporary array
		for (int i = 0; i < states.length; i++)
		{
			states[i] = p.poll();
			if (states[i].equals(s))
				result =  states[i];
		}
		for (int i = 0; i < states.length; i++)
		{
			p.add(states[i]);
		}
		return result;
	}
	
	/** 
	 * Backtrace the path to the start point
	 * @param start positon
	 * @param goal positon
	 * @return the path fromt the goal positon to the start positon
	*/
	public Solution backTrace(State start , State goal)
	{
		Solution answer = new Solution();
		State temp = new State(goal);
		
		while (temp != null)
		{
			answer.addState(temp);
			temp = temp.getCameFrom();
		}			
		return answer;
	}
	
	
	public int getNodesEvaluated() {
		return nodesEvaluated;
	}

	public void setNodesEvaluated(int nodesEvaluated) {
		this.nodesEvaluated = nodesEvaluated;
	}

	public PriorityQueue<State> getOpenList() {
		return openList;
	}

	public void setOpenList(PriorityQueue<State> openList) {
		this.openList = openList;
	}
	

}
