package ProjectJac;

// Algorithm:
//1. Display a welcome message with your name on it.
//2. Prompt the user for the pattern they want to display. 
//3. Prompt the user for the input value. 
//4. Display the requested pattern.
//5. As long as the user wants to display another pattern your program repeats steps 2 to 4
//6. Display a closing message

import java.util.Scanner;

public class Project2 {

    public static void main(String[] args) { 
    	//Step 1 & hint 1
        System.out.println("Welcome to E&S's Triangle/Diamond Printer! "+"\n");
  

        Scanner kb = new Scanner(System.in);

        int patternNumber;
        int inputValue;
        // Step 5: //Repeats to get user inputs indefinitely, unless chooses 5 to exit
        do { 
            
        	// Step 2: User input for the pattern number
            printPatternMenu(); //Calls void method to print pattern menu
            patternNumber = validPatternInput(kb); //Calls method to 

            if (patternNumber == 5) {
                break; // Exit the program if the user chooses 5
            }

            // Step 3: Prompt the user for the input value
            inputValue = validInputValue(kb);

            // Step 4: Display the requested pattern
            displayPattern(patternNumber, inputValue);

        } while (true);

        // Step 6: Display a closing message
        System.out.println("Thank you for using my printer, Hope to see you again!");
    }

    private static void printPatternMenu() { //To print pattern menus
        
    	System.out.println( "1)  54321   2)      1   3)  12345   4)    1" );
        System.out.println( "    5432           12        2345        123" );
        System.out.println( "    543           123         345       12345" );
        System.out.println( "    54           1234          45        123 " );
        System.out.println( "    5           12345           5         1" +"\n");
    }

    private static int validPatternInput(Scanner kb) { //Prompt valid user pattern input: an integer of 1-5
        int patternNumber;
        do { //outer loop for valid integer between 1-5
            System.out.print("Enter a pattern number: ");
            while (!kb.hasNextInt()) { //inner loop ensures input of integer type
                System.out.println("Invalid input. Please enter a valid pattern number:");
                kb.next(); // Re-enter prompt
            }
            patternNumber = kb.nextInt();

            if (patternNumber < 1 || patternNumber > 5) {
                System.out.println("Invalid pattern number. Please enter a number between 1 and 5.");
            }
        } while (patternNumber < 1 || patternNumber > 5);

        return patternNumber;
    }

    private static int validInputValue(Scanner kb) {
        int inputValue;
        do {
            System.out.print("Enter input value (1-9): ");
            while (!kb.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer value.");
                kb.next(); // Consume the invalid input
            }
            inputValue = kb.nextInt();

            if (inputValue < 1 || inputValue > 9) {
                System.out.println("Invalid input value. Please enter a number between 1 and 9.");
            }
        } while (inputValue < 1 || inputValue > 9);

        return inputValue;
    }

    private static void displayPattern(int patternNumber, int inputValue) {
        System.out.println("Pattern for input value " + inputValue + ":");

        switch (patternNumber) {
            case 1:
                displayPattern1(inputValue);
                break;
            case 2:
                displayPattern2(inputValue);
                break;
            case 3:
                displayPattern3(inputValue);
                break;
            case 4:
                displayPattern4(inputValue);
                break;
        }
    }

    private static void displayPattern1(int inputValue) {
       
    	for (int i = 1; i <= inputValue; i++) {  //Determines the number of lines and sets lower edge
            for (int j = inputValue; j >= i; j--) { //Starts from input to i & then i++
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void displayPattern2(int inputValue) {
        for (int i = 1; i <= inputValue; i++) {
            for (int j = 1; j <= inputValue - i; j++) {//number of spaces
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {//the numbers
                System.out.print(k);
            }
            System.out.println();
        }
    }

    private static void displayPattern3(int inputValue) {
        for (int i = 1; i <= inputValue; i++) {
            for (int j = 1; j <= i - 1; j++) { // Determines spaces before numbers//j=0;j<=i;j++
                System.out.print(" ");
            }
            for (int k = i; k <= inputValue; k++) { //Prints the numbers, set k=i cuts the lower edge off
                System.out.print(k);
            }
            System.out.println();
        }
    }

    private static void displayPattern4(int inputValue) {
	    	//if odd do the following 
    	if (inputValue %2 == 1) {	
    			
			int lineSpaces = inputValue / 2; //To define maximum spaces and reduce it -- from the top
			for (int i = 1; i <= inputValue; i+=2) { //To define an ending odd number i.e. 1, 1+2, 3+2...
				//printing spaces
				for (int j = 0; j < lineSpaces; j++) System.out.print(" ");
				//printing numbers
				for (int num = 1; num <= i; num++) System.out.print(num);
				
				System.out.println();
				
				lineSpaces--; //replace value of spaces by 1 for the next line
			}
			lineSpaces = 1; //To define maximum spaces and reduce it -- from the top
			for (int i = inputValue - 2; i >= 1; i-=2) { //To define an ending odd number i.e. 1, 1+2, 3+2...
				//printing spaces
				for (int j = 0; j < lineSpaces; j++) System.out.print(" ");
				//printing numbers
				for (int num = 1; num <= i; num++) System.out.print(num);
				
				System.out.println();
				
				lineSpaces++; //replace value of spaces by 1 for the next line
			}		
    	}		
    	else {	//if even do the following	
    	
    		int lineSpaces = (inputValue / 2); //To define maximum spaces and reduce it -- from the top
			for (int i = 1; i <= inputValue; i+=2) { //To define an ending odd number i.e. 1, 1+2, 3+2...
				//printing spaces
				for (int j = 0; j < lineSpaces; j++) System.out.print(" ");
				//printing numbers
				for (int num = 1; num <= i; num++) System.out.print(num);
				
				System.out.println();
				
				lineSpaces--; //replace value of spaces by 1 for the next line
			}
			lineSpaces = 1; 
			for (int i = inputValue - 1; i >= 1; i-=2) { //To define an ending odd number i.e. 1, 1+2, 3+2...
				//printing spaces
				for (int j = 0; j < lineSpaces; j++) System.out.print(" ");
				//printing numbers
				for (int num = 1; num <= i; num++) System.out.print(num);
				
				System.out.println();
				
				lineSpaces++; //replace value of spaces by 1 for the next line	
    		
			}
    	}
    }
}
