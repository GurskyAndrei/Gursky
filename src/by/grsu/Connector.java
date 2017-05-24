package by.grsu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
    private static final String URL = "jdbc:postgresql://localhost/BD_Gursky";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String NAME = "postgres";
    private static final String PASSWORD = "123";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        //Загружаем драйвер
        Class.forName(DRIVER);
        //Создаём соединение
        Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        return connection;
    }
}
