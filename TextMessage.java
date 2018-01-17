/*
 * Arturo Oceguera, Hai Le
 * 01/16/18
 * Program 1 
 * The purpose of this program is to read-in a list of dictionary words, prompt 
 * the user for a text input and generate a list of words that user might have 
 * intented to type based on the input.
 */
package program1;

import java.util.ArrayList;

public class TextMessage {
    // stores the user input as it is
    private String inputStr;
    // stores the user input as separate searchable words
    private ArrayList<String> words;
    
    // default constructor
    public TextMessage() {
        inputStr = "";
        words = new ArrayList<>();
    } // end TextMessage
    
    // overloaded constructor that accepts input string and input string.split
    public TextMessage(String input, String[] tokens) {
        inputStr = input;
        words = new ArrayList<>();
        processText(tokens);
    } // end TextMessage
    
    // overloaded constructor that accepts input string
    public TextMessage(String input) {
        inputStr = input;
        words = new ArrayList<>();
        processText(inputStr.split(" "));
    } // end TextMessage

    // getters and setters for input Str
    public String getInputStr() {
        return inputStr;
    } // end getInputStr

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
        processText(inputStr.split(" "));
    } // end setInputStr

    // getters and setters for words
    public ArrayList<String> getWords() {
        return words;
    } // end getWords

    public void setWords(ArrayList<String> words) {
        this.words = words;
    } // end setWords
    
    // overloaded getter that accepts string array
    public void setWords(String[] words) {
        processText(words);
    } // end setWords
    
    // process the tokens for the search in dictionary
    private void processText(String[] tokens) {
        
        // loops through each word in tokens
        for (String token: tokens) {
            // if the word contains only alphabet
            if(token.matches("[a-zA-Z]+"))
                // adds the word to the processed list
                words.add(token);
        } // end for
    } // end processText
    
    public void clear() {
        inputStr = "";
        words.clear();
    }
} // end TextMessage
