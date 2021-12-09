package ru.croc.task18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import ru.croc.task17.DBConnection;
import ru.croc.task18.DAO_implementations.OrderDAOImplementation;
import ru.croc.task18.DAO_implementations.ProductDAOImplementation;
import ru.croc.task18.entities.Product;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try(ConsoleOperations consoleOperations = new ConsoleOperations()) {
            System.out.println("Артикулы исходных данных из task17 заполнены на русском!!!");
            while (!(line = bufferedReader.readLine()).equals("КОНЕЦ")) {
                String[] strings = line.trim().split(" ");
                switch (strings[0].toUpperCase(Locale.ROOT)) {
                    case ("ТОВАР"):
                        consoleOperations.createProduct(strings);
                        break;
                    case ("ИЗМЕНИТЬ"):
                        consoleOperations.changeProduct(strings);
                        break;
                    case ("УДАЛИТЬ"):
                        consoleOperations.deleteProduct(strings);
                        break;
                    case ("ЗАКАЗ"):
                        consoleOperations.order(strings);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
