package adventure;

import java.util.Scanner;

/** <h1> How to input keyboard data with the Scanner class</h1>
 * 
 * <p>System is an object that automatically comes with every Java program.
 * With Scanner, however, you need to tell Java to import it.  That is what the import statement is above.
 * These import statements must be after the package statement, but before the class declaration.
 * 
 * <p> Note that 
 * 
 * @author ttoth-fejel
 *
 */
public class RunGame03 {
	
	public static void runGame() {
		String startLocation = "Your ride (taxi/carriage/starship) drops you off on a dark road just as the sun is setting. \n" +
				"You see a long gravel driveway leading to a mysterious white mansion.";

		String[] startQuestion = { "Walk bravely north towards the mansion. (1 or n or N)",
				"Run west, screaming in terror at your ride to pick you back up. (2 or w or W)",
				"Woefully start trudging east, where you think you see the friendly lights of a city. (3 or e or E)" };
		
		System.out.println(startLocation);
		String response = question(startQuestion);
		System.out.println("You have decided to: " + response);
	}
	
	public static String question(String[] options) {
		return question(options[0], options[1], options[2]);
	}
	
	public static String question(String option1, String option2, String option3) {
		Scanner input = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("1. " + option1);
		System.out.println("2. " + option2);
		System.out.println("3. " + option3);
		String response = input.next();   
		input.close();  // It is a good idea to close the input when you are done with it.
		return response;
	}

	public static void main(String[] args) {
		runGame();
	}
	
	
}
