package ru.denya.fishing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class MainClass {
    private static String line() {
        String a = "";
        for (int i = 0; i < 23; i++) {
            a += "-";
        }
        return a;
    }

    public static String addres = "https://google.com";

    public static void main(String[] args) {
        //System.out.println("Введите полный адрес:");
        //Scanner sc = new Scanner(System.in);
        //addres = sc.nextLine();
        //System.out.println("Вы ввели: " + addres);
        //System.out.println(line());


        Inetwork inetwork = new Inetwork();
        int startTime = (int) System.currentTimeMillis();
        //inetwork.loadPage(addres);
        inetwork.loadPage("https://google.com/");
        //inetwork.loadPage("https://hack-dag.ru");
        //inetwork.loadPage("https://m.habrahabr.ru/");
        //inetwork.loadPage("http://yandex.ru");
        if (!inetwork.getResponceCode().equalsIgnoreCase("404")) {
            int endTime = (int) System.currentTimeMillis();
            //System.out.println("Responce: " + inetwork.getResponceCode());
            String host = inetwork.getHost();
            String protocol = inetwork.getProtocol();
            //System.out.println("Title: " + inetwork.getTitle());
            System.out.println("Protocol: " + protocol);
            System.out.println("Host: " + host);
            System.out.println("Path: " + inetwork.getPath());
            System.out.println(line() + " Поиск фишиг-сайтов " + line());


            Search search = new Search();
            search.startSearch(protocol, host);


            endTime = (int) System.currentTimeMillis();
            System.out.println("Готово! Прошло " + (endTime - startTime)/1000 + "с. или " + (endTime - startTime)/1000/60 + "мин. ");

            //System.out.println(search.getDiscoverSite());





        } else {
            System.err.println("Данный сайт не доступен\n " + inetwork.getResponceCode());
        }


    }

    static int fuctorial(int n) {
        return (n > 0) ? n * fuctorial(n - 1) : 1;
    }

    private static void updateFile(){
        File file = new File("D://fishing23/asd.txt");
        Set<String> arr = new HashSet<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                arr.add(line);

            }
            br.close();
            fr.close();

            file.delete();
            file.createNewFile();

            //File newFile = new File("D://fishing23/asd1.txt");
            FileWriter fw = new FileWriter(file);


            for (String arrr : arr) {
                System.out.println(arrr);
                fw.write(arrr + "\r\n");
            }

            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
