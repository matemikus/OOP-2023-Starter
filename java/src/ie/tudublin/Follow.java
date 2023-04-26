package ie.tudublin;

public class Follow {
    private String word;
    private int count;

    // Constructor
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

    public void increment() {
        count++;
    }

    @Override
    public String toString() {
        return "Follow = " + "word='" + word + ", count=" + count + '.';
    }
}