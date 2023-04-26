package ie.tudublin;

import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;

public class DANI extends PApplet {
	Follow follow;
	Word word;

	private ArrayList<Word> model;
	private Random random;

	public void settings() {
		size(1000, 1000);
		// fullScreen(SPAN);
	}

	public void setup() {
		colorMode(HSB);
		loadFile("shakespere.txt");
		printModel();
	}

	String[] sonnet;

	// Constructor
	public DANI() {
		model = new ArrayList<>();
		random = new Random();
	}

	public String[] writeSonnet() {
		int sonetteSize = 14;
		String[] sonnet = new String[sonetteSize];
		for (int i = 0; i < sonetteSize; i++) {
			sonnet[i] = writeLine();
		}
		return sonnet;
	}

	public String writeLine() {
		StringBuilder sb = new StringBuilder();
		Word current = model.get(random.nextInt(model.size()));

		while (current == null) {
			current = model.get(random.nextInt(model.size()));
		}

		sb.append(current.getWord());

		for (int i = 0; i < 10; i++) {
			Follow next;
			if (current.getFollows().isEmpty()) {
				next = null;
			} else {
				next = current.getFollows().get(random.nextInt(current.getFollows().size()));
			}

			if (next == null) {
				break;
			}
			sb.append(" ").append(next.getWord());
			current = findWord(next.getWord());

			if (current == null) {
				break;
			}
		}
		return sb.toString();
	}

	public Word findWord(String word) {
		for (Word w : model) {
			if (w.getWord().equals(word)) {
				return w;
			}
		}
		return null;
	}

	public void printModel() {
		for (Word word : model) {
			System.out.print(word);
		}
		System.out.println();
	}

	public void loadFile(String shakespere) {
		// Load a text file into a String array
		String[] lines = loadStrings(shakespere);

		// Iterate through each line of the text file
		for (String line : lines) {
			//Make it into an array of words
			String[] words = split(line, ' ');

			// loadStrings("filename.txt"); // Load a text file into a String array
			// split(line, ' '); // Split a string into an array of words
			// w.replaceAll("[^\\w\\s]",""); // Remove punction characters
			// s.toLowerCase() // Convert a string to lower case


			// Iterate through each word in the array
			for (int i = 0; i < words.length-1; i++) {
				String currentWord = words[i].replaceAll("[^\\w\\s]", ""); // Remove punction characters
				String nextWord = words[i + 1].replaceAll("[^\\w\\s]", "");// Remove punction characters

				Word word = findWord(currentWord);
				if (word == null) {
					word = new Word(currentWord);
					// Add the words to the string
					model.add(word);
				}
				word.addFollow(nextWord);
			}
		}
	}

	public void keyPressed() {
		// Go through it if pressing space bar
		if (key == ' ') {
			sonnet = writeSonnet();
			for (String line : sonnet) {
				System.out.println(line);
			}
		}
	}

	float off = 0;

	public void draw() {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
		textAlign(CENTER, CENTER);

		if (sonnet != null)

			for (int i = 0; i < sonnet.length; i++) {
				text(sonnet[i], width / 2, (i * 100));
			}
	}
}