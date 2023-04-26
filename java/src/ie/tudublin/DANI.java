package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

    private ArrayList<String> string;

    public void settings() {
        size(1000, 1000);
        //fullScreen(SPAN);
    }

    String[] sonnet;

    public String[] writeSonnet() {
        return null;
    }

    public void setup() {
        colorMode(HSB);

        // Initialize the string ArrayList
        string = new ArrayList<>();

        // Load the file
        loadFile("shakespere.txt");
		//loadFile("small.txt"); 
    }

    public void keyPressed() {
		// Didn't get this far
    }

    float off = 0;

    public void draw() {
        background(0);
        fill(255);
        noStroke();
        textSize(20);
        textAlign(CENTER, CENTER);
    }

    // loadFile method to load the document into the string
    public void loadFile(String shakespere) {
        // Load a text file into a String array
        String[] lines = loadStrings(shakespere);

        // Iterate through each line of the text file
        for (String line : lines) {
            //Make it into an array of words
            String[] words = split(line, ' ');

            // Iterate through each word in the array
            for (String word : words) {
                // Remove punctuation characters
				word.replaceAll("[^\\w\\s]",""); // Remove punction characters
                word.toLowerCase(); // Convert a string to lower case 
                // Add the words to the string
                string.add(word);
            }
        }
    }

	public void printModel() {
        for (String word : string) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}
