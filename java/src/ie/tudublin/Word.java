package ie.tudublin;

import java.util.ArrayList;

public class Word {
    private String word;
    ArrayList<Follow> follows = new ArrayList<>();

    public Word(String word) {
        this.word = word;
        this.follows = new ArrayList<>();
    }

    public String getWord() {
        return this.word;
    }

    public ArrayList<Follow> getFollows() {
        return this.follows;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setFollows(ArrayList<Follow> follows) {
        this.follows = follows;
    }

    public void addFollow(Follow follow) {
        this.follows.add(follow);
    }

   
}

