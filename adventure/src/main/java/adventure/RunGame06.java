package adventure;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/** <h1> A Data Class and Functions that call functions</h1>
 * 
 * We add a simple data object (called OptionResult06) that specifies two things:
 *  1. A result that happens when you pick that option, and 
 *  2. the new location that decision will put you.
 *  
 *  Also, because of problems in how the scanner works when used repeatedly (like in a loop), we made it a global variable, and reused it each time.
 * 
 *  If we make functions call other functions, then we can generalize them. 
 *  This lets us concentrate on the more important text data.
 *  You will notice that now we have more data than code. And we only have five nodes.
 *  This way we can concentrate on building a game instead of writing software.
 *  
 *  Note that this game is far for finished, for there is no data for the FrontDoor location.  
 *  That is left as an exercise for the reader. You can add as many nodes as possible.
 *  Though it might be a good idea to model the location as a separate class first.
 *  
 *  Alternatively we could improve some other aspects of game play: for example, we could:
 *  1. Model the player, and give him or her the ability to collect items, and have health go up and down.
 *  2. Model the location (from the triplets below, it's pretty obvious how to do that). 
 *      We could also add an "other objects" array of things that we could pick up or drop at locations.
 *  3. Model time and events. This would make it possible to have the grandfather clock in the living room chime after every twenty moves. 
 *  	Or have a deadline. (If you don't defeat the fire ghost by midnight, and if you haven't fixed the gas leak in the kitchen, the house blows up and you die).
 *  4. Model agents that wander around and interact with the player.
 *  
 * @author ttoth-fejel
 *
 */
public class RunGame06 {
	
	public static String currentLocation = "Start";
	static Scanner input = new Scanner(System.in);
	
	//////////////////
	public static String startDescription = "You see a long gravel driveway, leading to a mysterious white mansion. \n"
			+ "There are high bushes on both sides of the driveway, and the wind whistles eerily through them, making you shiver. \n"
			+ "The windows of the mansion are boarded up, except for two on the upper floors, which makes you feel like the house is watching you. \n"
			+ "The front door looks like it is ajar. Or maybe half-broken.";
	public static String[] startOptions= { "Walk bravely north towards the mansion. (1 or n or N)",
			"Run west, screaming at your ride to pick you back up. (2 or w or W)",
			"Woefully start trudging east, where you think you see the friendly lights of a city. (3 or e or E)"};
	public static OptionResult06[] startResults = { new OptionResult06("There is a low plastic gate blocking your path. It is locked by rusty chains.", "Gate"),
			new OptionResult06("Your ride does not notice you and leaves you in the dust. It is darker now.",  "WestRoad"),
			new OptionResult06("After an hour of walking, you realize that the light you saw was only the moon rising. It is much darker now.", "EastRoad"),
			new OptionResult06("You are a smarty pants, and have stepped into cold, wet mud, because you can't go in that direction. \n"
					+ "It is much darker now. And you have cold, wet feet. And you just got bit by a water moccasin. You die", "Grave")};
	////////////////////
	
	public static String gateDescription = "The long gravel driveway continues to the front door of the mysterious white mansion. \n"
			+ "The wind whistles eerily through the bars of the gate, making you shiver. \n"
			+ "All of a sudden, a black cat appears from a gap in in the gate. \n"
			+ "It looks straight at you, and you feel like someone is walking over your grave. \n"
			+ "You shiver again, but not from the cold.";
	public static String[] gateOptions= { "Pull at the chains that are locking the gate. (1 or n or N)",
			"Walk west into the bushes, looking for another way in. (2 or w or W)",
			"Walk east into the bushes, looking for another way in. (3 or e or E)",
			"Go south to the road, and pull out your smartphone. If Uber picked you up from the middle of a zombie apocalypse, maybe they can get you out of this, too. (4 or s or S)" };
	public static OptionResult06[] gateResults = { new OptionResult06("The chains break, so you walk carefully north towards the mansion's front door. ", "FrontDoor"),  // TODO
			new OptionResult06("You get scratched by really nasty thorns, and don't get anywhere. Now you are cold and bleeding.",  "Gate"),
			new OptionResult06("You are blocked by really nasty thorns and get nowhere. Now you are cold and bleeding.", "Gate"),
			new OptionResult06("You phone battery is dead. You are back where you started. Only it is darker now, and you are colder. \n"
					+ "Also, you see dark shapes moving on the road, both to the east and to the west. Are they wolves or bears?", "Start")};
	/////////////////
	
