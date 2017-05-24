package by.grsu.reports;

import by.grsu.SelectFromTable;
import by.grsu.dataModul.State;
import by.grsu.dataModul.Tweet;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrei on 03.04.2017.
 * Find the most popular state
 */
public class Report3 implements Recordable<Date,Date> {
    public void generate (Date timeStart, Date timeFinish) throws IOException, SQLException, ClassNotFoundException {
        List<Tweet> tweets = SelectFromTable.selectTweets();
        List<State> states = SelectFromTable.selectStates();
        Date time;
        int[] numOfTweets = new int[52];
        int i = 0;
        for(State state : states){
            for(Polygon polygon : state.polygons){
                for (Tweet tweet : tweets){
                    time = tweet.tweetDate;
                    int x = (int)(tweet.coordinates.x * 10 + 1850);
                    int y = (int)(-1 * tweet.coordinates.y * 10 + 770);
                    if (time.after(timeStart) && timeFinish.after(time) || timeStart.equals(time) || time.equals(timeFinish))
                        numOfTweets[i]++;
                }
            }
            i++;
        }
        Arrays.sort(numOfTweets);
        BufferedWriter writer = new BufferedWriter(new FileWriter(".//report1.txt"));
        for(int j = 0; j < 52; j++) {
            if (numOfTweets[j] == numOfTweets[numOfTweets.length - 1]) {
                State state = states.get(j);
                writer.write(state.nameState + " : " + numOfTweets[j]);
            }
        }
        writer.close();
    }
}
