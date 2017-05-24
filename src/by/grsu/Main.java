package by.grsu;

import by.grsu.dataModul.State;
import by.grsu.dataModul.Tweet;
import by.grsu.dataModul.Sentiment;
import by.grsu.parsers.ParseSentiments;
import by.grsu.parsers.ParseStates;
import by.grsu.parsers.ParseTweets;
import by.grsu.reports.Report1;
import by.grsu.reports.Report2;
import by.grsu.reports.Report3;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, SQLException, ClassNotFoundException {



       // ParseSentiments parseSentiments = new ParseSentiments();
       // List<Sentiment> sentiments = parseSentiments.parse("sentiments.csv");
        //InsertInTable.insertSentiments(sentiments);


        //ParseStates parseStates = new ParseStates();
       // List<State> states = parseStates.parse("states.json");
      // InsertInTable.insertStates(states);

       // ParseTweets parseTweets = new ParseTweets();
       // List<Tweet> tweets = parseTweets.parse("all_tweets.txt");
        //InsertInTable.insertTweets(tweets);


//        List<State> tweetList = SelectFromTable.selectStates();

    //    Report1 report1 = new Report1();
      //  report1.generate("#fspiders",0);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input time1 like this yyyy-MM-dd HH:mm:sss : ");
        Date timeStart = dateFormat.parse(scanner.nextLine());
        System.out.println("Input time2 like this yyyy-MM-dd HH:mm:ss : ");
        Date timeFinish = dateFormat.parse(scanner.nextLine());
       // Report2 report2 = new Report2();
       // report2.generate(timeStart, timeFinish);

        Report3 report3 = new Report3();
        report3.generate(timeStart, timeFinish);

  /*      MapStates map = new MapStates(states);
        map.repaint();
*/
    }
}




















/*
        Map<Integer, String> pipi = new HashMap<>();
        pipi.put(0, "pdpd");
        pipi.put(1, "iogjt");
        pipi.put(2, "gioj");
        Set<Integer> set = pipi.keySet();
        Collection<String> piq = pipi.values();
        for(String pol : piq){
            System.out.println(pol);
        }
        for(Integer lop : set){
            System.out.println(lop);
        }


        String str2 = "asdasdas";
        String str3;
        str3 = str2;
        System.out.println(str3);

        str2.equals(str3);


        //запись в файл
        BufferedWriter wb = new BufferedWriter(new FileWriter(args[0]));
        wb.write(tweet.toString());
        wb.close();


        List<String> psss = new ArrayList<String>();
        Scanner as = new Scanner(System.in);
        for(int i = 0; i < 3; i++){
            String str = as.nextLine();
            psss.add(str);
        }
        for (String trpr : psss){
            System.out.println(trpr);
        }
        psss.set(0,"dadas");

        psss.remove(1);
        for (String po : psss){
            System.out.println(po);
        }
        String str = psss.get(1);
*/
