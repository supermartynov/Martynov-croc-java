package ru.croc.task14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String viewsHistorySource = "./week6/src/ru/croc/task14/historyView.txt";
    public static final String filmsList = "./week6/src/ru/croc/task14/filmsList.txt";

    public static void main(String[] args) throws IOException {
        ArrayList<String> viewsList = CreateCollectionFromFile.viewsHistory(viewsHistorySource);
        HashMap<Integer, String> filmsHashMap = CreateCollectionFromFile.filmsMap(filmsList);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите историю просмотров в таком же формате, как и в файлах (без пробелов через запятую)");
        String userViewHistory = scanner.nextLine();
        int MostFrequentFilmId = CreateRecommendation.createFilmRecommendation(userViewHistory, viewsList);

        System.out.println(filmsHashMap.get(MostFrequentFilmId));
    }
}
