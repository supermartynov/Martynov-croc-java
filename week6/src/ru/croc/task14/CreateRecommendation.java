package ru.croc.task14;

import java.util.*;
import java.util.stream.Collectors;

public class CreateRecommendation {

    private static Set<Integer> uniqueViewsFromString(String userViewHistory) {
        Set<Integer> uniqueViews = new HashSet<>();
        String[] history = userViewHistory.split(",");
        for(String str : history) {
            if (str.length() != 0) {
                uniqueViews.add(Integer.parseInt(str.replaceAll(" ", "")));
            }
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

    private static String getJoinnedStringFromList(ArrayList<String> arrayList) {
        StringJoiner joiner = new StringJoiner(" ");
        for (String item : arrayList) {
            joiner.add(item);
        }
        return joiner.toString().replaceAll("  ", " ");
    }

    private static int[] getSortedArrayFromString(String str) {
        String[] stringArr = str.split(" ");
        int[] intArr = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            if (stringArr[i].trim().equals("")) {
                continue;
            }
            intArr[i] = Integer.parseInt(stringArr[i]);
        }
        Arrays.sort(intArr);
        return intArr;
    }

    private static int getMaxFreqFilmId(int[] arr) {
        int maxFrequence = 1;
        int maxFrequenceFilmId = 0;
        int currentFrequence = 0;
        int currentId = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (currentId == arr[i]) {
                currentFrequence++;
            } else {
                currentId = arr[i];
                currentFrequence = 1;
            }
            if (currentFrequence > maxFrequence) {
                maxFrequence = currentFrequence;
                maxFrequenceFilmId = arr[i - 1];
            }
        }
        return maxFrequenceFilmId;
    }


    public static int createFilmRecommendation(String userViewHistory, ArrayList<String> viewsHistory) {
        Set<Integer> currentUserUniqueViews = uniqueViewsFromString(userViewHistory); //множество просмотренных фильмов, без повторений
        Iterator<String> viewsHistoryIterator = viewsHistory.iterator();

        while (viewsHistoryIterator.hasNext()){ //убираем истории пользователей, не посмотревших хотя бы половину фильмов.
            String someUserViewsHistory = viewsHistoryIterator.next();
            Set<Integer> someUserUniqueViews = uniqueViewsFromString(someUserViewsHistory);
            if ((double) amountOfSameFilms(currentUserUniqueViews, someUserUniqueViews) < (double) (currentUserUniqueViews.size())/2) {
                viewsHistoryIterator.remove();
            }
        }

        for (int i = 0; i < viewsHistory.size(); i++) { //убираем все фильмы, которые посмотрел пользователь)
            String[] someUserViewsHistoryArray = viewsHistory.get(i).split(",");
            String clearedSomeUserViewsHistory = "";
            for (String view : someUserViewsHistoryArray) {
                if (!currentUserUniqueViews.contains(Integer.parseInt(view))) {
                    clearedSomeUserViewsHistory += view + " "; //склеиваем только подходящие под условие id фильмов
                }
            }
            viewsHistory.set(i, clearedSomeUserViewsHistory.trim());
        }

        //получаем отсортированный массив просмотров от всех пользователей
        int[] sortedViewsArray = getSortedArrayFromString(getJoinnedStringFromList(viewsHistory));
        //возвращаем самый встречающийся фильм
        return getMaxFreqFilmId(sortedViewsArray);
    }
}
