import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class dp084e {
	static int kid1, kid2;
	static Scanner entry = new Scanner(System.in);
	static boolean game = true;	
	static double dist;
	static int grid = 50;
	
	public static void main (String[] args) {
		// Starting description
		System.out.println("You and your child are playing hide and seek in the forest.\n");
		
		while (game) {
			initialize();
			
			while (!(kid1 == 0 && kid2 == 0)) {
				move();
			};
			
			game = win();
		}
		System.exit(0);
	}
	
	private static void initialize() {
		Random rand = new Random();
		
		// Place the child
		System.out.println("You close your eyes and count to "+grid+" while your child dashes away from you.\n");
		
		do {
			kid1 = rand.nextInt(grid*2)-grid;
			kid2 = rand.nextInt(grid*2)-grid;
		}
		while (kid1+kid2 == 0);
		
		// Place the parent
		dist = Math.sqrt(kid1*kid1 + kid2*kid2);
		
		System.out.printf("Upon reaching "+grid+", you look around yourself. You are surrounded by a combination of deciduous and coniferous trees. You can't see very far through the greenery. Your child is not visible from where you are standing.\n\nYour parental sense says you are %1.3f meters from your child.\n\nTry \"north\", \"south\", \"east\", or \"west\".\n",dist);
	}
	
	private static void move() {
		System.out.print("> ");
		String input = entry.nextLine();
		char move = input.charAt(0);
		
		// Move response
		switch (move) {
			case 'n':
			case 'N':
				kid1++;
				System.out.println("You head one meter north.\n");
				break;
			case 's':
			case 'S':
				kid1--;
				System.out.println("You head one meter south.\n");
				break;
			case 'e':
			case 'E':
				kid2++;
				System.out.println("You head one meter east.\n");
				break;
			case 'w':
			case 'W':
				kid2--;
				System.out.println("You head one meter west.\n");
				break;
			default:
				System.out.println("You can't figure out how to go that way.\n\nTry \"north\", \"south\", \"east\", or \"west\".\n");
		}
		
		if (!(kid1 == 0 && kid2 == 0)) {
			dist = Math.sqrt(kid1*kid1 + kid2*kid2);
		
			System.out.printf("Your parental sense says you are %1.3f meters from your child.\n",dist);
		}
	}
	
	private static boolean win() {
		// Find response
		System.out.println("As you move into this section of the forest, you see your child!  You give them a quick hug.\n\nWould you like to play hide and seek again (yes or no)?\n");
		System.out.print("> ");
		String input = entry.nextLine();
		char again = input.charAt(0);
		
		if (again == 'y'||again == 'Y') {
			return true;
		}
		return false;
	}
}
