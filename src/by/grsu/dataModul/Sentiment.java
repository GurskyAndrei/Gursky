package by.grsu.dataModul;

/**
 * Created by Andrei on 14.03.2017.
 * Essence for sentiment
 */
public class Sentiment {
    public String sentiment;

    public double number;

    public Sentiment(String sent, double num)
    {
        this.sentiment = sent;
        this.number = num;
    }

    public String toString()
    {
        return sentiment + "," + number;
    }
}
