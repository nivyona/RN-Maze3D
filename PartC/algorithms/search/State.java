package algorithms.search;

/**State class creas state in the Searchable object.*/

public class State 
{
    private String state;    // the state represented by a string
    private double cost;     // cost to reach this state
    private State cameFrom;  // the state we came from to this state

    public State(String state)
    {
    	this.state = state;
    }

    /** 
     * Copy Constructor
    */
    
    public State(State s) 
    {
		this.state = s.getState();
		this.cost = s.getCost();
		this.cameFrom = s.getCameFrom();
	}

    /** 
     * Checking if 2 states is eqaul
    */
    
	public boolean equals(State s){ 
        return state.equals(s.state);
    }
    
    @Override
	public boolean equals(Object o)
	{
		return this.equals(((State)o));
	}

	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public State getCameFrom() {
		return cameFrom;
	}


	public void setCameFrom(State cameFrom) {
		this.cameFrom = cameFrom;
	} 

}
