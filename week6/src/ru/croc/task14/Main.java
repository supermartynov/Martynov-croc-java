package ru.croc.task14;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static final String viewsHistorySource = "./week6/src/ru/croc/task14/historyView.txt";
    public static final String filmsList = "./week6/src/ru/croc/task14/filmsList.txt";

    public static void main(String[] args) throws IOException {
        List<String> viewsList = CreateCollectionFromFile.viewsHistory(viewsHistorySource);
        HashMap<Integer, String> filmsHashMap = CreateCollectionFromFile.filmsMap(filmsList);
        filmsHashMap.forEach((k, v) -> System.out.println(v));

    }
}
