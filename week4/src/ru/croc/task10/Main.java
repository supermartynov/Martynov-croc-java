package ru.croc.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> callsHistory = new ArrayList<>();
        callsHistory.add("1,12");
        callsHistory.add("4,6");
        callsHistory.add("7,12");
        callsHistory.add("10,32");
        callsHistory.add("11,22");
        callsHistory.add("16,30");
        callsHistory.add("16,31");
        callsHistory.add("15,30");

        List<String> startTimeArray = new ArrayList<>();
        List<String> endTimeArray = new ArrayList<>();

        for (String str : callsHistory) {
            String[] stringArr = str.split(",");
            startTimeArray.add(stringArr[0]);
            endTimeArray.add(stringArr[1]);
        }

        int maxCalls = 0;
        Long currentStartTime = 0L;
        Long currentEndTime = 0L;

        for (int i = 0; i < callsHistory.size(); i++) {
            int tmpMaxCalls = 0;
            currentStartTime = Long.parseLong(startTimeArray.get(i));
            currentEndTime = Long.parseLong(endTimeArray.get(i));
            for (int j = 0; j < callsHistory.size(); j++) {
                if (Long.parseLong(startTimeArray.get(j)) >= currentStartTime && Long.parseLong(endTimeArray.get(j)) <= currentEndTime) {
                    tmpMaxCalls ++;
                }
            }
            if (tmpMaxCalls > maxCalls) {
                maxCalls = tmpMaxCalls;
            }
        }

        System.out.println(maxCalls);
    }
}
