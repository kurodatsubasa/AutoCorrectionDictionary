/*
 * Arturo Oceguera, Hai Le
 * 01/16/18
 * Program 1 
 * The purpose of this program is to read-in a list of dictionary words, prompt 
 * the user for a text input and generate a list of words that user might have 
 * intented to type based on the input.
 */
package program1;

import java.util.*;

public class Program1 {

    public static void main(String[] args) throws Exception {
        Dictionary dictionary = new Dictionary();
        FileIO.readFile("words.txt", dictionary, 0);
        FileIO.readFile("keyboard.txt", dictionary, 1);
        
        // Enter a text message, "done" (no quotes) to exit: 
        Scanner sc = new Scanner(System.in);
        
        String input;
        
        System.out.println("Enter a phrase to check, type 'done' to exit:");
        input = sc.nextLine();
        
        
        while (input.equalsIgnoreCase("done"))
        {      
            System.out.println();
            TextMessage.textMessage(input);

            System.out.println();
            System.out.println("Enter a phrase to check, type 'done' to exit:");
            input = sc.nextLine();   
            
        }
        
    }
    
}
