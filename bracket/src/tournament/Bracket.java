package tournament;

import java.util.Set;

public interface Bracket<P>
{

	public int getMaxLevel();
	
	public Set<Set<P>> getGroupings(int level);
	
	public Set<P> getViableParticipants(Set<P> grouping);
	
	public void setWinCount(P participant, int winCount);
}