package tournament;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BracketImpl_Flores<P> extends BracketAbstract<P>
{
	public BracketImpl_Flores(List<P> participantMatchups)
	{
		super(participantMatchups);
	}
	
	@Override
	public int getMaxLevel()
	{
		int predictionsPlus1 = predictions.size() + 1;
		int result = (int)(Math.log(predictionsPlus1) / Math.log(2)) - 1;
		return result;
	}

	@Override
	public Set<Set<P>> getGroupings(int level)
	{
		assert level <= getMaxLevel() && level >= 0;

		Set<Set<P>> groupingSet = new HashSet<>();
		Set<P> subSetGroup = new HashSet<>();
		
		int totalNumberOfParticipants = (predictions.size() + 1) / 2;
		int numberOfParticipantsInEachSubSet = (int) Math.pow(2, level);
		int subSetSizeCounter = 0;
		
		
		for (int i = predictions.size() - 1; i > totalNumberOfParticipants - 2; i--) {
			
			if (subSetSizeCounter < numberOfParticipantsInEachSubSet) {
				subSetGroup.add(predictions.get(i));
				subSetSizeCounter += 1;
			}
			
			if (subSetSizeCounter == numberOfParticipantsInEachSubSet) {
				Set<P> subSetGroup3 = new HashSet<>();
				subSetGroup3.addAll(subSetGroup);
				groupingSet.add(subSetGroup3);
				subSetSizeCounter = 0;
				subSetGroup.clear();
			}
				
		}
		
		if (groupingSet.contains(null) || groupingSet == null) {
			assert false;
		}
		
		return groupingSet;
	}
	
	
	
	
	
	
	
	

	@Override
	public Set<P> getViableParticipants(Set<P> grouping)
	{
		assert grouping != null;
		assert predictions.containsAll(grouping);
		assert getAllPossibleGroupings().contains(grouping);
		assert isNoSkipedNodes(grouping);

		
		
		int groupingSize = grouping.size();
		int totalNumberOfParticipants = getTotalNumberOfParticipants();
		int smallestIdxInGrouping = -1;
//		int largestIdx = -1; // the index in predictions list
		int numberOfLevelsingroupingSize = (int)(Math.log(groupingSize) / Math.log(2));
		Set<P> viableParticipants = new HashSet<P>();
		
		smallestIdxInGrouping = getSmallestIdxInGrouping(totalNumberOfParticipants, grouping);
//		largestIdx = smallestIdxInGrouping / groupingSize;
		
		List<Integer> indexList = new ArrayList<>();
		for (int i = 0; i < groupingSize; i++) {
			indexList.add(smallestIdxInGrouping + i);
		}
		
		
		
		for (int k = 0; k < indexList.size(); k++) {
			int currIdx = smallestIdxInGrouping + k;
			int currLevelOneIdx = smallestIdxInGrouping + k;
			int checks = 0;
			
			
			for(int r = 0; r < numberOfLevelsingroupingSize; r++) {
				
				currIdx = getParentIndex(currIdx);
				
				if (predictions.get(currIdx) == predictions.get(currLevelOneIdx) || predictions.get(currIdx) == null) {
					checks += 1;
				}
				
			}
			
			if (checks == numberOfLevelsingroupingSize) {
				viableParticipants.add(predictions.get(currLevelOneIdx));
			}
			
		}
		
		
		
		
		return viableParticipants;
		
		
		
	}
	
	@Override
	public void setWinCount(P participant, int winCount)
	{
		
		assert participant != null; // if participant == null -> assert
		assert winCount <= getMaxLevel() && winCount >= 0;
		assert predictions.contains(participant); // if predictions does not contain participant -> assert
		

		int idxOfParticipant = -1;

		
		
		idxOfParticipant = getParticipantIndex(participant); // finds index of participant
		int targetIdx = idxOfParticipant;
		
		for (int i = 0; i < winCount; i++) {
			targetIdx = getParentIndex(targetIdx);
		}
		

		int currIdx = idxOfParticipant;
		
		
		boolean condition = true;
		int count = 0;
		while(condition) {
			
			int parentIdx = getParentIndex(currIdx);
			if (parentIdx == 0) {condition = false;}
			
			predictions.set(parentIdx, participant);
			currIdx = parentIdx;
			count += 1;
			if (count == winCount) {condition = false;}
			
		}
		
		
		checkTargetIdxEqualsParent(targetIdx);
		checkAllIndexes();
		
	}
	
	public void checkTargetIdxEqualsParent(int targetIdx) {
		
		if (targetIdx == 0) {
			
		}
		
		else if (predictions.get(targetIdx) == predictions.get(getParentIndex(targetIdx)) && predictions.get(getParentIndex(targetIdx)) != null) {
			predictions.set(getParentIndex(targetIdx), null);
		}
		
	}
	
	
	
	
	
	
	
	public boolean equals(Object bracket2) { // test equals more
		
		
		Set<Set<P>> set1 = new HashSet<>();
		Set<Set<P>> set2 = new HashSet<>();
		
		
		
		BracketImpl_Flores<P> a = (BracketImpl_Flores<P>) bracket2;
		
		if (this == null || a == null) {
			return false;
		}
		
		if (this.getMaxLevel() != a.getMaxLevel()) {
			return false;
		}
		
		if (this.predictions.size() != a.predictions.size()) {
			return false;
		}
		
		int nodesInLevel = 1;
		int nodeNumberInLevel = 0;
		for (int i = 0; i < this.predictions.size(); i++) {
			Set<P> subSet1 = new HashSet<>();
			Set<P> subSet2 = new HashSet<>();
			
			subSet1.add(this.predictions.get(i));
			subSet2.add(a.predictions.get(i));
			
			if (nodeNumberInLevel == nodesInLevel - 1) {
				set1.add(subSet1);
				set2.add(subSet2);
				nodesInLevel = (int) Math.pow(2, nodesInLevel);
			}
			
			
		}
		
		
		if (set1.equals(set2)) {
			return true;
		}
		return false;
		
	}
	
	
	
	public Set<Set<P>> getAllPossibleGroupings(){
		
		Set<Set<P>> b = new HashSet<>();
		
		for (int i = 0; i <= getMaxLevel(); i++) {
			
			Iterator<Set<P>> it = getGroupings(i).iterator();
			
			while(it.hasNext()) {
				b.add(it.next());
			}
			
		}
		return b;
		
	}
	
	
	
	
	
	public boolean isNoSkipedNodes(Set<P> grouping) {
		int groupingSize = grouping.size();
		int totalNumberOfParticipants = getTotalNumberOfParticipants();
		int smallestIdxInGrouping = getSmallestIdxInGrouping(totalNumberOfParticipants, grouping);
		
		for(int i = 0; i < groupingSize; i++) {
			if(!grouping.contains(predictions.get(smallestIdxInGrouping + i))) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	

	
	private int getParticipantIndex(P participant)
	{
		int idxOfParticipant = -1;
		int totalNumberOfParticipants = getTotalNumberOfParticipants();
		for (int i = totalNumberOfParticipants - 1; i <= predictions.size() - 1; i++) {if (predictions.get(i) == participant) {idxOfParticipant = i;}}
		return idxOfParticipant;
	}
	
	private static int getParentIndex(int childIndex)
	{
		int parentIdx = 0;
		
		if (childIndex % 2 == 0) {parentIdx = (childIndex / 2) - 1;}
		else if (childIndex % 2 == 1) {parentIdx = childIndex / 2;}
		return parentIdx;
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getTotalNumberOfParticipants() {
		int totalNumberOfParticipants = (predictions.size() + 1) / 2;
		return totalNumberOfParticipants;
	}
	
	public Set<P>getSetOfParticipants() {
		Set<P> set1 = new HashSet<P>();
		for (int i = predictions.size() - 1; i >= getTotalNumberOfParticipants() - 1; i--) {
			set1.add(predictions.get(i));
		}
		return set1;
	}
	
	public int getSmallestIdxInGrouping(int totalNumberOfParticipants, Set<P> grouping) {
		int smallestIdxInGrouping = -1;
		int groupingSize = grouping.size();
		for (int i = predictions.size() - 1; i > totalNumberOfParticipants - 2; i--) {
			if (grouping.contains(predictions.get(i))) {
				smallestIdxInGrouping = i - (groupingSize - 1);
				i = -1;
			}
		}
		return smallestIdxInGrouping;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getOddChildIdx(int parentIdx) {
		int oddChildIdx = parentIdx * 2 + 1;
		return oddChildIdx;
	}
	public int getEvenChildIdx(int parentIdx) {
		int evenChildIdx = parentIdx * 2 + 2;
		return evenChildIdx;
	}
	
	public void checkAllIndexes() {
		
		int allLevelsExcept0 = (predictions.size() - 2) / 2;
		
		for (int i = (predictions.size() - 1) / 2 - 1; i >= 0; i--) {
			
			if (predictions.get(i) != predictions.get(getEvenChildIdx(i)) && predictions.get(i) != predictions.get(getOddChildIdx(i))) {
				predictions.set(i, null);
			}
			
		}
		
		
	}
	

	
	public String printBracket() {
		
		int newLineIndicator = 1;
		int currElem = 0;
		int numOfShifts = getMaxLevel();
		
		String bracket = "";
		for (int k = 0; k < numOfShifts; k++) {
			bracket += "       ";
		}
		for (int i = 0; i < predictions.size(); i++) {
			
			bracket += predictions.get(i) + "     ";
			currElem += 1;
			if (currElem >= newLineIndicator) {
				bracket += "\n" + "\n";
				currElem = 0;
				newLineIndicator *= 2;
				numOfShifts -= 1;
				for (int k = 0; k < numOfShifts; k++) {
					bracket += "         ";
				}
			}
			
		}
		return bracket;
	}
	
	
	
	public List<P> getPredictions(){
		return predictions;
	}
	
	
public FIFASoccerTeam getWinner() {										
	return (FIFASoccerTeam) predictions.get(0);
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
