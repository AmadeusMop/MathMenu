import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int choice;
		System.out.println("Some introductory text here.");
		while(true) {
			do {
				System.out.println("Some explanatory menu text here.");
				choice = menuChoice(console);
				System.out.println("The number entered was: " + choice);
			} while(choice != 0);
			System.out.print("Are you sure you wish to exit? (y/n):");
			if(console.next().toLowerCase().charAt(0) == 'y') break;
		}
	}
	
	public static int menuChoice(Scanner console) {
		int choice = 0;
		String input = "";
		boolean c = true;
		while(c) {
			try {
				c = false; //There's probably an easier way to achieve this. I don't remember any. I'm rather sick right now.
				System.out.print("Enter your choice (0, 1, 2): ");
				input = console.next();
				choice = Integer.parseInt(input);
				if(choice < 0 || choice > 2) throw new IllegalArgumentException();
			} catch (NumberFormatException e) {
				System.out.println("The input must be a number.");
				System.out.println("\"" + input + "\" is not a number.");
				c = true;
			} catch (IllegalArgumentException e) {
				System.out.println("The number entered must be 0, 1 or 2.");
				System.out.println("You entered: " + choice);
				c = true;
			}
		}
		return choice;
	}
	
	public static int multiply(int a, int b) {
		if(a < 0) {
			return -multiply(-a, b);
		} else if(b < 0) {
			return -multiply(a, -b);	
		} else {
			int output = 0;
			for(int i = 0; i < b; i++) {
				output += a;
			}
			return output;
		}
	}
	
	public static int exponent(int a, int b) {
		if(b == 0) {
			return 1;
		} else {
			return a*exponent(a, b-1); //It was probably intended for me to use my multiply() method here.
									   //BUT THE SPEC DIDN'T SAY THAT AND IT'S EASIER THIS WAY
		}
	}
}
