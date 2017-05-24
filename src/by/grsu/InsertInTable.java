package by.grsu;

import by.grsu.dataModul.Sentiment;
import by.grsu.dataModul.State;
import by.grsu.dataModul.Tweet;

import java.sql.*;
import java.util.List;

public class InsertInTable {
    public static void insertSentiments(List<Sentiment> sentimentList) throws SQLException, ClassNotFoundException {
        Connection connection = Connector.getConnection(); // Создаём соединение с базой данных
        String query = "INSERT INTO sentiments(sentiment,number) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        for(Sentiment sentiment : sentimentList){
            preparedStatement.setString(1,sentiment.sentiment);
            preparedStatement.setDouble(2,sentiment.number);
            preparedStatement.executeUpdate();
        }
        connection.close();
        preparedStatement.close();
    }
    public static void insertStates(List<State> states) throws SQLException, ClassNotFoundException {
        Connection connection = Connector.getConnection();
        String query = "INSERT INTO states(nameState,coordinates) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        int count = 1;
        for(State state : states){
            preparedStatement.setString(1,state.nameState);
            preparedStatement.setString(2,state.areasToString());
            preparedStatement.executeUpdate();
            count++;
        }

        connection.close();
        preparedStatement.close();
    }

    public static void insertTweets(List<Tweet> tweets) throws SQLException, ClassNotFoundException {
        Connection connection = Connector.getConnection();
        String query = "INSERT INTO tweets(x_coordinate,y_coordinate,date,text) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        for (Tweet tweet : tweets){
            preparedStatement.setDouble(1,tweet.coordinates.x);
            preparedStatement.setDouble(2,tweet.coordinates.y);
            Timestamp timestamp = new Timestamp(tweet.tweetDate.getTime());
            preparedStatement.setTimestamp(3,timestamp);
            preparedStatement.setString(4,tweet.tweetText);
            preparedStatement.executeUpdate();
        }

        connection.close();
        preparedStatement.close();
    }
}
