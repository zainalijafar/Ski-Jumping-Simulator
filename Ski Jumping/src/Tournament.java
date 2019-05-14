import java.util.*;
public class Tournament {
	
	private List<Participant> players; 
	private List<Integer> judges;
	private int counter;
	
	public Tournament() {
		
		this.players = new ArrayList<Participant>();
		this.counter = 0;
	}
	
	public void add(Participant player) {
		
		this.players.add(player);
	}
	
	public List<Participant> list() {
		
		return this.players;
	}
	
	public List<Participant> comparePoints(){
		
		Collections.sort(this.players);
		Collections.reverse(this.players);
		
		return this.players;
	}
	
	public int setLength() {
		
		Random rand = new Random();
		int jLength = rand.nextInt(60) + 60; 
		
		return jLength;
	}
	
	public void setJudgeResults() {
		
		this.judges = new ArrayList<Integer>();
		
		for (int i=0; i<5; i++) {
			
			Random rand = new Random();
			int jResults = rand.nextInt(10 + 1) + 10;
			this.judges.add(jResults);
		}
	}
	
	public List<Integer> getJudgeResults() {
		
		return this.judges;
	}
	
	public void setPlayerResults() {
		
		for (int i=0; i<this.players.size()-1; i++) {
			
			int length = setLength();
			this.players.get(i).playerJumps(length);
			this.players.get(i).increasePoints(length);
		}
	}
	
	public void getPlayerResults() {
		
		for (int i=0; i<this.players.size()-1; i++) {
			
			setJudgeResults();
			System.out.println(this.players.get(i).getName() + "\nlength : " + this.players.get(i).getPlayerJump(this.counter));
			System.out.println("judge votes : " + getJudgeResults());
			
			List<Integer> myList = new ArrayList<>();
			myList.addAll(getJudgeResults());
			
			Collections.sort(myList);
			myList.remove(0);
			myList.remove(myList.size()-1);
			
			int totalResults = 0;
			
			for (Integer j : myList) {
				
				totalResults = totalResults + j;
			}
			this.players.get(i).increasePoints(totalResults);
		}
		
		this.counter++;
	}
	
	public void printOrder() {
		
		for (int i=0; i<this.players.size(); i++) {
			
			if (!this.players.get(i).getName().equals("")) {
				
				System.out.println((i+1) + ". " + this.players.get(i).getName() + " (" + this.players.get(i).getPoints() + " points)");
			}
		}
	}
	
	public void printTournResults() {
		
		Collections.sort(this.players);
		Collections.reverse(this.players);
		
		for (int i=0; i<this.players.size(); i++) {
			
			if (!this.players.get(i).getName().equals("")) {
				
				System.out.println(this.players.get(i).getName() +  " got the " + (i+1) + "th" +  " position with " + this.players.get(i).getPoints() + " points");
				System.out.println("Number of jumps for player are : " +this.players.get(i).printPlayerJumps());
			}
		} 
	}
}