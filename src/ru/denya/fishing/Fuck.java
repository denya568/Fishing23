package ru.denya.fishing;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Fuck {
    public static void main(String[] args) {

        Inetwork inetwork = new Inetwork();
        inetwork.loadPage("https://yand1ex.ru/");
        System.out.println(inetwork.getResponceCode());
        System.out.println(inetwork.getResponceMessage()); //404, ue


    }

}
