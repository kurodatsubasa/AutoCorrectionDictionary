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
import static program1.TextMessage.textMessage;

public class TextMessage {
    
    public static String textMessage (String message)
    {

        String [] arr = message.split(" ");
        
        for (String array : arr)
        {
            System.out.println(array + ":" /*+ keyboardLayout()*/); 
        }
           
        System.exit(0);
    
         return textMessage();
         
         // need a way to return all the statements printed back to the main
         // this method works only in its loop and within class
        /* prints out like this
         hellow world
         hello:
         world:
         */
        
    }
    
}
