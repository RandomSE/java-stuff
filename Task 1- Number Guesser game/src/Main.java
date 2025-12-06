import java.util.InputMismatchException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
public class Main {
	static Scanner scanner = new Scanner(System.in); // so it can be utilized in the functions.
	static Random random = new Random();

	public static void main(String[] args) {
		/* should easily finish this tomorrow. Current planned features:
				 
		 */
		
		Initiate();
		
		
		
		

	}
	
	public static void Initiate() {
	// Gets the difficulty for the next game, then calls the Guessing function with the provided difficulty setting.
		String[] difficultyNames = {"easy", "medium", "hard", "impossible"};
        char[] difficultyChoices = {'e', 'm', 'h', 'i'};
        System.out.println("Which difficulty would you like to play on? e (easy), m (medium), h (hard), or i (impossible)?");
        String response = scanner.next();
        scanner.nextLine();
        char choice = Character.toLowerCase(response.charAt(0));
        String difficulty = null;
        
        for (int i = 0; i < difficultyChoices.length; i++) {
            if (choice == difficultyChoices[i]) {
                System.out.println("You chose " + difficultyNames[i] + " mode.");
                difficulty = difficultyNames[i];
                break;
            }
        }
        
        // If no valid choice was made, randomly assign a difficulty
        if (difficulty == null) {
            int irandchoice = random.nextInt(difficultyNames.length); // Random number between 0 and 3
            System.out.println("You did not choose, so " + difficultyNames[irandchoice] + " mode has been chosen for you.");
            difficulty = difficultyNames[irandchoice];
        }

        System.out.println("Selected difficulty: " + difficulty);        
        Guessing(difficulty);
				
		}
	
	
	
			
			
		
	
	
	public static void Guessing(String difficulty) {
		// loops until the user correctly guesses, or their amount of remaining guesses is 0.
		int iRandom;
		int iScoreMult;
		switch(difficulty) {
		
		case("easy"):
		    iRandom = random.nextInt(50) +1;
			System.out.println("Try to guess the number; It is between 1 and 50.");
			iScoreMult = 1;
			break;
		
		case("medium"):
			iRandom = random.nextInt(100) +1;	
			System.out.println("Try to guess the number; It is between 1 and 100.");
			iScoreMult = 2;
			break;
			
		case("hard"):
			iRandom = random.nextInt(250) +1;	
			System.out.println("Try to guess the number; It is between 1 and 250.");
			iScoreMult =5;
			break;
			
		case("impossible"):
			iRandom = random.nextInt(Integer.MAX_VALUE) +1;	
			System.out.println("Try to guess the number; It is between 1 and 2,147,483,647."); // since the user has 50 attempts, may as well make it somewhat difficult if they aren't using a binary search strategy or something similar.
			iScoreMult = 50;
			break;
			
		default:
			iRandom = random.nextInt(100)+1; // should always be between easy and impossible, minor error management.
			iScoreMult = 2;
		}
		
		int iGuess = 0;
		int iAttempts = 0;
		int [] arrGuesses = new int[50] ; // 50 attempts.
		while (iGuess != iRandom) {
		    System.out.println("What is your guess?");
		    
		    try {
		        iGuess = scanner.nextInt();
		        arrGuesses[iAttempts] = iGuess;
		        iAttempts++; // after the addition to arrGuesses for accuracy.

		        if (iGuess > iRandom) {
		            System.out.println("Your guess was too high. Try again.");
		        } else if (iGuess < iRandom) {
		            System.out.println("Your guess was too low. Try again.");
		        }

		        if (iAttempts >= 50) {
		            System.out.println("Maximum number of attempts made.");
		            System.exit(1); // you can only get 50 attempts.
		        }
		    } catch (InputMismatchException e) {
		        System.out.println("Invalid input. Please enter an integer.");
		        scanner.nextLine(); // clear the invalid input
		    }
		}
		System.out.println( "Correct! The answer was: " + iRandom  + "\nGuesses made: " + iAttempts +"\ndifficulty: " +difficulty);
		StringBuilder sGuesses = new StringBuilder();
		for (int i = 0; i < iAttempts; i++) {
            sGuesses.append(arrGuesses[i]);
            if (i < iAttempts - 1) {
                sGuesses.append(", ");  // Add comma only if it's not the last element
            }
        }
		System.out.println("Your guesses: \n" + sGuesses.toString());
		int iFinalScore = (iScoreMult * 50 - (iAttempts * iScoreMult)); // If they get it right on the last one, then they get 0 score.
		EndGame(iFinalScore);
	}
	
	public static void EndGame(int iScore) {
	    System.out.println("Final score: " + iScore);

	    // Ask if the user wants to save the score
	    scanner.nextLine();
	    System.out.println("Would you like to save your score? (yes/no)");
	    String saveResponse = scanner.nextLine().trim().toLowerCase();

	    if (saveResponse.equals("yes")) {
	        try {
	            FileWriter fileWriter = new FileWriter("scores.txt", true);
	            PrintWriter printWriter = new PrintWriter(fileWriter);
	            printWriter.println("Score: " + iScore);
	            printWriter.close();
	            System.out.println("Your score has been saved.");
	        } catch (IOException e) {
	            System.out.println("An error occurred while saving your score.");
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Your score was not saved.");
	    }

	    // Ask if the user wants to see all saved scores
	    System.out.println("Would you like to see all saved scores? (yes/no)");
	    String viewScoresResponse = scanner.nextLine().trim().toLowerCase();

	    if (viewScoresResponse.equals("yes")) {
	        try {
	            File file = new File("scores.txt");
	            if (file.exists()) {
	                Scanner fileScanner = new Scanner(file);
	                System.out.println("Saved Scores:");
	                while (fileScanner.hasNextLine()) {
	                    System.out.println(fileScanner.nextLine());
	                }
	                fileScanner.close();
	            } else {
	                System.out.println("No scores have been saved yet.");
	                scanner.nextLine();
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading the scores.");
	            e.printStackTrace();
	        }
	        
	    }
	    else {
	    	System.out.println("No scores shall be shown to you, then.");
	    }
     NewGame();
	}
	
	public static void NewGame() {
		System.out.println("Would you like to play again? yes/no");
		String sResponse = scanner.nextLine().trim().toLowerCase();
		char cCheck = sResponse.charAt(0);
		if (cCheck =='y'){
			Initiate();	
		}
		else {
			System.out.println("You closed the game.");
			System.exit(0);
		}
		scanner.close();
	}
	
	

}


