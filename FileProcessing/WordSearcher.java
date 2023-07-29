// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 4
 * Name: Ella Wipatene
 * Username: wipateella
 * ID: 300558005
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class WordSearcher {

    /**
     * Asks the user for a pattern and then finds and prints out (one per line)
     *     all the words in a dictionary that contain that pattern.
     * At the end, it prints out how many words in the dictionary contained
     *    the pattern.
     * It should print the words as it finds them, but should stop printing
     *    after it has found 100 of them
     * The dictionary is in the file dictionary.txt, and has one word per line.
     */
    public void searchPattern() {
        String word = UI.askString("Word to search for:");
        int wordCounter = 0; // counts how many lines mathc 
        try {
            List<String> dictionary = Files.readAllLines(Path.of("dictionary.txt")); 
            for (String line: dictionary){
                if(line.contains(word)){
                    if (wordCounter < 100){ // only prints out the first 100 matches
                        UI.println(line); 
                    }
                    wordCounter++; 
                }
            }
            UI.println("There are " + wordCounter + " matches."); 

        } catch(IOException e){UI.println("File reading failed");}

    }

    /** set up the buttons */
    public void setupGUI(){
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Search", this::searchPattern);
        UI.addButton("quit", UI::quit);
        UI.setDivider(1.0);
    }

    public static void main(String[] args){
        WordSearcher ws = new WordSearcher();
        ws.setupGUI();
    }
}

