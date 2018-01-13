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

public class Dictionary {
    private ArrayList<String> wordList;
    private ArrayList<Character> keyboardLayout;
    
    // default constructor
    public Dictionary(){
        wordList = new ArrayList<>();
        keyboardLayout = new ArrayList<>();
    }

    // Getters & Setters
    public ArrayList<String> getWordList() {
        return wordList;
    }

    public void setWordList(ArrayList<String> wordList) {
        this.wordList = wordList;
    }

    public ArrayList<Character> getKeyboardLayout() {
        return keyboardLayout;
    }

    public void setKeyboardLayout(ArrayList<Character> keyboardLayout) {
        this.keyboardLayout = keyboardLayout;
    }
    
    // Add a word entry to the dictionary
    public void addWord(String word) {
        
        if(wordList.indexOf(word) == -1)
            wordList.add(word);
        else
            System.out.println(word + "is already in the dictionary.");
    }
}
