package ru.croc.task16;

import java.util.ArrayList;
import java.util.Collections;

public class Group {
    private int from;
    private int to;
    private ArrayList<Respondent> respondentList = new ArrayList<>();

    public Group(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public ArrayList<Respondent> getRespondentList() {
        return respondentList;
    }

    public String printRespondsList() {
        String str = "";
        for(Respondent respondent : respondentList) {
            str += respondent.toString() + ", ";
        }
        return str;
    }
}