	public static String eastRoadDescription = "You see a long, empty road to the east, from where you fled the zombie apocalypse many days ago. \n"
			+ "To the west, where you ride disappeared, the road disappears into the dark. The rising moon just makes the shadows darker. \n"
			+ "The wind whistles eerily through the imposing trees that crowd the road in both directions. \n"
			+ "You are surrounded by the deep, dark woods that your parents warned you about in the Hansel and Gretel fairy tale. \nExcept those were only stories. This is real.\n"
			+ "You hear the howling of some strange animal. Probably not a hungry wolf. Wolves hunt silently, right? \n"
			+ "That doesn't make you feel any better. You listen closely, but you don't hear any more animal noises. Maybe you heard a rustle.";
	public static String[] eastRoadOptions= { "Walk bravely north into the deep dark woods, trusting to your cub scout camping skills. (1 or n or N)",
			"Hurry west, wishing that you had not been fooled by the moon. (2 or w or W)",
			"Keep trudging east, hoping to find shelter in some abandoned house or barn. (3 or e or E)",
			"Walk bravely south into the deep dark woods, trusting to your cub scout camping skills. (4 or s or S)"};
	public static OptionResult06[] eastRoadResults = { new OptionResult06("After bumping into some trees in the darkness, you get disoriented. \n"
			+ "Then you are attacked by wolves, and they eat you. You die.", "Grave"),
			new OptionResult06("You eventually make it back to the starting point.", "Start"),
			new OptionResult06("The wolves eventually find you on the road. Fortunately, you see them and climb a tree. Unfortunately, the tree is full of poisonous snakes, who bite you. You die.", "Grave"),
			new OptionResult06("After bumping into some trees in the darkness, you get disoriented. \n" +
					"You fall into a deep lake. Fortunately, you know how to swim. Unfortunately, crocodiles swim better than you do, and they eat you. You die.", "Grave")};
	
	///////////////////
	public static String westRoadDescription = "You see a long, empty road to the west, where you ride disappeared into the dark. \n"
			+ "To the east, the road also disappears into the dark, though you know that the mysterious mansion is there. The moon rising, but it just makes the shadows darker. \n"
			+ "The wind whistles eerily through the imposing trees that crowd the road in both directions. \n"
			+ "You are surrounded by the deep, dark woods that your parents warned you about in the Goldilocks fairy tale. \nExcept those were only stories. This is real.\n"
			+ "You hear a faint rustling, followed by a low growl. Is it lions or tigers or bears? Oh my! \n"
			+ "Unfortunately, you are not on the yellow brick road, and knowing that doesn't make you feel any better.";
	public static String[] westRoadOptions= { "Walk bravely north into the deep dark woods, trusting to your cub scout camping skills. (1 or n or N)",
			"Keep trudging west, hoping to find shelter in some abandoned castle. (2 or w or W)",
			"Hurry east back towards the mansion, wishing that you had not gotten out of your ride. (3 or e or E)",
			"Walk bravely south into the deep dark woods, trusting to your cub scout camping skills. (4 or s or S)"};
	public static OptionResult06[] westRoadResults = { new OptionResult06("After bumping into some trees in the darkness, you get disoriented. \n"
			+ "Then you are attacked by bears, and they eat you. You die.", "Grave"),
			new OptionResult06("The bears eventually find you on the road. Fortunately, you see them and climb a tree. \n"
					+ "Unfortunately, the tree is full of flying monkeys, who take you to the wicked witch of the West who turns you into a bug and steps on you. You die.", "Grave"),
			new OptionResult06("You eventually make it back to the mysterious mansion.", "Start"),
			new OptionResult06("After bumping into some trees in the darkness, you get disoriented. \n" +
					"You fall into a deep cave. Fortunately, you brought a flashlight. Unfortunately, that helps the orcs see where you are, and they eat you. You die.", "Grave")};

