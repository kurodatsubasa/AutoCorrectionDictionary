/*
 * Arturo Oceguera, Hai Le
 * 01/16/18
 * Program 1 
 * The purpose of this program is to read-in a list of dictionary words, prompt 
 * the user for a text input and generate a list of words that user might have 
 * intented to type based on the input.
 */
package program1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileIO {
    
    /* The following function serves to initialize the dictionary with the list
     * of words or keyboard layout by reading from text files. 
     */
    public static void readFile(String fileName, Dictionary dictionary, int option) throws Exception{
        
        // readsthe file using Java 7 Paths and Files
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            // if option is 0, reading list of words
            if(option == 0)
                /* setups dictionary word list (Java 8)
                 * br.lines() by getting the text file as a String stream
                 * collect(Collectors.toList()) and converting it to List  
                 */
                dictionary.setWordList( br.lines().collect(Collectors.toList()));
            // if option is 1, reading keyboard layout
            else if (option == 1)
                /* setups dictionary keyboard layout(Java 8)
                 * br.readLine().chars() by converting string to int stream,
                 * mapToObj(e-> (char)e) converting int to char
                 * collect(Collectors.toList())  then collect it as a List
                 */
                dictionary.setKeyboardLayout(br.readLine().chars().mapToObj(e->(char)e).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        } // end try catch
    } // end readFile
} // end FileIO
