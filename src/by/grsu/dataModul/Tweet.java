package by.grsu.dataModul;
/**
 * Created by Andrei on 14.03.2017.
 * Essence for tweet
 */
import java.awt.geom.Point2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Tweet {
    /** Tweet coordinates*/
    public Point2D.Double coordinates;
    public int someNumber;
    /** Date of publication of tweet*/
    public Date tweetDate;
    /** Tweet content */
    public String tweetText;

    public Tweet(Point2D.Double coordinates, Date tweetDate, String tweetText)
    {
        this.coordinates = coordinates;
        this.tweetDate = tweetDate;
        this.tweetText = tweetText;
    }

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  "[" + coordinates.x + ", " + coordinates.y + "] " + someNumber + " " + dateFormat.format(tweetDate) + " " + tweetText;
    }

    //содержит ли текст твита хэштег
    public boolean containsHashtag(String hashtag){
        String[] array = tweetText.toLowerCase().split(" ");
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(hashtag.toLowerCase()))
                return true;
        }
        return false;
    }

    public double getWeightTweet(List<Sentiment> sentiments){
        double weight = 0;
        String[] array = tweetText.toLowerCase().split(" ");
        for(int i = 0; i < array.length; i++){
            for(Sentiment st : sentiments){
                if(st.sentiment.equals(array[i]))
                    weight += st.number;
            }
        }

        return weight;
    }

}
