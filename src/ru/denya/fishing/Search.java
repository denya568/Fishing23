package ru.denya.fishing;

import java.io.*;
import java.util.*;

public class Search {
    private Set<String> discoverSite = new HashSet<>();

    public final Set<String> getDiscoverSite() {
        return discoverSite;
    }

    private int nameCount = 0;

    public int getNameCount() {
        return nameCount;
    }

    public int getProtocolCount() {
        return protocolLibrary().size();
    }

    public int getDomenCount() {
        return domenLibrary().size();
    }


    static int fuctorial(int n) {
        return (n > 0) ? n * fuctorial(n - 1) : 1;
    }

    private ArrayList<String> generateWords(String word) {
        ArrayList<String> words = new ArrayList<>();

        String[] arr = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            arr[i] = String.valueOf(word.charAt(i));
        }

        int size = arr.length;
        Set<String> nameLibraryHashSet = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(arr[i]);
        }
        //подсчет повторений ===>
        Set<String> hTemp = new HashSet<>();
        hTemp.addAll(list);
        List<String> sTemp = new ArrayList<>();
        sTemp.addAll(hTemp);
        ArrayList<Sample> ident = new ArrayList<>();

        int temp = 0;
        for (int i = 0; i < sTemp.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (sTemp.get(i).equalsIgnoreCase(list.get(j))) {
                    temp++;
                }
            }
            ident.add(new Sample(temp, sTemp.get(i)));
            temp = 0;
        }
        temp = 1;
        for (int i = 0; i < ident.size(); i++) {
            temp *= fuctorial(ident.get(i).i);
        }
        if (temp == 0) {
            temp = 1;
        }
        //подсчет повторений <===

        int max = fuctorial(arr.length) / temp;
        while (nameLibraryHashSet.size() < max) {

            Collections.swap(list, 0, 1);
            nameLibraryHashSet.add(getTxt(list));

            Collections.reverse(list);
            nameLibraryHashSet.add(getTxt(list));

            Collections.rotate(list, 1);
            nameLibraryHashSet.add(getTxt(list));

            Collections.shuffle(list);
            nameLibraryHashSet.add(getTxt(list));

            Collections.shuffle(list);
            nameLibraryHashSet.add(getTxt(list));
        }
        words.addAll(nameLibraryHashSet);

        return words;
    }

    private static ArrayList<String> generateCopies(String word) {
        ArrayList<String> copies = new ArrayList<>();

        ArrayList<String> listChars = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            listChars.add(String.valueOf(word.charAt(i)));
        }

        Set<String> hashSet = new HashSet<>();

        for (int i = 0; i < listChars.size(); i++) {
            for (int j = 0; j < copyNameLibrary().size(); j++) {
                if (listChars.get(i).equalsIgnoreCase(copyNameLibrary().get(j).value1)) {
                    listChars.set(i, copyNameLibrary().get(j).value2);
                    hashSet.add(getTxt(listChars));
                    //copies.add(getTxt(listChars));

                    for (int k = 0; k < listChars.size(); k++) {
                        for (int l = 0; l < copyNameLibrary().size(); l++) {
                            if (listChars.get(k).equalsIgnoreCase(copyNameLibrary().get(l).value1)) {
                                listChars.set(k, copyNameLibrary().get(l).value2);
                                hashSet.add(getTxt(listChars));
                                //copies.add(getTxt(listChars));
                                listChars.set(k, copyNameLibrary().get(l).value1);
                            }
                        }
                    }
                    listChars.set(i, copyNameLibrary().get(j).value1);
                }
            }
        }

        for (int i = 0; i < listChars.size(); i++) {
            for (int j = 0; j < copyNameLibrary().size(); j++) {
                if (listChars.get(i).equalsIgnoreCase(copyNameLibrary().get(j).value2)) {
                    listChars.set(i, copyNameLibrary().get(j).value1);
                    hashSet.add(getTxt(listChars));
                    //copies.add(getTxt(listChars));

                    for (int k = 0; k < listChars.size(); k++) {
                        for (int l = 0; l < copyNameLibrary().size(); l++) {
                            if (listChars.get(k).equalsIgnoreCase(copyNameLibrary().get(l).value2)) {
                                listChars.set(k, copyNameLibrary().get(l).value1);
                                hashSet.add(getTxt(listChars));
                                //copies.add(getTxt(listChars));
                                listChars.set(k, copyNameLibrary().get(l).value2);
                            }
                        }
                    }

                    listChars.set(i, copyNameLibrary().get(j).value2);
                }
            }
        }


        for (int i = 0; i < listChars.size(); i++) {
            for (int j = 0; j < copyNameLibrary().size(); j++) {
                if (listChars.get(i).equalsIgnoreCase(copyNameLibrary().get(j).value1)) {
                    listChars.set(i, copyNameLibrary().get(j).value2);
                    hashSet.add(getTxt(listChars));
                    //copies.add(getTxt(listChars));

                    for (int k = 0; k < listChars.size(); k++) {
                        for (int l = 0; l < copyNameLibrary().size(); l++) {
                            if (listChars.get(k).equalsIgnoreCase(copyNameLibrary().get(l).value1)) {
                                listChars.set(k, copyNameLibrary().get(l).value2);
                                hashSet.add(getTxt(listChars));
                                //copies.add(getTxt(listChars));
                                listChars.set(k, copyNameLibrary().get(l).value1);
                            }
                        }
                    }
                    //listChars.set(i, copyNameLibrary().get(j).value1);
                }
            }
        }

        for (int i = 0; i < listChars.size(); i++) {
            for (int j = 0; j < copyNameLibrary().size(); j++) {
                if (listChars.get(i).equalsIgnoreCase(copyNameLibrary().get(j).value2)) {
                    listChars.set(i, copyNameLibrary().get(j).value1);
                    hashSet.add(getTxt(listChars));
                    //copies.add(getTxt(listChars));

                    for (int k = 0; k < listChars.size(); k++) {
                        for (int l = 0; l < copyNameLibrary().size(); l++) {
                            if (listChars.get(k).equalsIgnoreCase(copyNameLibrary().get(l).value2)) {
                                listChars.set(k, copyNameLibrary().get(l).value1);
                                hashSet.add(getTxt(listChars));
                                //copies.add(getTxt(listChars));
                                listChars.set(k, copyNameLibrary().get(l).value2);
                            }
                        }
                    }
                    //listChars.set(i, copyNameLibrary().get(j).value2);
                }
            }
        }


        copies.addAll(hashSet);
        return copies;
    }

    static String getTxt(ArrayList<String> list) {
        String asd = "";
        for (int i = 0; i < list.size(); i++) {
            asd += list.get(i);
        }

        return asd;
    }

    private ArrayList<String> replaceTitles(String title) {
        //проверка title
        int startCh = 0;
        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < title.length(); i++) {
            String txt = "";
            if (title.charAt(i) == ' ' || title.charAt(i) == ',' || title.charAt(i) == '.') {
                for (int j = startCh; j < i; j++) {
                    txt += title.charAt(j);
                }
                titles.add(txt);
                txt = "";
                startCh = i;
            }
        }
        String txt = "";
        for (int i = startCh; i < title.length(); i++) {
            txt += title.charAt(i);
        }
        titles.add(txt);
        txt = "";
        return titles;
    }

    public void startSearch(String protocol, String host, int frequency, String title, String sDate) {
        System.out.println("Prepare...");
        writeProgress("Prepare", sDate);

        ArrayList<String> mainTitle = new ArrayList<>();
        mainTitle = replaceTitles(title);

        double step = 0;
        int temp = -1;

        String podDomen = getHostPodDomen(host);
        String name = getHostName(host);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> podDomens = new ArrayList<>();

        System.out.println("Generation 2-nd lvl domens");
        writeProgress("Generation 2-nd lvl domens", sDate);
        nameLibrary.add("www" + name);
        nameLibrary.add(name);
        if (name.length() == 1) {
            names.add(name);
        } else {
            names.addAll(generateWords(name));
        }
        for (int i = 0; i < names.size(); i++) {
            nameLibrary.addAll(generateCopies(names.get(i)));
        }



        if (podDomen != null) {
            podDomenLibrary.add(podDomen);
            podDomenLibrary.add("www" + podDomen);
            System.out.println("Generation poddomens");
            writeProgress("Generation poddomens", sDate);
            podDomens.addAll(generateWords(podDomen));
            for (int i = 0; i < podDomens.size(); i++) {
                podDomenLibrary.addAll(generateCopies(podDomens.get(i)));
            }
        }

        System.out.println(nameLibrary);
        System.out.println(podDomenLibrary);

        double all;
        if (podDomenLibrary.size() != 0) {
            all = protocolLibrary().size() * nameLibrary.size() * podDomenLibrary.size() * domenLibrary().size();
        } else {
            all = protocolLibrary().size() * nameLibrary.size() * domenLibrary().size();
        }

        int frq = 1000 / frequency;
        frq = (int) (all / frq);
        if (frq / 60 > 0) {
            System.out.println("Сканирование продлится около " + (frq / 60) + " мин.");
        } else {
            System.out.println("Сканирование продлится около " + frq + " c.");
        }


        // =======>>> serfing
        if (podDomenLibrary.size() == 0) {
            for (int i = 0; i < protocolLibrary().size(); i++) {
                for (int j = 0; j < nameLibrary.size(); j++) {
                    for (int k = 0; k < domenLibrary().size(); k++) {

                        int finalI = i;
                        int finalJ = j;
                        int finalK = k;

                        try {
                            Thread.sleep(frequency);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        int finalStep = (int) step;
                        ArrayList<String> finalMainTitle = mainTitle;
                        Thread th = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Inetwork inetwork = new Inetwork();
                                inetwork.loadPage(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK));

                                if (!inetwork.getResponceCode().equalsIgnoreCase("404")) {
                                    suspectFile(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                    if (inetwork.getTitle().equalsIgnoreCase(title)) {
                                        discoverFile(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                    }

                                    ArrayList<String> inetTitle = new ArrayList<>();
                                    inetTitle = replaceTitles(inetwork.getTitle());

                                    for (int l = 0; l < finalMainTitle.size(); l++) {
                                        for (int m = 0; m < inetTitle.size(); m++) {
                                            if (finalMainTitle.get(l).equalsIgnoreCase(inetTitle.get(m))) {
                                                discoverFile(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                            }
                                        }
                                    }
                                }
                                writeLog(finalStep + ": " + protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                            }
                        });
                        th.start();

                        step++;
                        double percent = (step / all);
                        percent = percent * 100;

                        if ((int) (percent) > temp) {
                            temp = (int) percent;
                            if (temp != 100) {
                                System.out.println(temp + "%");
                                writeProgress(String.valueOf(temp) + "%", sDate);
                            }

                        }

                    }
                }
            }
        } else { // если есть поддомен

            ArrayList<String> finalMainTitle1 = mainTitle;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < protocolLibrary().size(); i++) {
                        for (int j = 0; j < podDomenLibrary.size(); j++) {
                            for (int k = 0; k < domenLibrary().size(); k++) {

                                int finalI = i;
                                int finalJ = j;
                                int finalK = k;

                                try {
                                    Thread.sleep(frequency);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                ArrayList<String> finalMainTitle = finalMainTitle1;
                                Thread th = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Inetwork inetwork = new Inetwork();
                                        inetwork.loadPage(protocolLibrary().get(finalI) + "://" + podDomenLibrary.get(finalJ) + "." + domenLibrary().get(finalK));

                                        if (!inetwork.getResponceCode().equalsIgnoreCase("404")) {
                                            suspectFile(protocolLibrary().get(finalI) + "://" + podDomenLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                            if (inetwork.getTitle().equalsIgnoreCase(title)) {
                                                discoverFile(protocolLibrary().get(finalI) + "://" + podDomenLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                            }

                                            ArrayList<String> inetTitle = new ArrayList<>();
                                            inetTitle = replaceTitles(inetwork.getTitle());

                                            for (int l = 0; l < finalMainTitle.size(); l++) {
                                                for (int m = 0; m < inetTitle.size(); m++) {
                                                    if (finalMainTitle.get(l).equalsIgnoreCase(inetTitle.get(m))) {
                                                        discoverFile(protocolLibrary().get(finalI) + "://" + podDomenLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                                    }
                                                }
                                            }
                                        }
                                        writeLog(protocolLibrary().get(finalI) + "://" + podDomenLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                    }
                                });
                                th.start();
                            }
                        }
                    }
                }
            });
            thread.start();

            for (int i = 0; i < protocolLibrary().size(); i++) {
                for (int j = 0; j < nameLibrary.size(); j++) {
                    for (int k = 0; k < podDomenLibrary.size(); k++) {
                        for (int l = 0; l < domenLibrary().size(); l++) {

                            try {
                                Thread.sleep(frequency);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            int finalStep = (int) step;
                            ArrayList<String> finalMainTitle = mainTitle;

                            int finalI = i;
                            int finalJ = j;
                            int finalK = k;
                            int finalL = l;
                            Thread th = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    Inetwork inetwork = new Inetwork();
                                    inetwork.loadPage(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + podDomenLibrary.get(finalK) + "." + domenLibrary().get(finalL));

                                    if (!inetwork.getResponceCode().equalsIgnoreCase("404")) {
                                        suspectFile(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + podDomenLibrary.get(finalK) + "." +  domenLibrary().get(finalL) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                        if (inetwork.getTitle().equalsIgnoreCase(title)) {
                                            discoverFile(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + podDomenLibrary.get(finalK) + "." +  domenLibrary().get(finalL) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                        }

                                        ArrayList<String> inetTitle = new ArrayList<>();
                                        inetTitle = replaceTitles(inetwork.getTitle());

                                        for (int l = 0; l < finalMainTitle.size(); l++) {
                                            for (int m = 0; m < inetTitle.size(); m++) {
                                                if (finalMainTitle.get(l).equalsIgnoreCase(inetTitle.get(m))) {
                                                    discoverFile(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + podDomenLibrary.get(finalK) + "." +  domenLibrary().get(finalL) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                                }
                                            }
                                        }
                                    }
                                    writeLog(finalStep + ": " + protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + podDomenLibrary.get(finalK) + "." +  domenLibrary().get(finalL) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                }
                            });
                            th.start();

                            step++;
                            double percent = (step / all);
                            percent = percent * 100;

                            if ((int) (percent) > temp) {
                                temp = (int) percent;
                                if (temp != 100) {
                                    System.out.println(temp + "%");
                                    writeProgress(String.valueOf(temp) + "%", sDate);
                                }

                            }


                        }
                    }
                }
            }

        }
        // <<<====== serfing

    }

    private void writeProgress(String txt, String date) {
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

    private void writeLog(String txt, String date) {
        try {
            File folder = new File(date + "//");
            if (!folder.exists()) {
                boolean created = folder.mkdir();
                if (created) {
                    //ok
                }
            }
            File file = new File(folder, "log.txt");
            if (!file.exists()) {
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                BufferedWriter bw = new BufferedWriter(outputStreamWriter);
                bw.write(txt + "\r\n");
                bw.flush();
                bw.close();
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
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

    private void suspectFile(String txt, String date) {
        try {
            File folder = new File(date + "//");
            if (!folder.exists()) {
                boolean created = folder.mkdir();
                if (created) {
                    //ok
                }
            }
            File file = new File(folder, "suspectSites.txt");
            if (!file.exists()) {
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                BufferedWriter bw = new BufferedWriter(outputStreamWriter);
                bw.write(txt + "\r\n");
                bw.flush();
                bw.close();
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
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

    private void discoverFile(String txt, String date) {
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
                bw.write(txt + "\r\n");
                bw.flush();
                bw.close();
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
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

    private static String getHostDomen(String host) {
        return host.substring(host.lastIndexOf(".") + 1);
    }

    private static String getHostName(String host) {
        return host.substring(0, host.indexOf("."));
    }

    private static String getHostPodDomen(String host) {
        int temp = 0;
        for (int i = 0; i < host.length(); i++) {
            if (host.charAt(i) == '.') {
                temp++;
            }
        }
        if (temp == 1) {
            return null;
        } else {
            for (int i = 0; i < host.length(); i++) {
                if (host.charAt(i) == '.') {
                    temp = i;
                    break;
                }
            }
            return host.substring(temp + 1, host.lastIndexOf("."));
        }

    }

    private static ArrayList<String> nameLibrary = new ArrayList<>();

    private static ArrayList<String> podDomenLibrary = new ArrayList<>();

    private static ArrayList<CopyName> copyNameLibrary() {
        ArrayList<CopyName> values = new ArrayList<>();

        values.add(new CopyName("o", "0"));
        values.add(new CopyName("l", "1")); // L-1
        values.add(new CopyName("l", "i")); // L-I
        values.add(new CopyName("j", "i")); // J-I
        values.add(new CopyName("q", "p"));
        values.add(new CopyName("u", "y"));
        values.add(new CopyName("h", "n")); // H-N
        values.add(new CopyName("w", "v")); // W-V
        values.add(new CopyName("w", "vv")); // W-VV
        values.add(new CopyName("m", "n")); // M-N
        values.add(new CopyName("m", "nn")); // M-NN
        values.add(new CopyName("g", "9")); // G-9
        values.add(new CopyName("g", "q")); // G-Q
        values.add(new CopyName("q", "9")); // Q-9
        values.add(new CopyName("f", "ph")); // F-PH
        values.add(new CopyName("c", "k")); // C-K

        return values;
    }

    private ArrayList<String> protocolLibrary() {
        ArrayList<String> pl = new ArrayList<>();
        pl.add("http");
        pl.add("https");
        return pl;
    }

    private ArrayList<String> domenLibrary() {
        Set<String> dl = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        dl.add("academy");
        dl.add("accountant");
        dl.add("accountants");
        dl.add("active");
        dl.add("actor");
        dl.add("adult");
        dl.add("aero");
        dl.add("agency");
        dl.add("airforce");
        dl.add("apartments");
        dl.add("app");
        dl.add("archi");
        dl.add("army");
        dl.add("associates");
        dl.add("asia");
        dl.add("attorney");
        dl.add("auction");
        dl.add("audio");
        dl.add("autos");
        dl.add("biz");
        dl.add("cat");
        dl.add("com");
        dl.add("coop");
        dl.add("edu");
        dl.add("gov");
        dl.add("info");
        dl.add("int");
        dl.add("jobs");
        dl.add("mil");
        dl.add("mobi");
        dl.add("museum");
        dl.add("name");
        dl.add("net");
        dl.add("one");
        dl.add("ong");
        dl.add("onl");
        dl.add("online");
        dl.add("ooo");
        dl.add("org");
        dl.add("organic");
        dl.add("partners");
        dl.add("parts");
        dl.add("party	");
        dl.add("pharmacy");
        dl.add("photo");
        dl.add("photography");
        dl.add("photos");
        dl.add("physio");
        dl.add("pics");
        dl.add("pictures");
        dl.add("feedback");
        dl.add("pink");
        dl.add("pizza");
        dl.add("place");
        dl.add("plumbing");
        dl.add("plus");
        dl.add("poker");
        dl.add("porn");
        dl.add("post");
        dl.add("press");
        dl.add("pro");
        dl.add("productions");
        dl.add("prof");
        dl.add("properties");
        dl.add("property");
        dl.add("qpon");
        dl.add("racing");
        dl.add("recipes");
        dl.add("red");
        dl.add("rehab");
        dl.add("ren");
        dl.add("rent");
        dl.add("rentals");
        dl.add("repair");
        dl.add("report");
        dl.add("republican");
        dl.add("rest");
        dl.add("review");
        dl.add("reviews");
        dl.add("rich");
        dl.add("site");
        dl.add("tel");
        dl.add("travel");
        dl.add("xxx");
        dl.add("xyz");
        dl.add("yoga");
        dl.add("zone");
        dl.add("ac");
        dl.add("ad");
        dl.add("ae");
        dl.add("af");
        dl.add("ag");
        dl.add("ai");
        dl.add("al");
        dl.add("am");
        dl.add("an");
        dl.add("ao");
        dl.add("aq");
        dl.add("ar");
        dl.add("as");
        dl.add("at");
        dl.add("au");
        dl.add("aw");
        dl.add("ax");
        dl.add("az");
        dl.add("ba");
        dl.add("bb");
        dl.add("bd");
        dl.add("be");
        dl.add("bf");
        dl.add("bg");
        dl.add("bh");
        dl.add("bi");
        dl.add("bj");
        dl.add("bm");
        dl.add("bn");
        dl.add("bo");
        dl.add("br");
        dl.add("bs");
        dl.add("bt");
        dl.add("bv");
        dl.add("bw");
        dl.add("by");
        dl.add("бел");
        dl.add("bz");
        dl.add("ca");
        dl.add("cc");
        dl.add("cd");
        dl.add("cf");
        dl.add("cg");
        dl.add("ch");
        dl.add("ci");
        dl.add("ck");
        dl.add("cl");
        dl.add("cm");
        dl.add("cn");
        dl.add("co");
        dl.add("cr");
        dl.add("cu");
        dl.add("cv");
        dl.add("cx");
        dl.add("cy");
        dl.add("cz");
        dl.add("dd");
        dl.add("de");
        dl.add("dj");
        dl.add("dk");
        dl.add("dm");
        dl.add("do");
        dl.add("dz");
        dl.add("ec");
        dl.add("ee");
        dl.add("eg");
        dl.add("er");
        dl.add("es");
        dl.add("et");
        dl.add("eu");
        dl.add("fi");
        dl.add("fj");
        dl.add("fk");
        dl.add("fm");
        dl.add("fo");
        dl.add("fr");
        dl.add("ga");
        dl.add("gb");
        dl.add("gd");
        dl.add("ge");
        dl.add("gf");
        dl.add("gg");
        dl.add("gh");
        dl.add("gi");
        dl.add("gl");
        dl.add("gm");
        dl.add("gn");
        dl.add("gp");
        dl.add("gq");
        dl.add("gr");
        dl.add("gs");
        dl.add("gt");
        dl.add("gu");
        dl.add("gw");
        dl.add("gy");
        dl.add("hk");
        dl.add("hm");
        dl.add("hn");
        dl.add("hr");
        dl.add("ht");
        dl.add("hu");
        dl.add("id");
        dl.add("ie");
        dl.add("il");
        dl.add("im");
        dl.add("in");
        dl.add("io");
        dl.add("iq");
        dl.add("ir");
        dl.add("is");
        dl.add("it");
        dl.add("je");
        dl.add("jm");
        dl.add("jo");
        dl.add("jp");
        dl.add("ke");
        dl.add("kg");
        dl.add("kh");
        dl.add("ki");
        dl.add("km");
        dl.add("kn");
        dl.add("kp");
        dl.add("kr");
        dl.add("krd");
        dl.add("kw");
        dl.add("ky");
        dl.add("kz");
        dl.add("la");
        dl.add("lb");
        dl.add("lc");
        dl.add("li");
        dl.add("lk");
        dl.add("lr");
        dl.add("ls");
        dl.add("lt");
        dl.add("lu");
        dl.add("lv");
        dl.add("ly");
        dl.add("ma");
        dl.add("mc");
        dl.add("md");
        dl.add("me");
        dl.add("mg");
        dl.add("mh");
        dl.add("mk");
        dl.add("ml");
        dl.add("mm");
        dl.add("mn");
        dl.add("мон");
        dl.add("mo");
        dl.add("mp");
        dl.add("mq");
        dl.add("mr");
        dl.add("ms");
        dl.add("mt");
        dl.add("mu");
        dl.add("mv");
        dl.add("mw");
        dl.add("mx");
        dl.add("my");
        dl.add("mz");
        dl.add("na");
        dl.add("nc");
        dl.add("ne");
        dl.add("nf");
        dl.add("ng");
        dl.add("ni");
        dl.add("nl");
        dl.add("no");
        dl.add("np");
        dl.add("nr");
        dl.add("nu");
        dl.add("nz");
        dl.add("om");
        dl.add("pa");
        dl.add("pe");
        dl.add("pf");
        dl.add("pg");
        dl.add("ph");
        dl.add("pk");
        dl.add("pl");
        dl.add("pm");
        dl.add("pn");
        dl.add("pr");
        dl.add("ps");
        dl.add("pt");
        dl.add("pw");
        dl.add("py");
        dl.add("qa");
        dl.add("re");
        dl.add("ro");
        dl.add("rs");
        dl.add("срб");
        dl.add("ru");
        dl.add("рф");
        dl.add("rw");
        dl.add("sa");
        dl.add("sb");
        dl.add("sc");
        dl.add("sd");
        dl.add("se");
        dl.add("sg");
        dl.add("sh");
        dl.add("si");
        dl.add("sj");
        dl.add("sk");
        dl.add("sl");
        dl.add("sm");
        dl.add("sn");
        dl.add("so");
        dl.add("sr");
        dl.add("st");
        dl.add("su");
        dl.add("sv");
        dl.add("sy");
        dl.add("sz");
        dl.add("tc");
        dl.add("td");
        dl.add("tf");
        dl.add("tg");
        dl.add("th");
        dl.add("tj");
        dl.add("tk");
        dl.add("tl");
        dl.add("tm");
        dl.add("tn");
        dl.add("to");
        dl.add("tp");
        dl.add("tr");
        dl.add("tt");
        dl.add("tv");
        dl.add("tw");
        dl.add("tz");
        dl.add("ua");
        dl.add("укр");
        dl.add("ug");
        dl.add("uk");
        dl.add("us");
        dl.add("uy");
        dl.add("uz");
        dl.add("va");
        dl.add("vc");
        dl.add("ve");
        dl.add("vg");
        dl.add("vi");
        dl.add("vn");
        dl.add("vu");
        dl.add("wf");
        dl.add("ws");
        dl.add("ye");
        dl.add("yt");
        dl.add("za");
        dl.add("zm");
        dl.add("zw");

        list.addAll(dl);
        return list;
    }

}
