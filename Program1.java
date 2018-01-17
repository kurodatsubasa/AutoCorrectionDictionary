/*
 * Arturo Oceguera, Hai Le
 * 01/16/18
 * Program 1 
 * The purpose of this program is to read-in a list of dictionary words, prompt 
 * the user for a text input and generate a list of words that user might have 
 * intented to type based on the input.
 */
package program1;

import java.util.Scanner;

public class Program1 {

    public static void main(String[] args) throws Exception {
        // initializes dicitionary
        Dictionary dictionary = new Dictionary();
        TextMessage message = new TextMessage();
        // reading list of words
        FileIO.readFile("words.txt", dictionary, 0);
        // reading-in keyboard layout
        FileIO.readFile("keyboard.txt", dictionary, 1);
        
        // sets scanner to read the user input from kb
        Scanner sc = new Scanner(System.in);
        
        // to store user input
        String input;
        
        // prompts the user for input and stores in String input
        System.out.println("Enter a text message, \"done\" (no quotes) to exit");
        input = sc.nextLine();
        
        // runs the program until the user enters "done" which sets the flag to true
        while (!input.equalsIgnoreCase("done")) {    
            // check if input is empty before processing it
            if(!input.isEmpty()) {
                // splist up the user input into proper words for processing 
                message.setInputStr(input);
                // searches the dictionary for proper words in the message
                dictionary.search(message.getWords());
                // clears the content of message before the next user input
                message.clear();
            } // end if
            // prompts the user for input and stores in String input
            System.out.println("\nEnter a text message, \"done\" (no quotes) to exit");
            input = sc.nextLine();   
        } // end while
        
        sc.close();
    } // end main
} // end Program 1
