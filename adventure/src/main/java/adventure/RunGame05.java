package adventure;

import java.util.Scanner;

/** <h1> Global variables</h1>
 * 
 *  If we make variables global, then any function can use them.
 *  We are trying to make the functions use any text; we don't want the text data to be "hard-coded"
 *  
 *  We can also simplify the main "if" statement by having the askQuestion function return an integer instead of a string.
 *  This gives the calling function the ability to describe the selection a little better.
 *  
 *  At this point, we only have on location, but we do get to make a choice.
 *  
 * @author ttoth-fejel
 *
 */
public class RunGame05 {
	
	public static String startLocation = "You see a long gravel driveway leading to a mysterious white mansion. \n"
			+ "The wind whistles eerily through the bars of the gate, making you shiver. \n"
			+ " All of a sudden, a black cat appears from a gap in between two slats of wood on a boarded up window. \n"
			+ "It looks straight at you, and you feel like someone is walking over your grave. \n"
			+ " You shiver again, but not from the cold.";

	public static String[] startQuestion = { "Walk bravely north towards the mansion. (1 or n or N)",
			"Run west, screaming in terror at your ride to pick you back up. (2 or w or W)",
			"Woefully start trudging east, where you think you see the friendly lights of a city. (3 or e or E)" };
	
	public static void runGame() {
		
		System.out.println(startLocation);
		Integer response = askQuestion(startQuestion);
		System.out.println("You have decided to: " + response + ". " + ((response>=4) ? "Choose an illegal response.  Are you trying to hack this game?" : startQuestion[response-1]));
		if (response==1) {
			System.out.println("There is a low plastic gate blocking your path.");
		} else if (response==2) {
			System.out.println("Your ride does not notice you and leaves you in the dust. It is darker now.");
		} else if (response==3) {
			System.out.println("After an hour of walking, you realize that the light you saw was only the moon rising. It is much darker now.");
		} else if (response==4) {
			System.out.println("You are a smarty pants, and have stepped into cold, wet mud, because you can't go in that direction. It is much darker now. And you have cold, wet feet.");
		} else {
			System.out.println("Nothing happens.");
		}
	}
	
	
	public static Integer askQuestion(String[] options) {
		return askQuestion(options[0], options[1], options[2]);
	}
	
	
	public static Integer askQuestion(String option1, String option2, String option3) {
		Scanner input = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("1. " + option1);
		System.out.println("2. " + option2);
		System.out.println("3. " + option3);
		String stringResponse = input.next();   
		input.close();  // It is a good idea to close the input when you are done with it.
		if (stringResponse.equals("1") || stringResponse.equals("N") || stringResponse.equals("n") ) {
			return 1;
		} else if (stringResponse.equals("2") || stringResponse.equals("W") || stringResponse.equals("w") ) {
			return 2;
		} else if (stringResponse.equals("3") || stringResponse.equals("E") || stringResponse.equals("e") ) {
			return 3;
		} else if (stringResponse.equals("4") || stringResponse.equals("S") || stringResponse.equals("s") ) {
			return 4;
		}else {
			System.out.println("Invalid response.");
			return 999;
		}
	}
	

	public static void main(String[] args) {
		runGame();
	}
	
}

