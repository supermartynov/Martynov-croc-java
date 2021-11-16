package ru.croc.task14;

import java.util.*;
import java.util.stream.Collectors;

public class CreateRecommendation {
    private static Set<Integer> uniqueViewsFromString(String userViewHistory) {
        Set<Integer> uniqueViews = new HashSet<>();
        String[] history = userViewHistory.split(",");

        for(String str : history) {
            uniqueViews.add(Integer.parseInt(str.replaceAll(" ", "")));
        }

        return uniqueViews;
    }

    private static int amountOfSameFilms(Set<Integer> currentUserUniqueViews, Set<Integer> someUserUniqueViews) {
        int counter = 0;
        for(Integer someFilm : someUserUniqueViews) {
            if (currentUserUniqueViews.contains(someFilm)) {
                counter++;
            }
        }
        return counter;
    }

    /*private static int maxDublicateAmount(String[] array) {

    }*/


    public static void createFilmRecommendation(String userViewHistory, ArrayList<String> viewsHistory, HashMap<Integer, String> filmsList) {
        Set<Integer> currentUserUniqueViews = uniqueViewsFromString(userViewHistory); //множество просмотренных фильмов, без повторений
        Iterator<String> viewsHistoryIterator = viewsHistory.iterator();

        while (viewsHistoryIterator.hasNext()){ //убираем истории пользователей, не посмотревших хотя бы половину фильмов.
            String someUserViewsHistory = viewsHistoryIterator.next();
            Set<Integer> someUserUniqueViews = uniqueViewsFromString(someUserViewsHistory);
            if ((double) amountOfSameFilms(currentUserUniqueViews, someUserUniqueViews) < Math.ceil((double) currentUserUniqueViews.size()/2)) {
                viewsHistoryIterator.remove();
            }
        }

        for (int i = 0; i < viewsHistory.size(); i++)  { //убираем все фильмы, которые посмотрел пользователь)
            for (Integer filmsId : currentUserUniqueViews) {
                String clearedSomeUserViewsHistory = viewsHistory.get(i)
                                                .replaceAll(filmsId.toString() + ",", "")
                                                .trim();
                if (clearedSomeUserViewsHistory.equals(filmsId.toString())) {
                    viewsHistory.remove(i);
                } else {
                    viewsHistory.set(i, clearedSomeUserViewsHistory);
                }
            }
        }

        //объединяем просмотры всех пользователей в массив строк.
        viewsHistory.forEach(System.out::println);
        /*String[] allViews = viewsHistory.stream().collect(Collectors.joining(" ")).split(" ");
        Arrays.stream(allViews).forEach(s -> System.out.print(s + " "));*/
    }
}
