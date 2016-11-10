package algorithms.search;

import java.util.ArrayList;

/**BFS Search Algorithm.*/

public class BFS extends CommonSearcher
{
	/*
	 * ���� 1:
	 * �������� ��������� �� ����� ������ ������ ����� �� �� ������ ������ ���� ��. 
	 * BFS:
	 * ����� ���� ���� �� ��' ������ ����� ���' ������ ���� ������ ��. ����� ���������� �� ����� ����� ���� ��� �� �� ��' ������. 
	 * DFS:
	 * ����� ���� ���' ������ ����� ����� �� ������ ���� ���� ���� ������ ��������� ��� ����� ���� ���� �����.
	 * 
	 * ����� ������ �������� ������ ���������� ������ ����� ���� ���� ����� ���������� ������ �����
	 * ���� 2: ������ �� ������ ������� ����� ������� ������� ��� �� �������
	 */
	
	
	/** 
	 * BFS Search Algorithm
	 * @param searchable object 
	 * @return the solution of the problem
	*/
	
	private ArrayList<State> closedList;
	
	@Override
	public Solution search(Searchable s) 
	{
		  addToOpenList(s.getInitialState());
		  closedList=new ArrayList<State>();

		  while(this.getOpenList().size()>0)
		  {
		    State n=popOpenList();// dequeue
		    closedList.add(n);

		    if(n.equals(s.getGoalState())) // checking if arrive to the goal state
		      return backTrace(s.getInitialState(),n); 

		    ArrayList<State> successors=s.getAllPossibleStates(n); // list of the successors
		    for(State state : successors)
		    {
		      if(!closedList.contains(state))
    		  {  	  
		    	if(this.getOpenList().contains(state))
			      { //checking if this path is better
		    		if((state.getCost() + n.getCost()) < this.contains(state, this.getOpenList()).getCost())
					{
						this.getOpenList().remove(state);
						state.setCameFrom(n);
						state.setCost(state.getCost() + n.getCost());
						this.addToOpenList(state);
					}
			      }
			      else
			      {
			    	state.setCameFrom(n);
			 		this.addToOpenList(state);
			      }
    		  }
		    }
		  }
		return null;
	}
	
}
