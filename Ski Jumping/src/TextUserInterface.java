import java.util.Scanner;
public class TextUserInterface {
	
	private Scanner reader; 
	private Tournament tourn;
	
	public TextUserInterface() {
		
		this.reader = new Scanner(System.in);
		System.out.println("Kumpula Ski jumping week");
		this.tourn = new Tournament();
	}
	
	public void start() {
		
		System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
		
		while (true) {
			
			String input = userInput();
			
			if (input.equals("")) {
				
				break;
			}
		}
		System.out.println("The tournament begins !");
		userSelection();
	}
	
	public String userInput() {
		
		System.out.println("Participant name : ");
		String name = this.reader.nextLine();
		Participant participant = new Participant(name);
		this.tourn.add(participant);
		return name;
	}
	
	public String userNextInput() {
		
		System.out.println("Write jump to jump; otherwise you quit:");
		String userInput = this.reader.nextLine();
		
		return userInput;
	}
	
	public void userSelection() {
		
		while (true) {
			
			if (userNextInput().equals("jump")) {
				
				System.out.println("Jumping order:");
				this.tourn.printOrder();
				round();
				roundResults();
				
			}else if (userNextInput().equals("quit")){
				
				tournResults();
				break;
				
			}else {
				
				System.out.println("Enter a valid input");
			}
		}
	}
	
	public void round() {
		
		this.tourn.setPlayerResults();
	}
	
	public void roundResults() {
		
		System.out.println("Results of Round : ");
		this.tourn.getPlayerResults();
		this.tourn.printOrder();
	}
	
	public void tournResults() {
		
		this.tourn.printTournResults();
	}
}