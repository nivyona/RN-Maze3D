package algorithms.search;

import java.util.ArrayList;

/** Serachable interface defins Searchable objects.*/

public interface Searchable
{
	State getInitialState();
	State getGoalState();
	ArrayList<State> getAllPossibleStates(State s);
}
