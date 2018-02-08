package ru.denya.fishing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    private void discoverFile(String txt) {
        try {
            File folder = new File("D://fishing23//");
            if (!folder.exists()) {
                boolean created = folder.mkdir();
                if (created) {
                    //ok
                }
            }
            File file = new File(folder, "asd.txt");
            FileWriter fw = new FileWriter(file, true);
            if (!file.exists()) {
                file.createNewFile();
                fw.append(txt + "\r\n");
            } else {
                fw.write(txt + "\r\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int fuctorial(int n) {
        return (n > 0) ? n * fuctorial(n - 1) : 1;
    }

    private void loadNameLibrary(String host) {
        String name = getHostName(host);
        String[] arr = new String[name.length()];
        for (int i = 0; i < name.length(); i++) {
            arr[i] = String.valueOf(name.charAt(i));
        }
        int size = arr.length;
        int temp = 0;
        Set<String> nameLibraryHashSet = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        //подсчет повторений
        for (int i = 0; i < size; i++) {
            list.add(arr[i]);
            for (int j = 0; j < size; j++) {
                if (arr[i].equalsIgnoreCase(arr[j]) && (i != j)) {
                    temp++;
                }
            }
        }

        if (temp == 0) {
            temp = 1;
        }
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
        nameLibrary.addAll(nameLibraryHashSet);

        list.removeAll(list);
        for (int i = 0; i < size; i++) {
            list.add(arr[i]);
        }
        Set<String> copyNameLibraryHashSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < copyNameLibrary().size(); j++) {
                if (list.get(i).equalsIgnoreCase(copyNameLibrary().get(j).value1)) {
                    list.set(i, copyNameLibrary().get(j).value2);
                    System.out.println(copyNameLibrary().get(j).value1 + " = " + copyNameLibrary().get(j).value2);
                    copyNameLibraryHashSet.add(getTxt(list));
                    copyNameLibraryHashSet.addAll(generateCopies(list));
                    list.set(i, arr[i]);
                }
                if (list.get(i).equalsIgnoreCase(copyNameLibrary().get(j).value2)) {
                    list.set(i, copyNameLibrary().get(j).value1);
                    System.out.println(copyNameLibrary().get(j).value2 + " = " + copyNameLibrary().get(j).value1);
                    copyNameLibraryHashSet.add(getTxt(list));
                    copyNameLibraryHashSet.addAll(generateCopies(list));
                    list.set(i, arr[i]);
                }

            }
        }

        //System.out.println(copyNameLibraryHashSet.size());
        //System.out.println(copyNameLibraryHashSet);

        nameLibrary.addAll(copyNameLibraryHashSet);
        //System.out.println(nameLibrary.size());
    }

    private static ArrayList<String> generateCopies(ArrayList<String> list) {
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < copyNameLibrary().size(); j++) {
                if (list.get(i).equalsIgnoreCase(copyNameLibrary().get(j).value1)) {
                    list.set(i, copyNameLibrary().get(j).value2);
                    arr.add(getTxt(list));
                    list.set(i, copyNameLibrary().get(j).value1);
                }
                if (list.get(i).equalsIgnoreCase(copyNameLibrary().get(j).value2)) {
                    list.set(i, copyNameLibrary().get(j).value1);
                    arr.add(getTxt(list));
                    list.set(i, copyNameLibrary().get(j).value2);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < copyNameLibrary().size(); j++) {
                if (list.get(i).equalsIgnoreCase(copyNameLibrary().get(j).value1)) {
                    list.set(i, copyNameLibrary().get(j).value2);
                }
                arr.add(getTxt(list));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < copyNameLibrary().size(); j++) {
                if (list.get(i).equalsIgnoreCase(copyNameLibrary().get(j).value2)) {
                    list.set(i, copyNameLibrary().get(j).value1);
                }
                arr.add(getTxt(list));
            }
        }


        return arr;
    }

    static String getTxt(ArrayList<String> list) {
        String asd = "";
        for (int i = 0; i < list.size(); i++) {
            asd += list.get(i);
        }

        return asd;
    }

    public void startSearch(String protocol, String host) {
        loadNameLibrary(host);
        int all = protocolLibrary().size() * nameLibrary.size() * domenLibrary().size();

        /*for (int i = 0; i < protocolLibrary().size(); i++) {
            for (int j = 0; j < nameLibrary.size(); j++) {
                for (int k = 0; k < domenLibrary().size(); k++) {

                    int finalI = i;
                    int finalJ = j;
                    int finalK = k;
                    Thread th = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Inetwork inetwork = new Inetwork();
                            inetwork.loadPage(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK));
                            if (!inetwork.getResponceCode().equalsIgnoreCase("404")) {
                                System.out.println("Найден: " + protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode());
                                discoverFile(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK));
                            } else {
                                System.out.println("Проверка: " + protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK));
                            }
                        }
                    });
                    th.start();




                }
            }
        }*/
    }

    private static String getHostDomen(String host) {
        return host.substring(host.lastIndexOf(".") + 1);
    }

    private static String getHostName(String host) {
        return host.substring(0, host.lastIndexOf("."));
    }

    private ArrayList<String> nameLibrary = new ArrayList<>();

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
