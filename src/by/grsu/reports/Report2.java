package by.grsu.reports;

import by.grsu.SelectFromTable;
import by.grsu.dataModul.Sentiment;
import by.grsu.dataModul.Tweet;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrei on 03.04.2017.
 * Calculate the weight of tweets
 */
public class Report2 implements Recordable<Date,Date> {
    /**
     * Method for finding the weight of tweets
     * @param timeStart
     * @param timeFinish
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void generate(Date timeStart, Date timeFinish) throws IOException, SQLException, ClassNotFoundException {
        List<Tweet> tweets = SelectFromTable.selectTweets();
        List<Sentiment> sentiments = SelectFromTable.selectSentiments();
        Date time;
        double weight = 0;
        for(Tweet tweet : tweets){
            time = tweet.tweetDate;
            if (timeStart.before(time) && timeFinish.after(time)) {
                weight += tweet.getWeightTweet(sentiments);
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(".//report2.txt"));
        writer.write("Вес твитов равен " + weight);
        writer.close();
    }
}
