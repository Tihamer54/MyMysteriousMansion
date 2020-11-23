package adventure;

/**
 * <H1> How local variables can store strings and arrays. </H2>
 * BTW (by the way), you may notice that HTML tags can be upper or lower case. H1 means "Heading 1", and so does h1.<br>
 * 
 * <p>A variable is like a box that holds a value. Every variable has a data type, such as String, Integer, Decimal, or even just Object. 
 * <p>Arrays re like a shelf with lots of boxes of the same data type. An array lets us store multiple values in a single variable, 
 *    To declare an array, define the data type with square brackets '[' and ']'. 
 *    
 * <h2>  Why would you want to use variables? </h2>
 * Because you might want to use it again.
 * For example, in a text adventure game, you might end up at the same place again.
 * As the game developer, do you really want to type the same description all over again? <br>
 * <br>
 * I didn't think so.
 */
public class RunGame01 {
	
	public static void main(String[] args) {
	
		/** All variables are declared in the format: Datatype variableName = theValue; */
		String startLocation = "Your ride (Lyft/carriage/starship) drops you off on a dark road just as the sun is setting. \n" +
				"You see a long gravel driveway leading to a mysterious white mansion.";
		
		/** All array variables (arrays for short) are declared in the format: Datatype[] arrayVariableName = { firstValue, secondValue, etc }; */
		String[] startQuestion = { "Walk bravely north towards the mansion.",
				"Run west, screaming in terror at your ride to pick you back up.",
				"Woefully start trudging east, where you think you see the friendly lights of a city." };

		System.out.println(startLocation);
		
		System.out.println("What would you like to do?");
		System.out.println("1. " + startQuestion[0]);    
		System.out.println("2. " + startQuestion[1]); 
		System.out.println("3. " + startQuestion[2]);  
	}

}
