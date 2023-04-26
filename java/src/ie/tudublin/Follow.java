package ie.tudublin;

public class Follow {
    private String word;
    private int count;

    public Follow() {
        this.word = ""; //Setting string
        this.count = 0; //  Setting number
    }

    //Constructor 
    public Follow(String word, int count) {
        this.word = word;
        this.count = count;
    }


    // Getters and setters
    public String getWord() {
        return this.word;
    }

    public int getCount() {
        return this.count;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Follow = " + "word='" + word  +", count=" + count +'.';
    }
}

