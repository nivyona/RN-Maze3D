package algorithms.search;

/**Search in object.
 * @param Getting Searchable object.*/

public interface Searcher 
{
	   // the search method
		/** Searching in searchable object*/
	   public Solution search(Searchable s);
	   // get how many nodes were evaluated by the algorithm
		/** Getting the number of nodes evaluted*/
	   public int getNumberOfNodesEvaluated();
}
