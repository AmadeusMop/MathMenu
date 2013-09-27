import java.util.Scanner;

/*
 * DISCLAIMER:
 * THE FOLLOWING CODE WAS WRITTEN WHILE I WAS SICK.
 * 
 * DO NOT TAKE THE FOLLOWING CODE AS REFLECTIVE 
 * OF MY PROGRAMMING SKILLS AS A WHOLE.
 * 
 * THANK YOU.
 * 
 * -Cillian
 */


public class Main {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String exitInput;
		boolean loop = true;
		int choice, num = 0;
		int[] input;
		System.out.println("Eh, something goes here. I'll get to it later. Probably.\n");
		System.out.println("This should be explanatory menu text, I think?");
		System.out.println("I don't know. UI design isn't my strong suit.");
		
		while(loop) {
			do {
				System.out.println("Your options: 0 = Exit, 1 = Multiply, 2 = Exponentiate");
				choice = menuChoice(console);
				if(choice == 0) {
					while(true) {
						System.out.print("Are you sure you wish to exit? (y/n): ");
						exitInput = console.nextLine().trim().toLowerCase();
						if(exitInput.equals("y")) {
							loop = false;
							break;
						} else if(exitInput.equals("n")) {
							loop = true;
							break;
						} else {
							System.out.println("Something something error message. The input must be \"y\" or \"n\".");
						}
					}
				} else {
					input = getInput(console, choice);
					
					if(choice == 1) {
						num = multiply(input[0], input[1]);
					} else if(choice == 2) {
						num = exponent(input[0], input[1]);
					} else {
						throw new IllegalArgumentException("No menu choice with code: " + choice);
					}
					
					System.out.println("Output: " + num + "\n\n");
				}
			} while(choice != 0);
		}
		
		System.out.println("Goodbye!");
	}
	
	public static int[] getInput(Scanner console, int operation) {
		String[] prompts = new String[2];
		String input;
		int[] output = {0, 0};
		boolean inputInvalid;
		
		switch(operation) { //In case I need to add more operations later.
		case 1:
			prompts[0] = "First number: ";
			prompts[1] = "Second number: ";
			break;
		case 2:
			prompts[0] = "Base: ";
			prompts[1] = "Power: ";
			break;
		default:
			throw new IllegalArgumentException("No operation with code: " + operation);
		}
		
		for(int i = 0; i < 2; i++) {
			do {
				inputInvalid = false;
				System.out.print(prompts[i]);
				input = console.nextLine();
				try {
					output[i] = Integer.parseInt(input);
					if(output[i] < 0 && i == 1 && operation == 2) throw new IllegalArgumentException("For exponents, the power cannot be negative!");
					if(output[i] < 0 && operation == 1) throw new IllegalArgumentException("The spec says you can't multiply negative numbers right now. Sorry.");
				} catch(NumberFormatException e) {
					System.out.println("You must enter a number!");
					System.out.println("You entered: \"" + input + "\"");
					try {
						Integer.parseInt(input.trim());
						System.out.println("You cannot have whitespace in your input.");
					} catch(NumberFormatException n) {};
					inputInvalid = true;
				} catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println("You entered: " + output[i]);
					inputInvalid = true;
				}
			} while(inputInvalid);
		}
		
		return output;
	}
	
	public static int menuChoice(Scanner console) {
		int choice = 0;
		String input = "";
		boolean c = true;
		while(c) {
			try {
				c = false; //There's probably an easier way to achieve this. I don't remember any. I'm rather sick right now.
				System.out.print("Enter your choice (0, 1, 2): ");
				input = console.nextLine().trim();
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
