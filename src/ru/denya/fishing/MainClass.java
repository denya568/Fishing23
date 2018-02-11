package ru.denya.fishing;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainClass {
    private static String line() {
        String a = "";
        for (int i = 0; i < 23; i++) {
            a += "-";
        }
        return a;
    }

    public static String addres;
    public static int frequency;

    public static void main(String[] args) {
        System.out.println("Введите адрес:\n   (http://google.com)");
        Scanner sc = new Scanner(System.in);
        addres = sc.nextLine();
        System.out.println("Введите скорость проверки: (кол-во ссылок/секунду) PS: не больше 1000 и не меньше 1\n   (23)");
        Scanner sc2 = new Scanner(System.in);
        frequency = sc2.nextInt();
        System.out.println("Проверяемый адрес: " + addres + "\nСкорость: " + frequency + " links/second");
        System.out.println(line());

        int thCount = Thread.activeCount();

        //frequency = 180;
        frequency = 1000 / frequency;
        Inetwork inetwork = new Inetwork();
        int startTime = (int) System.currentTimeMillis();
        inetwork.loadPage(addres);
        //inetwork.loadPage("https://google.com/");
        //inetwork.loadPage("https://hack-dag.ru");
        //inetwork.loadPage("https://vk.com/");
        //inetwork.loadPage("https://yandex.ru");
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

            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy_HH.mm_zzz");
            final String sDate = host + "-" + simpleDateFormat.format(date);

            Search search = new Search();
            search.startSearch(protocol, host, frequency, title, sDate);

            while (Thread.activeCount() > thCount) {
            }
            endTime = (int) System.currentTimeMillis();
            updateDiscoverSitesFile(sDate);

            System.out.println("Готово! Прошло " + (endTime - startTime) / 1000 + "с. или " + (endTime - startTime) / 1000 / 60 + "мин. ");
        } else {
            System.err.println("Данный сайт не доступен\n " + inetwork.getResponceCode());
        }

    }

    private static Properties p = System.getProperties();
    private static final String dir = p.getProperty("user.dir") + "//";

    private static void updateDiscoverSitesFile(String date) {
        Set<String> arr = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        try {
            File folder = new File(dir + date + "//");
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
