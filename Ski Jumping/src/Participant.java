import java.util.*;

public class Participant implements Comparable <Participant> {

	private String name; 
	private int points;
	private List<Integer> jumpLengthsList;
	
	public Participant(String name) {
		
		this.name = name;
		this.points = 0;
		this.jumpLengthsList = new ArrayList<Integer>();
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public void increasePoints(int points) {
		
		this.points = this.points + points;
	}
	
	public void playerJumps(int jumpLength) {
		
		this.jumpLengthsList.add(jumpLength);
	}
	
	public int getPlayerJump(int address) {
		
		return this.jumpLengthsList.get(address);
	}
	
	public List <Integer> printPlayerJumps(){
		
		return this.jumpLengthsList;
	}
	
	public int getPlayerJumps() {
		
		int totalLength = 0; 
		
		for (Integer i : this.jumpLengthsList) {
			
			totalLength = totalLength + i;
		}
		return totalLength;
	}
	
/*	public void printPlayerLength() {
		
		System.out.println("Length : " + getPlayerJumps());
	} */
	
	public int getPoints() {
		
		return this.points;
	}
	
	public int compareTo(Participant other) {
		
		return this.getPoints() - other.getPoints();
	}
	
	public String toString() {
		
		return " Player : " +  this.getName() + " got " + this.getPoints() + " points";
	}
}