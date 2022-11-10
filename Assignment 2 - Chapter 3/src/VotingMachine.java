
public class VotingMachine {
	//Member Variables
	private int _DemoVotes;
	private int _RepubVotes;
	
	//Constructors
	/**
	 * Creates a VotingMachine object with no Votes
	 */
	public VotingMachine()
	{
		_DemoVotes = 0;
		_RepubVotes = 0;
	}
	
	//Methods
	/**
	 * A function that clears the votes from both tallies
	 */
	public void clear()
	{
		_DemoVotes = 0;
		_RepubVotes = 0;
	}
	
	/**
	 * A function that adds one vote for Democrats
	 */
	public void voteBlue()
	{
		_DemoVotes++;
	}
	
	/**
	 * A function that adds one vote for Republicans
	 */
	public void voteRed()
	{
		_RepubVotes++;
	}
	
	/**
	 * A function that returns the saved amount of votes for Democrats
	 * @return Votes for Democrats
	 */
	public int getDemocratVotes()
	{
		return _DemoVotes;
	}
	
	/**
	 * A function that returns the saved amount of votes for Republicans
	 * @return Votes for Republicans
	 */
	public int getRepublicanVotes()
	{
		return _RepubVotes;
	}
	
	
	public String getWinner()
	{
		if(_DemoVotes > _RepubVotes)
		{
			return "Democrat";
		}
		else if(_RepubVotes > _DemoVotes)
		{
			return "Republican";
		}
		else
		{
			return "Tie";
		}
	}
}
