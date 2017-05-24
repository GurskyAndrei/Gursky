package by.grsu.reports;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/**
  * Created by Andrei on 03.04.2017.
 */
public interface Recordable<T,U> {

    void generate(T add1,U add2) throws IOException, SQLException, ClassNotFoundException;
}
