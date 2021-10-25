package ru.croc.task6;

import java.util.Scanner;

public class Main {
    public static String removeJavaComments(String string) {
        String firstPart = string.replaceAll("/\\*.*\\*/", "");
        String secondPart = firstPart.replaceAll("//.*(?=\\n?)", "");
        return secondPart;
    }

    public static void main(String[] args) {
        String str = "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "  \n" +
                "  /* main method */\n" +
                "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "    // this line prints my first greeting to the screen\n" +
                "    System.out.println(\"Hi!\"); // :)\n" +
                "  }\n" +
                "} // the end\n" +
                "// to be continued...\n";
        //Scanner scanner = new Scanner(System.in);
        System.out.println(removeJavaComments(str));
    }
}

