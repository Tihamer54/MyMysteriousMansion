package adventure;  // The package is used to group together related classes.
                    /*
                     * It is a good idea to use packages to avoid name conflicts.
                     * I.e. two different things can have the same name as long as they are in different packages.
                     * E.g. one name (rock) could refer to a type of music in player package, while in an adventure game package, 
                     *      the same name could mean something you throw at a monster.
                     */


/**
 * <h1>How to print strings of characters to the console.</h1>
 *  
 *  There are three types of comments in Java: <br>
 *  <ol>
 *  <li> Documentation (this one), starts with a forward slash (/) followed by two asterisks (**). 
 *      Java has this cool feature (called Javadocs) that helps you document your code.
 *  <li> Multi-line comments that start with forward slash (/) followed by one asterisk (*).
 *  <li>Single-line comments that start with two forward slashes (//) 
 *  </ol>
 *  
 *  Note: Javadocs can be pure text, or they can use HTML (HyperText Markup Language), which is the language of the Internet.
 *  The less than and greater than characters represent HTML tags, which format the Javadoc comments.
 *  Otherwise they just get strung together.
 *  <p> If you are viewing this Eclipse (or a variant such as Red Hat JBoss Developer Studio), then hover your mouse over the ClassName.
 *  Change this Javadoc, save the file, and hover over it again.  Cool, eh?
 *  
 *  <p> Whenever you directly execute (or run) a Java class, by default (i.e. unless told otherwise in some complicated way you don't need to worry about)
 *  it is the "main" function that is run.
 */
public class RunGame00 {  // The start of a class (also called an object) is almost always: public class ClassName
	
	public static void main(String[] args) {
		// the "\n" means new line.  
		// Anything between two quotes is a string. The plus sign (+) means concatination when it is between two strings.
		System.out.println("Your ride (taxi/carriage/starship) drops you off on a dark road just as the sun is setting. \n" +
				"You see a white picket fence, overgrown with weeds, and long gravel driveway leading to a mysterious white mansion. \n"+
				"The wind whistles eerily through the bars of the gate, making you shiver. \n"+
				" All of a sudden, a black cat appears from a gap in between two slats of the picket fence. \n"+
				"It looks straight at you, and you feel like someone is walking over your grave. \n"+
				"You shiver again, but not from the cold.");
		/** 
		 * If you want to see output from a Java program, you can use the command "System.out.println".
		 * This command must be followed by an open parenthesis '(', a string, a closed parenthesis ')', and finally (like all java statements)
		 * a semicolon (;) to indicate the end of the statement. <br>
		 * A string is anything that is surrounded by double quotes (").
		 * What happens when you hover over "System"? Or "out"?  Or "println" (for print followed by a new line).
		 */
		// By convention, there are no spaces between each of the pieces of statements. 
		// Though sometimes, for long and complicated ones, it's a good idea.
		System.out.println("What would you like to do? (Choose a number or character, and then press Enter)");
		// When between two strings, the plus sign (+) means concatenate (glue together). 
		// Note the spaces on either side of the plus sign , which make it easier to read.
		System.out.println("1. " + "Walk bravely north towards the mansion.");  
		System.out.println("2. " + "Run west, screaming in terror, pleading at your driver to pick you back up.");
		System.out.println("3. " + "Woefully start trudging east, where you think you see the friendly lights of a city." );
	}

}
