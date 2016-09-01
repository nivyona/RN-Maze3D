package algorithms.search;

import java.util.ArrayList;

/** DFS Search Algorithm.*/

public class DFS extends CommonSearcher
{
	private ArrayList<State> closedList;
	
	/** 
	 * DFS Search Algorithm
	 * @param searchable object 
	 * @return the solution of the problem
	*/
	
	@Override
	public Solution search(Searchable s) 
	{
		closedList = new ArrayList<State>();
		this.addToOpenList(s.getInitialState());
		State goal = s.getGoalState();
		State temp;
		while(this.getOpenList().size() > 0)
		{
			temp = this.popOpenList();
			if(!closedList.contains(temp))
			{
			closedList.add(temp);
			ArrayList<State> successors = s.getAllPossibleStates(temp);
			for(State state : successors)
				{
					if(!closedList.contains(state))
					{
						if(state.equals(goal))
						{
							state.setCameFrom(temp);
							return this.backTrace(s.getInitialState(),state);
						}
						else if(!this.getOpenList().contains(state))
						{
							state.setCameFrom(temp);
							this.addToOpenList(state);
						}
					}
				}
			}
		}
		return null;
	}
}
