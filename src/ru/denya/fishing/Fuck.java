package ru.denya.fishing;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Fuck {
    public static void main(String[] args) {

        Properties p = System.getProperties();
        String dir = p.getProperty("user.dir");
        System.out.println(dir);

        File file = new File(dir + "/asd.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
