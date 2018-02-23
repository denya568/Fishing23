package ru.denya.fishing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckContent {
    private static boolean fish;
    private int count;
    private String originalTXT;
    private String presentTXT;

    CheckContent(String originalTXT, String presentTXT, int critic) {
        this.originalTXT = originalTXT;
        this.presentTXT = presentTXT;

        String pO = parsingTXT(originalTXT);
        String pP = parsingTXT(presentTXT);

        List<String> o = Arrays.asList(pO.split(" "));
        List<String> original = new ArrayList<>();
        List<String> p = Arrays.asList(pP.split(" "));
        List<String> present = new ArrayList<>();

        for (int i = 0; i < o.size(); i += critic) {
            if (i > o.size() - (critic)) {
                original.add(String.valueOf(o.subList(i, o.size())));
            } else {
                original.add(String.valueOf(o.subList(i, i + critic)));
            }
        }
        for (int i = 0; i < original.size(); i++) {
            original.set(i, original.get(i).substring(1, original.get(i).length() - 1).replace(",", ""));
        }

        for (int i = 0; i < p.size(); i += critic) {
            if (i > p.size() - (critic)) {
                present.add(String.valueOf(p.subList(i, p.size())));
            } else {
                present.add(String.valueOf(p.subList(i, i + critic)));
            }
        }
        for (int i = 0; i < present.size(); i++) {
            present.set(i, present.get(i).substring(1, present.get(i).length() - 1).replace(",", ""));
        }


        for (int i = 0; i < present.size(); i++) {
            for (int j = 0; j < original.size(); j++) {
                //if (present.get(i).contains(original.get(j))) {
                if (present.get(i).equalsIgnoreCase(original.get(j))) {
                    this.count++;
                    //System.out.println(present.get(i) + " = " + original.get(j));
                }
            }
        }


        /*for (int i = 0; i < present.size(); i++) {
            if (pO.contains(present.get(i))) {
                this.count++;
                //System.out.println(present.get(i));
            }
        }*/


    }

    public static boolean isFish() {
        return fish;
    }

    public int getCount() {
        return count;
    }

    private static String parsingTXT(String txt) {
        Document document = Jsoup.parse(txt);
        String a = document.text();

        return a;
    }

}
