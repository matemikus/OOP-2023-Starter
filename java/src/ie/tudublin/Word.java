package ie.tudublin;
import java.util.ArrayList;

public class Word 
{
    Follow follow;
    private String word;
    ArrayList<Follow> follows = new ArrayList<>();
    

    public Word(String word)
    {
        this.word = word;
        this.follows = new ArrayList<>();
    }

    public String getWord() 
    {
        return this.word;
    }

    public ArrayList<Follow> getFollows() 
    {
        return this.follows;
    }

    public void addFollow(String FollowWord) 
    {
        Follow follow = findFollow(FollowWord);
        if(follow == null) 
        {
            follows.add(new Follow(FollowWord, 1));
        } 
        else 
        {
            follow.increment(); // count++
            
        }
    }

    public Follow findFollow(String followWord) 
    {
        for(Follow follow : follows) 
        {
            if (follow.getWord().equals(followWord)) 
            {
                return follow;
            }
        }
        return null;
    }

    @Override
    public String toString() 
    {
        StringBuilder s = new StringBuilder(); // Making string bUilder which can construc strings
        s.append(word).append(" ");

        return s.toString();
    }
}