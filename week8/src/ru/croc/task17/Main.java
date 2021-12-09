package ru.croc.task17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {
    public static Connection connection;

    public static void main(String[] args) throws SQLException, IOException {
        try (Connection connection = DBConnection.createConnection())
        {
            TableCreator.createTables(connection);
            CSVReader csvReader = new CSVReader("./week8/src/ru/croc/task17/info.csv", connection);
            //CSVReader csvReader = new CSVReader(args[0], connection);
            csvReader.fillTablesFromCSV();
        }
    }

}
