package ru.denya.fishing;

import java.io.*;
import java.util.*;

public class MainClass {
    private static String line() {
        String a = "";
        for (int i = 0; i < 10; i++) {
            a += "-";
        }
        return a;
    }

    public static void main(String[] args) {

        /*String addres = args[0] = "https://vk.com";
        int frequency = Integer.parseInt(args[1] = "50");
        final String sDate = args[2] = "D:/asd";*/

        String addres = "https://vk.com";
        int frequency = 50 ;
        final String sDate = "D:/asd";

        System.out.println(addres + "  (" + frequency + " links/second)");
        int thCount = Thread.activeCount();

        frequency = 1000 / frequency;
        Inetwork inetwork = new Inetwork();
        int startTime = (int) System.currentTimeMillis();
        inetwork.loadPage(addres);
        if (!inetwork.getResponceCode().equalsIgnoreCase("404")) {
            int endTime = (int) System.currentTimeMillis();
            String host = inetwork.getHost();
            String protocol = inetwork.getProtocol();
            String title = inetwork.getTitle();

            System.out.println("Title: " + title);
            System.out.println("Protocol: " + protocol);
            System.out.println("Host: " + host);
            System.out.println("Path: " + inetwork.getPath());
            System.out.println(line() + " Поиск фишиг-сайтов " + line());

            Search search = new Search();
            search.startSearch(protocol, host, frequency, title, sDate);

            while (Thread.activeCount() > thCount) {
            }
            endTime = (int) System.currentTimeMillis();
            updateDiscoverSitesFile(sDate);

            int time = (endTime - startTime) / 1000;
            if (time / 60 > 0) {
                System.out.println("Готово! Прошло " + time / 60 + " мин.");
            } else {
                System.out.println("Готово! Прошло " + time + "с.");
            }

        } else {
            System.err.println("Данный сайт не доступен\n " + inetwork.getResponceCode());
        }

    }

    private static void updateDiscoverSitesFile(String date) {
        Set<String> arr = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        try {
            File folder = new File(date + "//");
            if (!folder.exists()) {
                boolean created = folder.mkdir();
                if (created) {
                    //ok
                }
            }
            BufferedReader br = new BufferedReader(new FileReader(folder + "/discoverSites.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                arr.add(line);
            }
            br.close();
            list.addAll(arr);

            File file = new File(folder, "discoverSites.txt");
            file.delete();
            file.createNewFile();

            FileWriter fw = new FileWriter(file, true);
            for (int i = 0; i < list.size(); i++) {
                fw.write(list.get(i) + "\r\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
