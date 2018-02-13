package ru.denya.fishing;

public class Fuck {
    public static void main(String[] args) {

        String q = "вконтакте";
        int num = 5;

        Inetwork iw = new Inetwork();
        //iw.loadPage("http://google.com/search?q=" + q + "&pws=0&num=" + num + "&safe=off&strip=1");
        //iw.loadPage("http://google.com/search?q=вконтакте&pws=0&num=5&safe=off&strip=1");
        iw.loadPage("https://www.google.ru/search?q=%D0%B2%D0%BA%D0%BE%D0%BD%D1%82%D0%B0%D0%BA%D1%82%D0%B5&amp");
        System.out.println(iw.getTitle());
        System.out.println(iw.getTxt());
        System.out.println(iw.getResponceCode());


    }

}
