/*
 * Arturo Oceguera, Hai Le
 * 01/16/18
 * Program 1 
 * The purpose of this program is to read-in a list of dictionary words, prompt 
 * the user for a text input and generate a list of words that user might have 
 * intented to type based on the input.
 */
package program1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Dictionary {
    private List<String> wordList;
    private List<Character> keyboardLayout;
    
    // default constructor
    public Dictionary(){
        wordList = new ArrayList<>();
        keyboardLayout = new ArrayList<>();
    }

    // Getters & Setters for wordList
    public List<String> getWordList() {
        return wordList;
    }

    public void setWordList(List<String> wordList) {
        this.wordList = wordList;
    }

    // Getters and Setters for keyboardLayout
    public List<Character> getKeyboardLayout() {
        return keyboardLayout;
    }

    public void setKeyboardLayout(List<Character> keyboardLayout) {
        this.keyboardLayout = keyboardLayout;
    }
    
    // Add a word entry to the dictionary
    public void addWord(String word) {
        
        if(wordList.indexOf(word) == -1)
            wordList.add(word);
        else
            System.out.println(word + "is already in the dictionary.");
    }
    
    /* for testing reading files
    public void printWords() {
        for(String word : wordList) {
            System.out.println(word);
        }
    }
    
    public void printKeyboard() {
        for(char ch: keyboardLayout) {
            System.out.println(ch);
        }
       } 
    */
}
