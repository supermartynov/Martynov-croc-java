package ru.croc.task16;

import java.util.Objects;

public class Respondent implements Comparable<Respondent> {
    private String name;
    private int age;

    public Respondent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Respondent o) {
        if (this.age == o.age) {
            return this.name.compareTo(o.name);
        }
        return o.age - this.age;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.age + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Respondent)) return false;
        Respondent that = (Respondent) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
