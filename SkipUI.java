import java.io.*;
import java.util.*;

public class SkipUI {

	        public static void main(String[] args) {
	                // Define variables to manage user input

	                String userCommand = "";
	                String userArgument = "";
	                Scanner userInput = new Scanner( System.in );
	                
	                Coin randomSource = null;
	                
	                // Get a source of random information
	                
	                System.out.println("What source of random data do you want? (array, random)");
	                userCommand = userInput.nextLine();
	                userCommand = userCommand.trim();
	                
	                if (userCommand.equalsIgnoreCase("array")) {
	                	randomSource = new ArrayCoin();
	                } else {
	                	randomSource = new RandomCoin();
	                }

	                // Define variables to catch the return values of the methods

	                boolean booleanOutcome;

	                // Define the list that we will test.

	                ListHierarchy testList = new ListHierarchy( randomSource );
	                booleanOutcome = testList.flip != null ? true : false;
	                // Process the user input until they provide the command "quit"

	                do {
	                        // Find out what the user wants to do
	                        userCommand = userInput.next();
	                        userArgument = userInput.nextLine();
	                        userArgument = userArgument.trim();

	                        // Include a "hack" to provide null and empty strings for testing
	                        if (userArgument.equalsIgnoreCase("blank")) {
	                                userArgument = "";
	                        } else if (userArgument.equalsIgnoreCase("null")) {
	                                userArgument = null;
	                        }
	                        
	                        /* Do what the user asked for. */

	                        if (userCommand.equalsIgnoreCase("add")) {
	                                booleanOutcome = testList.add( userArgument );
	                                System.out.println("Add \""+userArgument+"\" outcome " + booleanOutcome );
	                        } else if (userCommand.equalsIgnoreCase("find")) {
	                                booleanOutcome = testList.find( userArgument );
	                                System.out.println("Find \""+userArgument+"\" outcome " + booleanOutcome );
	                        } else if (userCommand.equalsIgnoreCase("quit")) {
	                                System.out.println ("Quit");
	                        } else {
	                                System.out.println ("Bad command: " + userCommand);
	                        }
	                } while (!userCommand.equalsIgnoreCase("quit"));

	                // The user is done so close the stream of user input before ending.

	                userInput.close();
	        }
	}

