package ru.croc.task14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateCollectionFromFile {

    public static ArrayList<String> viewsHistory(String src) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(src))) {
            while (bufferedReader.ready()) {
                list.add(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static HashMap<Integer, String> filmsMap(String src) throws IOException {
        HashMap<Integer, String> hashMap = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(src))) {
            while (bufferedReader.ready()) {
                String str = bufferedReader.readLine();
                String[] strings = new String[2];
                strings[1] = str.substring(str.indexOf(",") + 1);
                strings[0] = str.substring(0, str.indexOf(","));
                hashMap.put(Integer.parseInt(strings[0]), strings[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

}
