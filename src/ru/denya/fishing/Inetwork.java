package ru.denya.fishing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Inetwork {
    public Inetwork() {
    }

    private String responceCode;
    private String title;
    private String protocol;
    private String host;
    private String path;

    public String getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public String getResponceCode() {
        return responceCode;
    }

    public String getTitle() {
        return title;
    }

    public void loadPage(String address) {
        final String[] protocol = {""};
        final String[] host = {""};
        final String[] path = {""};
        final String[] responceCode = {""};
        final String[] title = {""};

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String text = "";
                try {
                    URL url = new URL(address);
                    protocol[0] = url.getProtocol();
                    host[0] = url.getHost();
                    path[0] = url.getPath();
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(120000);
                    conn.setReadTimeout(120000);
                    conn.connect();

                    //InputStreamReader in = new InputStreamReader(conn.getInputStream(), "Windows-1251");
                    InputStreamReader in = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    StringBuilder sb = new StringBuilder();
                    BufferedReader br = new BufferedReader(in);
                    String line;

                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    text = sb.toString();
                    responceCode[0] = String.valueOf(conn.getResponseCode());

                    Document doc = Jsoup.parse(text);
                    title[0] = doc.title();

                    conn.disconnect();
                    br.close();
                    in.close();
                } catch (Exception e) {
                    responceCode[0] = "404";
                }


            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.protocol = protocol[0];
        this.host = host[0];
        this.path = path[0];
        this.responceCode = responceCode[0];
        this.title = title[0];

    }


}
