package ru.denya.fishing;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        /*System.out.println("Введите адрес:\n   (http://google.com)");
        Scanner sc = new Scanner(System.in);
        addres = sc.nextLine();
        System.out.println("Введите скорость проверки: (кол-во ссылок/секунду) PS: не больше 1000 и не меньше 1\n   (23)");
        Scanner sc2 = new Scanner(System.in);
        frequency = sc2.nextInt();
        System.out.println("Проверяемый адрес: " + addres + "\nСкорость: " + frequency + " links/second");
        System.out.println(line());*/

        frequency = 70;
        frequency = 1000 / frequency;
        Inetwork inetwork = new Inetwork();
        int startTime = (int) System.currentTimeMillis();
        //inetwork.loadPage(addres);
        inetwork.loadPage("https://google.com/");
        //inetwork.loadPage("https://hack-dag.ru");
        //inetwork.loadPage("http://vk.com/");
        //inetwork.loadPage("http://yandex.ru");
        if (!inetwork.getResponceCode().equalsIgnoreCase("404")) {
            int endTime = (int) System.currentTimeMillis();
            //System.out.println("Responce: " + inetwork.getResponceCode());
            String host = inetwork.getHost();
            String protocol = inetwork.getProtocol();
            String title = inetwork.getTitle();

            System.out.println("Title " + title);

            System.out.println("Protocol: " + protocol);
            System.out.println("Host: " + host);
            System.out.println("Path: " + inetwork.getPath());
            System.out.println(line() + " Поиск фишиг-сайтов " + line());

            Search search = new Search();
            search.startSearch(protocol, host, frequency, title);

            endTime = (int) System.currentTimeMillis();

            try {
                Thread.sleep(2323);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Готово! Прошло " + (endTime - startTime)/1000 + "с. или " + (endTime - startTime)/1000/60 + "мин. ");

        } else {
            System.err.println("Данный сайт не доступен\n " + inetwork.getResponceCode());
        }

    }



}
