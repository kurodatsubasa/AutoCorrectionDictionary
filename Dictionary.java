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
    // stores the list of words
    private ArrayList<String> wordList;
    /* stores the keyboard layout with '!' as a separator between the rows of keys
     * and as a indicator of absense of adjacent letter. The keyboard layout will be
     * initialized from the text file instead of hardcoding it. It is a consideration 
     * that keyboard layout can be different and be modified.
     */
    private ArrayList<Character> keyboardLayout;
    
    // default constructor
    public Dictionary(){
        wordList = new ArrayList<>();
        keyboardLayout = new ArrayList<>();
    } // end Dictionary

    // Getters & Setters for word list
    public ArrayList<String> getWordList() {
        return wordList;
    } // end getWordList

    public void setWordList(ArrayList<String> wordList) {
        this.wordList = wordList;
    } // end setWordList

    // Getters and Setters for keyboard layout
    public ArrayList<Character> getKeyboardLayout() {
        return keyboardLayout;
    } // end getKeyboardLayout

    public void setKeyboardLayout(ArrayList<Character> keyboardLayout) {
        this.keyboardLayout = keyboardLayout;
    } // end setKeyboardLayout
    
    // The following function performs search for each word in a loop
    public void search(ArrayList<String> input) {
        input.forEach((word) -> {
            // for each word print out matched words in the list
            System.out.println(word + ": " + findWord(word));
        });
    } // end search
    
    /* The following function searches for the entered word in the list and generates
     * list of words that are in the dictionary that the user might have intended to type.
     */
    public String findWord(String keyWord) {
        // to store all matched words
        StringBuilder matchWords = new StringBuilder();
        
        // check if there is a match for the word in the list and add it to matchWords
          if (wordList.stream().anyMatch(keyWord::equalsIgnoreCase))
                matchWords.append(keyWord).append(" ");
        // generate suggestion words and add them to matchWords if there is a match
            matchWords.append(suggestWords(new StringBuilder(keyWord)));
        // if the matchWords is empty, no matched words were found
        if (matchWords.length() == 0)
            matchWords.append("NO MATCH");
        
        return matchWords.toString();
    } // end findWord

    /* The following function iterates through each character in the search word,
     * replaces it with adjacent letters on the keyboarrd and searches for the modified
     * word in the word list. 
     */
     protected StringBuilder suggestWords (StringBuilder searchWord) {
         // to store matched words
         StringBuilder matchWords = new StringBuilder("");
         
         // loops through each character in the words
         for(int i = 0; i < searchWord.length(); i++) {
             // gets the index of current letter on the keyboard
             int current = keyboardLayout.indexOf(searchWord.toString().toLowerCase().charAt(i));
             int previous = current - 1; //  index of adjacent letter on the left
             int next = current + 1; // index of adjacent letter on the right
             
             // if the current letter is not first element which is '!' and has adjacent letter on the left 
             if (current != 0 && keyboardLayout.get(previous) != '!') {
                 // replaces the current letter with adjacent letter on the left
                 searchWord.setCharAt(i, keyboardLayout.get(previous));
                 // searches for the modified word in the list
                 if (wordList.stream().anyMatch(searchWord.toString()::equalsIgnoreCase))
                     // if there is a match, adds it to matchWords
                     matchWords.append(searchWord).append(" ");
                 // restores the original word for next character replacement
                 searchWord.setCharAt(i, keyboardLayout.get(current));
             } // end if
             // if the current letter is not last character which is '!' and has adjacent letter on the right 
             if (current != keyboardLayout.size() - 1 && keyboardLayout.get(next) != '!') {
                 // replaces the current letter with adjacent letter on the right
                 searchWord.setCharAt(i, keyboardLayout.get(next));
                 // searches for the modified word in the list
                 if (wordList.stream().anyMatch(searchWord.toString()::equalsIgnoreCase))
                     // if there is a match, add it to matchWords
                     matchWords.append(searchWord).append(" ");
                 // restore the original word for next character replacement
                 searchWord.setCharAt(i, keyboardLayout.get(current));
             } // end if
         } // end for
         return matchWords;
     } // end suggestWords
    
/*
    // Add a word entry to the word list
    public void addWord(String word) {
        
        if(wordList.stream().anyMatch("word"::equalsIgnoreCase))
            wordList.add(word);
        else
            System.out.println(word + "is already in the dictionary.");
    } // end addWord
    
    // for testing reading files
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
