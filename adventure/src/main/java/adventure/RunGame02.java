package adventure;

/*
 * <h1>How to create definitions of functions (also called methods or subroutines), and then call them</h1>
 * <p> A function (also called method or subroutine) is a block of code which only runs when it is called. 
 * <p> It must be defined inside a class. Often, they include input parameters. Also, they can return values.
 * Note: it doesn't matter what order you define your functions.
 */
public class RunGame02 {
	
	public static void runGame() {
		String startLocation = "Your ride (Lyft/carriage/starship) drops you off on a dark road just as the sun is setting. \n" +
				"You see a long gravel driveway leading to a mysterious white mansion.";

		String[] startQuestion = { "Walk bravely north towards the mansion. (1 or n or N)",
				"Run west, screaming in terror at your ride to pick you back up. (2 or w or W)",
				"Woefully start trudging east, where you think you see the friendly lights of a city. (3 or e or E)" };

		System.out.println(startLocation);
		
		System.out.println("What would you like to do?");
		System.out.println("1. " + startQuestion[0]);    // When you have two strings, the plus sign (+) means concatenate (glue together).
		System.out.println("2. " + startQuestion[1]);
		System.out.println("3. " + startQuestion[2]);
	}
	
	
	public static void question(String[] options) {
		askQuestion(options[0], options[1], options[2]);
	}
	
	public static void askQuestion(String option1, String option2, String option3) {
		System.out.println("What would you like to do?");
		System.out.println("1. " + option1);
		System.out.println("2. " + option2);
		System.out.println("3. " + option3);
	}
	
	
	public static void main(String[] args) {
		runGame();
	}

}