	//////////////////
	public static String graveDescription = "You are dead. A long way off, you see a light, and you try to go towards it, because it is awesomely beautiful. \n"
			+ "You are aware of darkness too-- \n It is a palatable darkness that painfully reeks of the absence of love and truth. If fills you full of terror. \n"
			+ "You strive towards the light, but you have no legs. Or arms. or anything. You are confused. \n"
			+ "You are like a leaf being bandied about by the wind. \n"
			+ "The wind consists of the choices you made in your life. \n"
			+ "Your life is in judgement. Will you end up in the darkness or the light?\n"
			+ "You no longer have any options.";
	public static String[] graveOptions= { "" };
	public static OptionResult06[] graveResults = { new OptionResult06("", "") };
	
	
	public static void runGame() {
		currentLocation = "Start";
		while (true) {
			if (currentLocation.equals("Start")) {
				runLocation("Start", startDescription, startOptions, startResults);
			} else if  (currentLocation.equals("Gate")) {
				runLocation("Gate", gateDescription, gateOptions, gateResults);
			} else if  (currentLocation.equals("EastRoad")) {
				runLocation("EastRoad", eastRoadDescription, eastRoadOptions, eastRoadResults);
			} else if  (currentLocation.equals("WestRoad")) {
				runLocation("WestRoad", westRoadDescription, westRoadOptions, westRoadResults);
			} else if (currentLocation.equals("Grave")) {
				runLocation("Grave", graveDescription, graveOptions, graveResults);
				System.exit(0);
				break;
			} else {
				System.out.println("Sorry, something has gone horribly wrong. Current Location is: " + currentLocation);
				break;
			}
		}
		input.close();  // It is a good idea to close the input when you are done with it.
		System.out.println("Game Over. Thanks for playing!");
	}
	
	
	public static void runLocation(String locationName, String description, String[] options, OptionResult06[] results) {
		System.out.println(description);
		Integer response = askQuestion(options);
		//System.out.println("runLocation=" + locationName + " description=" + description + " options=" + options + " results=" + results);
		//System.out.println("runLocation=" + locationName + " description=" + description + " options=" + Arrays.toString(options) + " results=" + Arrays.toString(results));
		System.out.println("You have decided to: " + response + ". " + 
				((response > options.length || response < 0) ? "This is an illegal response.  Are you trying to hack this game?" : options[response-1]));
		
		if (response > results.length || response < 0) {
			currentLocation = "End";
			System.out.println("Your game designer may have messed up, and has only given you : " + results.length + " possible results at location " + currentLocation + "."); 
		} else {
			currentLocation = results[response-1].nextLocation;
		}
		if (response==1) {
			System.out.println(results[response-1].result);
		} else if (response==2) {
			System.out.println(results[response-1].result);
		} else if (response==3) {
			System.out.println(results[response-1].result);
		} else if (response==4) {
			System.out.println(results[response-1].result);
		} else {
			System.out.println("Nothing happens.");
		}
	}
	
	
	public static Integer askQuestion(String[] options) {
		//System.out.println("askQuestion: size=" + options.length + " data=" + Arrays.toString(options) + " " + options);
		switch (options.length) {
		case 1:
			if (StringUtils.isEmpty(options[0])) {
				System.out.println("I am sorry, but I can't do that. You have no options.");
				return -1;
			}
			return askQuestion(options[0], null, null, null);
		case 2:
			return askQuestion(options[0], options[1], null, null);
		case 3:
			return askQuestion(options[0], options[1], options[2], null);
		case 4:
			return askQuestion(options[0], options[1], options[2], options[3]);
		default:
			System.out.println("Sorry.  Apparently you have are in a location in which you have no options.");
		}
		return -1;
	}
	
	
	public static Integer askQuestion(String option1, String option2, String option3, String option4) {
		System.out.println("What would you like to do?");
		if (!StringUtils.isEmpty(option1)) { System.out.println("1. " + option1); }
		if (!StringUtils.isEmpty(option2)) { System.out.println("2. " + option2); }
		if (!StringUtils.isEmpty(option3)) { System.out.println("3. " + option3); }
		if (!StringUtils.isEmpty(option4)) { System.out.println("4. " + option4); }
		String stringResponse = input.next();   
		input.reset();
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
			return -999;
		}
	}
	

	public static void main(String[] args) {
		runGame();
	}
	
}

