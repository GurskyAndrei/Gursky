package by.grsu.parsers;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Andrei on 29.03.2017.
 * @param <T>
 */
public interface Parseable<T>{
    List<T> parse(String route) throws IOException,ParseException;
}
