package by.grsu.reports;

import by.grsu.dataModul.Tweet;
import by.grsu.SelectFromTable;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 03.04.2017.
 *
 */
public class Report1 implements Recordable<String,Integer> {
    /**
     * Method for searching tweets
     * @param hashtag
     * @param number
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void generate(String hashtag, Integer number) throws IOException, SQLException, ClassNotFoundException {
        List<Tweet> tweetList = new ArrayList<>();
        List<Tweet> tweets = SelectFromTable.selectTweets();
        for(Tweet tweet : tweets){
            if(tweet.containsHashtag(hashtag))
                tweetList.add(tweet);
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(".//report1.txt"));

        for (Tweet tweet : tweetList){
            writer.write(tweet.toString());
            writer.newLine();
        }
        writer.close();
    }
}
