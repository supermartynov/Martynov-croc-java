package ru.croc.task14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static final String viewsHistorySource = "./week6/src/ru/croc/task14/historyView.txt";
    public static final String filmsList = "./week6/src/ru/croc/task14/filmsList.txt";

    public static void main(String[] args) throws IOException {
        ArrayList<String> viewsList = CreateCollectionFromFile.viewsHistory(viewsHistorySource);
        HashMap<Integer, String> filmsHashMap = CreateCollectionFromFile.filmsMap(filmsList);
        CreateRecommendation.createFilmRecommendation("2, 3", viewsList, filmsHashMap);
        viewsList.forEach(System.out::println);
    }
}
