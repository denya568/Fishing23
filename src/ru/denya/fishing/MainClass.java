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

        /*String addres = args[0];
        int frequency = Integer.parseInt(args[1]);
        final String sDate = args[2];*/

        //String addres = "https://ya.ru";
        //String addres = "https://www.google.com";
        //String addres = "https://m.vk.com";
        String addres = "https://m.habrahabr.ru";
        int frequency = 100;
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
            System.out.println("100%");
            writePercent("100%", sDate);
            endTime = (int) System.currentTimeMillis();
            updateDiscoverSitesFile(sDate, addres);

            int time = (endTime - startTime) / 1000;
            if (time / 60 > 0) {
                System.out.println("Готово! Прошло " + time / 60 + " мин.");
            } else {
                System.out.println("Готово! Прошло " + time + "с.");
            }

        } else {
            System.err.println("Данный сайт не доступен\n " + inetwork.getResponceCode());
            err(sDate, "Данный сайт не доступен");
        }

    }

    private static void err(String date, String txt) {
        try {
            File folder = new File(date + "//");
            if (!folder.exists()) {
                boolean created = folder.mkdir();
                if (created) {
                    //ok
                }
            }
            File file = new File(folder, "discoverSites.txt");
            if (!file.exists()) {
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                BufferedWriter bw = new BufferedWriter(outputStreamWriter);
                bw.write(txt);
                bw.flush();
                bw.close();

            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                BufferedWriter bw = new BufferedWriter(outputStreamWriter);
                bw.write(txt);
                bw.flush();
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writePercent(String txt, String date) {
        try {
            File folder = new File(date + "//");
            if (!folder.exists()) {
                boolean created = folder.mkdir();
                if (created) {
                    //ok
                }
            }
            File file = new File(folder, "progress.txt");
            if (!file.exists()) {
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                BufferedWriter bw = new BufferedWriter(outputStreamWriter);
                bw.write(txt + "\r\n");
                bw.flush();
                bw.close();
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                BufferedWriter bw = new BufferedWriter(outputStreamWriter);
                bw.write(txt + "\r\n");
                bw.flush();
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateDiscoverSitesFile(String date, String mainSite) {
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
            File file = new File(folder, "discoverSites.txt");
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(folder.getAbsolutePath() + "/discoverSites.txt"));
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.startsWith(mainSite)) {
                        arr.add(line);
                    }
                }
                br.close();
                list.addAll(arr);
            }

            if (!folder.exists()) {
                boolean created = folder.mkdir();
                if (created) {
                    //ok
                }
            }
            if (!file.exists()) {
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                BufferedWriter bw = new BufferedWriter(outputStreamWriter);
                for (int i = 0; i < list.size(); i++) {
                    bw.write(list.get(i)+"\r\n");
                    bw.flush();
                }
                bw.close();
            } else {
                file.delete();
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                BufferedWriter bw = new BufferedWriter(outputStreamWriter);
                for (int i = 0; i < list.size(); i++) {
                    bw.write(list.get(i) + "\r\n");
                    bw.flush();
                }
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
