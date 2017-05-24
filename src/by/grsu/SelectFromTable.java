package by.grsu;

import by.grsu.dataModul.Sentiment;
import by.grsu.dataModul.Tweet;
import by.grsu.parsers.ParseStates;
import by.grsu.dataModul.State;

import java.awt.geom.Point2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelectFromTable {
    public static List<Sentiment> selectSentiments() throws SQLException, ClassNotFoundException {
        List<Sentiment> sentiments = new ArrayList<>();
        Connection connection = Connector.getConnection();
        Statement statement = connection.createStatement(); // отправка запроса на получение
        String query = "SELECT * FROM sentiments";
        ResultSet resultSet = statement.executeQuery(query); // получение данных
        while (resultSet.next()){
            String text = resultSet.getString("sentiment");
            double number = resultSet.getDouble("number");
            Sentiment sentiment = new Sentiment(text,number);
            sentiments.add(sentiment);
        }
        statement.close();
        resultSet.close();
        connection.close();
        return sentiments;
    }
    public static List<State> selectStates() throws SQLException, ClassNotFoundException {
        List<State> states = new ArrayList<>();
        Connection connection = Connector.getConnection();
        Statement statement = connection.createStatement();
        String text = "SELECT * FROM states";
        ResultSet resultSet = statement.executeQuery(text);

        while(resultSet.next()){
            String nameState = resultSet.getString("nameState");
            String coordinates = resultSet.getString("coordinates");
            State state = ParseStates.getState(nameState,coordinates);
            states.add(state);
        }
        connection.close();
        statement.close();
        resultSet.close();
        return states;
    }
    public static List<Tweet> selectTweets() throws SQLException, ClassNotFoundException {
        List<Tweet> tweetList = new ArrayList<>();
        Connection connection = Connector.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM tweets";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            Point2D.Double point = new Point2D.Double(resultSet.getDouble("x_coordinate"),resultSet.getDouble("y_coordinate"));
            Date date = resultSet.getTimestamp("date");
            String text = resultSet.getString("text");
            Tweet tweet = new Tweet(point,date,text);
            tweetList.add(tweet);
        }
        connection.close();
        statement.close();
        resultSet.close();
        return tweetList;
    }
}
