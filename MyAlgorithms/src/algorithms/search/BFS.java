package algorithms.search;

import java.util.ArrayList;

/**BFS Search Algorithm.*/

public class BFS extends CommonSearcher
{
	/*
	 * שאלה 1:
	 * היתרונות והחסרונות של שיטות החיפוש תלויות במבנה של מה שאנחנו הולכים לחפש בו. 
	 * BFS:
	 * במקרה שנדע מראש אם נק' היציאה קרובה לנק' הכניסה עדיף להשתמש בו. כיוון שהאלגוריתם רץ לרוחב ונגיע יותר מהר כך אל נק' היציאה. 
	 * DFS:
	 * במקרה שנדע שנק' היציאה נמצאת בעומק או שהמבוך עמוק מאוד עדיף להשתמש באלגוריתם הזה כיוון שהוא נכנס לעומק.
	 * 
	 * בנוסף מקריאה באינטרנט גיליתי שהאלגוריתם לחיפוש בעומק צורך פחות זכרון מהאלגוריתם לחיפוש לרוחב
	 * שאלה 2: המשכתי את המימוש שקיבלנו במצגת ונעזרתי בפסאודו קוד של ויקפדיה
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
