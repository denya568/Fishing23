package ru.denya.fishing;

public class Fuck {
    public static void main(String[] args) {

        Inetwork iw = new Inetwork();
        iw.loadPage("https://vk.com");
        System.out.println(iw.getTitle());


    }

}
