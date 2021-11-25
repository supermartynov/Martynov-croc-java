package ru.croc.task16;

import java.util.*;

public class Main {
    static List<Group> groups = new ArrayList<>();
    static HashSet<Respondent> respondents = new HashSet<>();

    public static void main(String[] args) {
        //args = new String[] {"18", "25", "35", "55", "60", "80", "100"};
        int[] ageBounds = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            ageBounds[i] = Integer.parseInt(args[i].trim());
        }

        createGroupsList(ageBounds);
        scanRespondents();
        addRespondentsToGroups(respondents);
        sortAllGroups();
        printGroup(groups);
    }

    private static void scanRespondents() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String respondentStr = scanner.nextLine().trim();
            if (respondentStr.equals("END")) {
                break;
            }
            String[] stringArr = respondentStr.trim().split(",");
            respondents.add(new Respondent(stringArr[0], Integer.parseInt(stringArr[1].trim())));
        }

    }

    private static void createGroupsList(int[] bounds) {
        groups.add(new Group(0, bounds[0]));
        for (int i = 1; i < bounds.length - 1; i++) {
            int lastBound = groups.get(i - 1).getTo();
            groups.add(new Group(lastBound + 1, bounds[i]));
        }
        groups.add(new Group(bounds[bounds.length - 1] + 1, 123));
    }

    private static void addRespondentsToGroups(HashSet<Respondent> respondents) {
        for(Respondent respondent : respondents) {
            int age = respondent.getAge();
            for (Group group : groups) {
                if (age < group.getTo() && age > group.getFrom()) {
                    group.getRespondentList().add(respondent);
                }
            }
        }
    }

    private static void sortAllGroups() {
        for (Group group : groups) {
            Collections.sort(group.getRespondentList());
        }
    }

    private static void printGroup(List<Group> groups) {
        groups.stream()
                .filter(s -> s.getRespondentList().size() > 0)
                .forEach(s -> System.out.println(s.getFrom() + "-" + s.getTo() + ": " + s.printRespondsList()));
    }

}

