package adventure;

import java.util.Scanner;

/** <h1> What If? Else?</h1>
 * 
 *  The simplest form of an "if-then" statements is:
 * if (someCondition) { one or more statements; }
 * The more complete form of an "if-then" statements is:
 * if (someCondition) { one or more statements; } else { one or more other statements; }
 * Finally, you can have as many conditions as you want with "else if".
 * A condition is a variable, statement, or function that results in true or false.
 * (Try hovering over the "equals" in the term "response.equals" below).
 * @author ttoth-fejel
 *
 */
public class RunGame04 {
	
	public static void runGame() {
		String startLocation = "Your ride (taxi/carriage/starship) drops you off on a dark road just as the sun is setting. \n" +
				"You see a long gravel driveway leading to a mysterious white mansion.";

		String[] startQuestion = { "Walk bravely north towards the mansion. (1 or n or N)",
				"Run west, screaming in terror at your ride to pick you back up. (2 or w or W)",
				"Woefully start trudging east, where you think you see the friendly lights of a city. (3 or e or E)" };
		
		System.out.println(startLocation);
		String response = question(startQuestion);
		System.out.println("You have decided to: " + response);
		System.out.println("The condition (response.equals(\"1\")) is " + response.equals("1"));  // The double quote is "escaped" with a backward slash (\) to keep from ending the string.
		if (response.equals("1") || response.equals("N") || response.equals("n") ) {
			System.out.println("There is a low plastic gate blocking your path.");
		} else if (response.equals("2") || response.equals("W") || response.equals("w") ) {
			System.out.println("Your ride does not notice you and leaves you in the dust. It is darker now.");
		} else if (response.equals("3") || response.equals("E") || response.equals("e") ) {
			System.out.println("After an hour of walking, you realize that the light you saw was the moon rising. It is much darker now. And colder.");
		} else {
			System.out.println("You can't do that. You die.");
		}
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